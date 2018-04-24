package cn.sjy.db;

import java.io.Serializable;

public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;
    private int problemId;
    private int replyId;
    private String userId;
    private String content;

    public int getProblemId() {
	return problemId;
    }

    public void setProblemId(int problemId) {
	this.problemId = problemId;
    }

    public int getReplyId() {
	return replyId;
    }

    public void setReplyId(int replyId) {
	this.replyId = replyId;
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
