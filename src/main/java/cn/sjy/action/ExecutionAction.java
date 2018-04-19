package cn.sjy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import cn.sjy.utils.FileUtils;

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
	this.code = code;
    }

    public String execute() throws Exception {
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> httpSession = actionContext.getSession();
	String userId = (String) httpSession.get("userId");
	// TODO
	String directory = "C:\\Users\\Michael\\Documents\\docker\\" + question;
	String fileName = userId + ".cpp";
	boolean writeFlag = FileUtils.writeFile(directory, fileName, code);

	// Create a client based on DOCKER_HOST and DOCKER_CERT_PATH env vars
	final DockerClient docker = DefaultDockerClient.fromEnv().build();

	// Bind container ports to host ports
	final String[] ports = { "80", "2222" };
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

	final HostConfig hostConfig = HostConfig.builder().portBindings(portBindings)
		.appendBinds(Bind.from("/C/Users/Michael/Documents/docker").to("/home").build()).build();

	// Create container with exposed ports
	final ContainerConfig containerConfig = ContainerConfig.builder().hostConfig(hostConfig)
		.image("michaelsui/caisystem").exposedPorts(ports).cmd("sh", "-c", "while :; do sleep 1; done").build();

	final ContainerCreation creation = docker.createContainer(containerConfig);
	final String id = creation.id();

	// Inspect container
	final ContainerInfo info = docker.inspectContainer(id);

	// Start container
	docker.startContainer(id);

	// Exec command inside running container with attached STDOUT and STDERR
	directory = "/home/" + question;
	fileName = userId + ".cpp";
	String targetName = userId + ".o";
	String[] command = { "sh", "-c",
		"timeout 10 g++ -c " + directory + "/" + fileName + " -o " + directory + "/" + targetName };
	ExecCreation execCreation = docker.execCreate(id, command, DockerClient.ExecCreateParam.attachStdout(),
		DockerClient.ExecCreateParam.attachStderr());
	LogStream output = docker.execStart(execCreation.id());
	String execOutput = output.readFully();
	System.out.println(execOutput);

	fileName = targetName;
	targetName = userId;
	command = new String[] { "sh", "-c",
		"timeout 10 g++ " + directory + "/" + fileName + " -o " + directory + "/" + targetName };
	execCreation = docker.execCreate(id, command, DockerClient.ExecCreateParam.attachStdout(),
		DockerClient.ExecCreateParam.attachStderr());
	output = docker.execStart(execCreation.id());
	execOutput = output.readFully();
	System.out.println(execOutput);

	command = new String[] { "sh", "-c", "timeout 10 " + directory + "/" + targetName };
	execCreation = docker.execCreate(id, command, DockerClient.ExecCreateParam.attachStdout(),
		DockerClient.ExecCreateParam.attachStderr());
	output = docker.execStart(execCreation.id());
	execOutput = output.readFully();
	System.out.println(execOutput);

	// Kill container
	docker.killContainer(id);

	// Remove container
	docker.removeContainer(id);

	// Close the docker client
	docker.close();
	return "success";
    }
}
