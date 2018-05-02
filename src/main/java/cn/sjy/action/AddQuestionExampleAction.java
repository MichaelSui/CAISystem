package cn.sjy.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.sjy.db.QuestionExample;
import cn.sjy.utils.HibernateUtil;

public class AddQuestionExampleAction {
    private String addQuestionExampleQuestionId;
    private String addQuestionExampleInput;
    private String addQuestionExampleOutput;

    public String getAddQuestionExampleQuestionId() {
	return addQuestionExampleQuestionId;
    }

    public void setAddQuestionExampleQuestionId(String addQuestionExampleQuestionId) {
	this.addQuestionExampleQuestionId = addQuestionExampleQuestionId;
    }

    public String getAddQuestionExampleInput() {
	return addQuestionExampleInput;
    }

    public void setAddQuestionExampleInput(String addQuestionExampleInput) {
	this.addQuestionExampleInput = addQuestionExampleInput;
    }

    public String getAddQuestionExampleOutput() {
	return addQuestionExampleOutput;
    }

    public void setAddQuestionExampleOutput(String addQuestionExampleOutput) {
	this.addQuestionExampleOutput = addQuestionExampleOutput;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    // 添加用例。
	    // exampleId本应是自增的属性，没有找到相应的配置方法，因此手动模拟这一过程。
	    Query query = session.createQuery("from QuestionExample");
	    List<QuestionExample> list = query.list();
	    int maxExampleId = 0;
	    for (int i = 0; i < list.size(); i++) {
		QuestionExample qe = list.get(i);
		maxExampleId = qe.getExampleId() > maxExampleId ? qe.getExampleId() : maxExampleId;
	    }
	    QuestionExample qe = new QuestionExample();
	    qe.setQuestionId(Integer.parseInt(addQuestionExampleQuestionId));
	    qe.setExampleId(maxExampleId + 1);
	    qe.setInput(addQuestionExampleInput);
	    qe.setOutput(addQuestionExampleOutput);
	    session.save(qe);

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    return "error";
	}
    }
}
