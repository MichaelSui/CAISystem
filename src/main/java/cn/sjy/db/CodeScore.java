package cn.sjy.db;

import java.io.Serializable;

public class CodeScore implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private int questionId;
    private int score;

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public int getQuestionId() {
	return questionId;
    }

    public void setQuestionId(int questionId) {
	this.questionId = questionId;
    }

    public int getScore() {
	return score;
    }

    public void setScore(int score) {
	this.score = score;
    }

}
