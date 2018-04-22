package cn.sjy.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
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
	String realpath = ServletActionContext.getServletContext().getRealPath("/uploadAndDownloadFiles");

	// 判断上传文件是否为空
	if (uploadFile != null) {
	    // 设置目标文件（根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例）
	    System.out.println(realpath + uploadFileFileName);
	    File savefile = new File(realpath, uploadFileFileName);

	    // 判断上传目录是否存在
	    if (!savefile.getParentFile().exists())
		savefile.getParentFile().mkdirs();

	    // 把文件uploadfile 拷贝到 savefile 里,FileUtils类需要commons-io-x.x.x.jar包支持
	    FileUtils.copyFile(uploadFile, savefile);
	}
	return "success";
    }
}
