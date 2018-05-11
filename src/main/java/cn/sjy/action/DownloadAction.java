package cn.sjy.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private String fileName;

    // get和set的方法必须这样写，否则就会产生乱码。
    public String getFileName() {
	try {
	    fileName = new String(fileName.getBytes(), "ISO8859-1");
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
	return fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }

    // 在这里设置上传和下载的目录。
    public InputStream getInputStream() throws UnsupportedEncodingException {
	System.out.println(fileName);
	InputStream inputStream = ServletActionContext.getServletContext()
		.getResourceAsStream("/files/uploadAndDownloadFiles/" + fileName);
	return inputStream;
    }

    public String download() {
	return "success";
    }
}
