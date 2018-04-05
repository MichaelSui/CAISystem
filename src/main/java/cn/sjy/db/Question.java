package cn.sjy.db;

import java.io.Serializable;

public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String questionName;
    private String questionDetails;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getQuestionName() {
	return questionName;
    }

    public void setQuestionName(String questionName) {
	this.questionName = questionName;
    }

    public String getQuestionDetails() {
	return questionDetails;
    }

    public void setQuestionDetails(String questionDetails) {
	this.questionDetails = questionDetails;
    }
}
