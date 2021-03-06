package cn.sjy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.LogStream;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.ContainerInfo;
import com.spotify.docker.client.messages.ExecCreation;
import com.spotify.docker.client.messages.HostConfig;
import com.spotify.docker.client.messages.PortBinding;
import com.spotify.docker.client.messages.HostConfig.Bind;

import cn.sjy.db.CodeScore;
import cn.sjy.db.QuestionExample;
import cn.sjy.utils.FileUtils;
import cn.sjy.utils.HibernateUtil;

public class ExecutionAction {
    private String question;
    private String code;

    public String getQuestion() {
	return question;
    }

    public void setQuestion(String question) {
	this.question = question;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code.replaceAll("\r\n", "\n");
    }

    public String execute() throws Exception {
	try {
	    // 在docker容器中运行c++程序。
	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    String userId = (String) httpSession.get("userId");
	    String realpath = ServletActionContext.getServletContext().getRealPath("/files/dockerFiles");
	    String directory = realpath + "/" + question;
	    String fileName = userId + ".cpp";
	    boolean deleteAllFlag = FileUtils.deleteAllFile(directory, userId);
	    boolean writeFlag = FileUtils.writeFile(directory, fileName, code);

	    // Create a client based on DOCKER_HOST and DOCKER_CERT_PATH env vars
	    final DockerClient docker = DefaultDockerClient.fromEnv().build();

	    Map<String, Object> application = actionContext.getApplication();
	    // 获取一个可用端口。
	    int availablePort1 = 10000;
	    int availablePort2 = 20000;
	    synchronized (application) {
		if (application.get("availablePort1") != null) {
		    availablePort1 = Integer.parseInt(application.get("availablePort1").toString()) + 1;
		    if (availablePort1 == 20000) {
			availablePort1 -= 10000;
		    }
		}
		application.put("availablePort1", availablePort1);

		if (application.get("availablePort2") != null) {
		    availablePort2 = Integer.parseInt(application.get("availablePort2").toString()) + 1;
		    if (availablePort2 == 30000) {
			availablePort2 -= 10000;
		    }
		}
		application.put("availablePort2", availablePort2);
	    }
	    // System.out.println("port1:" + availablePort1 + " port2:" + availablePort2);

	    // Bind container ports to host ports
	    final String[] ports = { String.valueOf(availablePort1), String.valueOf(availablePort2) };
	    final Map<String, List<PortBinding>> portBindings = new HashMap<>();
	    for (String port : ports) {
		List<PortBinding> hostPorts = new ArrayList<>();
		hostPorts.add(PortBinding.of("0.0.0.0", port));
		portBindings.put(port, hostPorts);
	    }

	    // Bind container port 443 to an automatically allocated available host port.
	    List<PortBinding> randomPort = new ArrayList<>();
	    randomPort.add(PortBinding.randomPort("0.0.0.0"));
	    portBindings.put("443", randomPort);

	    String dockerMountPath = realpath;
	    dockerMountPath = dockerMountPath.replaceAll(":", "");
	    dockerMountPath = dockerMountPath.replaceAll("\\\\", "/");
	    dockerMountPath = "/" + dockerMountPath;
	    final HostConfig hostConfig = HostConfig.builder().portBindings(portBindings)
		    .appendBinds(Bind.from(dockerMountPath).to("/home").build()).build();

	    // Create container with exposed ports
	    final ContainerConfig containerConfig = ContainerConfig.builder().hostConfig(hostConfig)
		    .image("michaelsui/caisystem").exposedPorts(ports).cmd("sh", "-c", "while :; do sleep 1; done")
		    .build();

	    final ContainerCreation creation = docker.createContainer(containerConfig);
	    final String id = creation.id();

	    // Inspect container
	    final ContainerInfo info = docker.inspectContainer(id);

	    // Start container
	    docker.startContainer(id);

	    // Exec command inside running container with attached STDOUT and STDERR
	    directory = "/home/" + question;
	    fileName = userId + ".cpp";
	    String targetName = userId;
	    String[] command = { "sh", "-c",
		    "timeout 10 g++ " + directory + "/" + fileName + " -o " + directory + "/" + targetName };
	    ExecCreation execCreation = docker.execCreate(id, command, DockerClient.ExecCreateParam.attachStdout(),
		    DockerClient.ExecCreateParam.attachStderr());
	    LogStream output = docker.execStart(execCreation.id());
	    String execOutput = output.readFully();
	    StringBuilder msg = new StringBuilder();
	    msg.append(execOutput);

	    // 程序正常执行还不够，必须从数据库中调取相应的测试用例，根据完成测试用例的数量进行打分。
	    int questionId = Integer.parseInt(question.replace("question", "").trim());

	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    String hql = "from QuestionExample qe where qe.questionId = :questionId";
	    Query query = session.createQuery(hql);
	    query.setParameter("questionId", questionId);

	    int correctCount = 0;
	    int errorCount = 0;
	    List<QuestionExample> list = query.list();
	    for (QuestionExample questionExample : list) {
		command = new String[] { "sh", "-c",
			"timeout 10 " + directory + "/" + targetName + " " + questionExample.getInput() };
		execCreation = docker.execCreate(id, command, DockerClient.ExecCreateParam.attachStdout(),
			DockerClient.ExecCreateParam.attachStderr());
		output = docker.execStart(execCreation.id());
		execOutput = output.readFully();
		msg.append(execOutput);
		execOutput = execOutput.replaceAll("\n", "");
		if (execOutput.endsWith(questionExample.getOutput())) {
		    correctCount++;
		} else {
		    errorCount++;
		}
	    }
	    int score = 0;
	    if (correctCount + errorCount != 0) {
		score = (int) ((double) correctCount / (correctCount + errorCount) * 100);
	    } else {
		score = 100;
	    }
	    HttpServletRequest httpServletRequest = (HttpServletRequest) actionContext
		    .get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	    httpServletRequest.setAttribute("correctCount", correctCount);
	    httpServletRequest.setAttribute("errorCount", errorCount);
	    httpServletRequest.setAttribute("allCount", correctCount + errorCount);
	    httpServletRequest.setAttribute("score", score);
	    httpServletRequest.setAttribute("msg", msg.toString().replaceAll("\n", "<br />"));

	    // 将最终成绩保存到数据库。
	    CodeScore cs = new CodeScore();
	    cs.setUserId(userId);
	    cs.setQuestionId(questionId);
	    cs.setScore(score);
	    session.saveOrUpdate(cs);

	    tx.commit();
	    session.close();

	    // Kill container
	    docker.killContainer(id);

	    // Remove container
	    docker.removeContainer(id);

	    // Close the docker client
	    docker.close();

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();

	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    httpSession.put("errorMsg", "ExecuteAction抛出了异常");
	    return "error";
	}
    }
}
