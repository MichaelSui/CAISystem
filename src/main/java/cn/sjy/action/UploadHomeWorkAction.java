package cn.sjy.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadHomeWorkAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName;

    public File getUploadFile() {
	return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
	this.uploadFile = uploadFile;
    }

    public String getUploadFileContentType() {
	return uploadFileContentType;
    }

    public void setUploadFileContentType(String uploadFileContentType) {
	this.uploadFileContentType = uploadFileContentType;
    }

    public String getUploadFileFileName() {
	return uploadFileFileName;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
	this.uploadFileFileName = uploadFileFileName;
    }

    // 方法一：使用FileUtils的copyFile来实现文件上传
    public String upload() throws IOException {
	// 设置上传文件目录
	String realpath = ServletActionContext.getServletContext().getRealPath("/files/handInHomeWorkFiles");

	// 判断上传文件是否为空
	if (uploadFile != null) {
	    // 提交的作业后面添加提交人的id。
	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    String userId = httpSession.get("userId").toString();

	    // 设置目标文件（根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例）
	    File savefile = null;
	    if (uploadFileFileName.lastIndexOf(".") == -1) {
		savefile = new File(realpath, uploadFileFileName);
	    } else {
		int dotNum = uploadFileFileName.lastIndexOf(".");
		String newName = uploadFileFileName.substring(0, dotNum) + "_" + userId
			+ uploadFileFileName.substring(dotNum);
		savefile = new File(realpath, newName);
	    }

	    // 判断上传目录是否存在
	    if (!savefile.getParentFile().exists())
		savefile.getParentFile().mkdirs();

	    Map<String, Object> application = actionContext.getApplication();
	    synchronized (application) {
		// 名字重复的文件按照windows系统的命名方式在后面添加小括号和数字。
		for (int i = 2; savefile.exists(); i++) {
		    String newName = null;
		    if (uploadFileFileName.lastIndexOf(".") == -1) {
			newName = uploadFileFileName + "_" + userId + "(" + i + ")";
		    } else {
			int dotNum = uploadFileFileName.lastIndexOf(".");
			newName = uploadFileFileName.substring(0, dotNum) + "_" + userId + "(" + i + ")"
				+ uploadFileFileName.substring(dotNum);
		    }
		    savefile = new File(realpath, newName);
		}
		System.out.println(this.toString() + " " + savefile.toString());

		// 把文件uploadfile 拷贝到 savefile 里,FileUtils类需要commons-io-x.x.x.jar包支持
		FileUtils.copyFile(uploadFile, savefile);
	    }
	}
	return "success";
    }
}
