package cn.sjy.action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

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
    }
}
