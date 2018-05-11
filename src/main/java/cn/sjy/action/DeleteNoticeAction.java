package cn.sjy.action;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.sjy.utils.HibernateUtil;

public class DeleteNoticeAction {
    private String date;

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    // 删除题目。
	    String hql = "delete from Notice n where n.date = :date";
	    Query query = session.createQuery(hql);
	    query.setParameter("date", Timestamp.valueOf(date));
	    query.executeUpdate();

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "error";
	}
    }
}
