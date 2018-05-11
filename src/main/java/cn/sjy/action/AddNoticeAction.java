package cn.sjy.action;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.sjy.db.Notice;
import cn.sjy.utils.HibernateUtil;

public class AddNoticeAction {
    private String content;

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    Notice n = new Notice();
	    n.setDate(new Date());
	    n.setContent(content);
	    session.save(n);

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "error";
	}
    }
}
