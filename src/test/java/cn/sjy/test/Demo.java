package cn.sjy.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

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
}
