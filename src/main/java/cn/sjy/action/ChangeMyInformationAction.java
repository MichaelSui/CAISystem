package cn.sjy.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.sjy.db.Information;
import cn.sjy.utils.HibernateUtil;

public class ChangeMyInformationAction {
    private String userId;
    private String name;
    private String email;
    private String phone;
    private String qqOrTim;
    private String wechat;

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getQqOrTim() {
	return qqOrTim;
    }

    public void setQqOrTim(String qqOrTim) {
	this.qqOrTim = qqOrTim;
    }

    public String getWechat() {
	return wechat;
    }

    public void setWechat(String wechat) {
	this.wechat = wechat;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction transaction = session.beginTransaction();

	    // 修改个人信息。
	    Information i = new Information();
	    i.setUserId(userId);
	    i.setName(name);
	    i.setEmail(email);
	    i.setPhone(phone);
	    i.setQqOrTim(qqOrTim);
	    i.setWechat(wechat);
	    session.update(i);

	    transaction.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    return "error";
	}
    }

}
