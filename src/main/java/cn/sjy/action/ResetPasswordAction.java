package cn.sjy.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.sjy.db.User;
import cn.sjy.utils.HibernateUtil;

public class ResetPasswordAction {
    private String userId;

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    // 先查看被修改的用户的身份，教师只能重置学生的密码。
	    String hql = "from User u where u.id = :id";
	    Query query = session.createQuery(hql);
	    query.setParameter("id", userId);
	    List<User> list = query.list();
	    if (list.isEmpty() || !list.get(0).getAuthority().equals("STUDENT")) {
		tx.commit();
		session.close();

		return "error";
	    }

	    // 重置密码操作。
	    User u = new User();
	    u.setId(userId);
	    u.setPassword("000000");
	    u.setAuthority(list.get(0).getAuthority());
	    session.clear();
	    session.update(u);

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "error";
	}
    }
}
