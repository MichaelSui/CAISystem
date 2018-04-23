package cn.sjy.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private String fileName;

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
