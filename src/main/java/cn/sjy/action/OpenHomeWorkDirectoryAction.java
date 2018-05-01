package cn.sjy.action;

import org.apache.struts2.ServletActionContext;

import cn.sjy.utils.FileUtils;

public class OpenHomeWorkDirectoryAction {
    public String execute() throws Exception {
	// 打开作业所在的目录。
	String path = ServletActionContext.getServletContext().getRealPath("/files/handInHomeWorkFiles");
	FileUtils.openDirectory(path);
	return "success";
    }
}
