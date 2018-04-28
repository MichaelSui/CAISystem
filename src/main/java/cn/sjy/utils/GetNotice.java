package cn.sjy.utils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.sjy.db.Notice;

public class GetNotice {
    public static ArrayList<String> getDates() {
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

	Query query = session.createQuery("from Notice");
	List<Notice> list = query.list();
	ArrayList<String> dates = new ArrayList<>();
	for (int i = 0; i < list.size(); i++) {
	    Notice n = list.get(i);
	    String date = n.getDate().toString();
	    dates.add(date);
	}

	tx.commit();
	session.close();

	return dates;
    }

    public static ArrayList<String> getNotices() {
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

	Query query = session.createQuery("from Notice");
	List<Notice> list = query.list();
	ArrayList<String> notices = new ArrayList<>();
	for (int i = 0; i < list.size(); i++) {
	    Notice n = list.get(i);
	    String content = n.getContent();
	    notices.add(content);
	}

	tx.commit();
	session.close();

	return notices;
    }
}
