package cn.sjy.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.User;
import cn.sjy.utils.HibernateUtil;

/*
 * 登陆相关逻辑。用户名和密码正误的判断和Session信息的保存。
 */
public class LoginAction {
    private String id;
    private String password;
    private String remember;

    public String getRemember() {
	return remember;
    }

    public void setRemember(String remember) {
	this.remember = remember;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String execute() throws Exception {
	/*
	 * 记住密码功能。
	 */
	System.out.println(remember);

	/*
	 * 用户名和密码正误的判断和Session信息的保存。
	 */
	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	String hql = "from User user where user.id = :id and user.password = :password";
	Query query = session.createQuery(hql);
	query.setParameter("id", id);
	query.setParameter("password", password);
	List<User> list = query.list();
	if (!list.isEmpty()) {
	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    User user = list.get(0);
	    httpSession.put("userId", user.getId());
	    httpSession.put("userAuthority", user.getAuthority());
	    transaction.commit();
	    session.close();
	    return Action.SUCCESS;
	} else {
	    transaction.commit();
	    session.close();
	    return Action.ERROR;
	}
    }
}
