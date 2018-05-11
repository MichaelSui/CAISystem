package cn.sjy.action;

import org.apache.struts2.ServletActionContext;

import cn.sjy.utils.FileUtils;

public class OpenUploadAndDownloadFilesDirectoryAction {
    public String execute() throws Exception {
	try {
	    // 打开资源所在的目录。
	    String path = ServletActionContext.getServletContext().getRealPath("/files/uploadAndDownloadFiles");
	    FileUtils.openDirectory(path);
	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "error";
	}
    }
}
