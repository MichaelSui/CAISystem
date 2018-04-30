package cn.sjy.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.User;
import cn.sjy.utils.HibernateUtil;

public class ChangePasswordAction {
    private String oldPassword;
    private String newPassword1;
    private String newPassword2;

    public String getOldPassword() {
	return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
	this.oldPassword = oldPassword;
    }

    public String getNewPassword1() {
	return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
	this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
	return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
	this.newPassword2 = newPassword2;
    }

    public String execute() throws Exception {
	// 检验两个新密码是否一致。
	if (!newPassword1.equals(newPassword2)) {
	    return "error";
	}

	// 检验旧密码是否正确
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> httpSession = actionContext.getSession();
	String userId = httpSession.get("userId").toString();

	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

	Query query = session.createQuery("from User u where u.id = :id");
	query.setParameter("id", userId);
	List<User> list = query.list();
	if (!list.get(0).getPassword().equals(oldPassword)) {
	    tx.commit();
	    session.close();

	    return "error";
	}
	String authority = list.get(0).getAuthority();
	session.clear();

	// 修改密码
	User u = new User();
	u.setId(userId);
	u.setPassword(newPassword1);
	u.setAuthority(authority);
	session.update(u);

	tx.commit();
	session.close();

	return "success";
    }
}
