package cn.sjy.db;

import java.io.Serializable;

public class Problem implements Serializable {
    private static final long serialVersionUID = 1L;
    private int problemId;
    private String userId;
    private String content;

    public int getProblemId() {
	return problemId;
    }

    public void setProblemId(int problemId) {
	this.problemId = problemId;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

}
