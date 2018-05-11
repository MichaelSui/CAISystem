package cn.sjy.action;

public class GoToLogInAction {
    public String execute() throws Exception {
	try {
	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "error";
	}
    }
}
