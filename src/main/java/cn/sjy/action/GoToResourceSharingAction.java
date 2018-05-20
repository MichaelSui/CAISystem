package cn.sjy.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.utils.FileUtils;

public class GoToResourceSharingAction {
    // 可以在这里设置资源共享的目录。
    public String execute() throws Exception {
	try {
	    String path = ServletActionContext.getServletContext().getRealPath("/files/uploadAndDownloadFiles");
	    String[] fileList = FileUtils.getAllFileName(path);
	    ActionContext actionContext = ActionContext.getContext();
	    HttpServletRequest httpServletRequest = (HttpServletRequest) actionContext
		    .get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	    httpServletRequest.setAttribute("fileList", fileList);

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();

	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    httpSession.put("errorMsg", "GoToResourceSharingAction抛出了异常");
	    return "error";
	}
    }
}
