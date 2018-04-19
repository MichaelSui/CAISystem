package cn.sjy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

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
	String path = "C:\\Users\\Michael\\Documents\\docker\\" + question + "\\" + userId + ".cpp";
	boolean writeFlag = FileUtils.writeFile(path, code);
	return "success";
    }
}
