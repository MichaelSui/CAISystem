package cn.sjy.action;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.utils.HibernateUtil;

public class DeleteQuestionAction {
    private String deleteQuestionId;

    public String getDeleteQuestionId() {
	return deleteQuestionId;
    }

    public void setDeleteQuestionId(String deleteQuestionId) {
	this.deleteQuestionId = deleteQuestionId;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    // 删除题目。
	    String hql = "delete from Question q where q.id = :id";
	    Query query = session.createQuery(hql);
	    query.setParameter("id", Integer.parseInt(deleteQuestionId));
	    query.executeUpdate();

	    // 删除题目时同时会删除对应的用例。
	    hql = "delete from QuestionExample qe where qe.questionId = :questionId";
	    query = session.createQuery(hql);
	    query.setParameter("questionId", Integer.parseInt(deleteQuestionId));
	    query.executeUpdate();

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();

	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    httpSession.put("errorMsg", "DeleteQuestionAction抛出了异常");
	    return "error";
	}
    }
}
