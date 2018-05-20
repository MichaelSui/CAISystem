package cn.sjy.action;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.utils.HibernateUtil;

public class DeleteQuestionExampleAction {
    private String deleteQuestionExampleQuestionId;
    private String deleteQuestionExampleExampleId;

    public String getDeleteQuestionExampleQuestionId() {
	return deleteQuestionExampleQuestionId;
    }

    public void setDeleteQuestionExampleQuestionId(String deleteQuestionExampleQuestionId) {
	this.deleteQuestionExampleQuestionId = deleteQuestionExampleQuestionId;
    }

    public String getDeleteQuestionExampleExampleId() {
	return deleteQuestionExampleExampleId;
    }

    public void setDeleteQuestionExampleExampleId(String deleteQuestionExampleExampleId) {
	this.deleteQuestionExampleExampleId = deleteQuestionExampleExampleId;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    // 删除用例。
	    String hql = "delete from QuestionExample qe where qe.questionId = :questionId and qe.exampleId = :exampleId";
	    Query query = session.createQuery(hql);
	    query.setParameter("questionId", Integer.parseInt(deleteQuestionExampleQuestionId));
	    query.setParameter("exampleId", Integer.parseInt(deleteQuestionExampleExampleId));
	    query.executeUpdate();

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();

	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    httpSession.put("errorMsg", "DeleteQuestionExampleAction抛出了异常");
	    return "error";
	}
    }
}
