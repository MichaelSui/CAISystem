package cn.sjy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class GoToAboutAction {
    public String execute() throws Exception {
	try {
	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();

	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    httpSession.put("errorMsg", "GoToAboutAction抛出了异常");
	    return "error";
	}
    }
}
