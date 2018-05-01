package cn.sjy.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.sjy.db.Information;
import cn.sjy.db.User;
import cn.sjy.utils.Authority;
import cn.sjy.utils.HibernateUtil;

public class AddUserAction {
    private String userId;

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String execute() throws Exception {
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

	// 添加一个学生。
	// 先看当前的userId是否已经被占用。
	String hql = "from User u where u.id = :id";
	Query query = session.createQuery(hql);
	query.setParameter("id", userId);
	List<User> list = query.list();
	if (!list.isEmpty()) {
	    // 当该userId已经被占用时不再新建用户，直接跳过。
	    return "success";
	}

	User u = new User();
	u.setId(userId);
	u.setPassword("000000");
	u.setAuthority(Authority.STUDENT.toString());
	session.save(u);
	Information i = new Information();
	i.setUserId(userId);
	session.save(i);

	tx.commit();
	session.close();

	return "success";
    }
}
