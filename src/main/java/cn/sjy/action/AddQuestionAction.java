package cn.sjy.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.sjy.db.Question;
import cn.sjy.utils.HibernateUtil;

public class AddQuestionAction {
    private String addQuestionName;
    private String addQuestionDetails;

    public String getAddQuestionName() {
	return addQuestionName;
    }

    public void setAddQuestionName(String addQuestionName) {
	this.addQuestionName = addQuestionName;
    }

    public String getAddQuestionDetails() {
	return addQuestionDetails;
    }

    public void setAddQuestionDetails(String addQuestionDetails) {
	this.addQuestionDetails = addQuestionDetails;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    // 添加试题。
	    Question q = new Question();
	    q.setQuestionName(addQuestionName);
	    q.setQuestionDetails(addQuestionDetails);
	    session.save(q);

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "error";
	}
    }
}
