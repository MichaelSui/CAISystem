package cn.sjy.db;

import java.io.Serializable;

public class QuestionExample implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
     * questionId是问题序号， exampleId是用例序号， input是用例输入参数， output是用例预期输出。
     */
    private int questionId;
    private int exampleId;
    private String input;
    private String output;

    public int getQuestionId() {
	return questionId;
    }

    public void setQuestionId(int questionId) {
	this.questionId = questionId;
    }

    public int getExampleId() {
	return exampleId;
    }

    public void setExampleId(int exampleId) {
	this.exampleId = exampleId;
    }

    public String getInput() {
	return input;
    }

    public void setInput(String input) {
	this.input = input;
    }

    public String getOutput() {
	return output;
    }

    public void setOutput(String output) {
	this.output = output;
    }

}
