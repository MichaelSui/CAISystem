package cn.sjy.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.sjy.db.Question;
import cn.sjy.db.User;
import cn.sjy.utils.HibernateUtil;

public class Demo {
    @Test
    public void test1() {
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

	Query query = session.createQuery("from User");
	List<User> list = query.list();
	for (User user : list) {
	    System.out.println(user.toString());
	}

	tx.commit();
	session.close();
    }

    @Test
    public void test2() {
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

	Query query = session.createQuery("from Question");
	List<Question> list = query.list();
	for (Question question : list) {
	    System.out.println(question.toString());
	}

	tx.commit();
	session.close();
    }
}
