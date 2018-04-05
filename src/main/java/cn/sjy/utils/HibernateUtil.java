package cn.sjy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * Hibernate开发的工具类。
 */
public class HibernateUtil {
    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    static {
	configuration = new Configuration();
	configuration.configure();
	sessionFactory = configuration.buildSessionFactory();
    }

    /**
     * 让外部获取Session对象
     */
    public static Session getSession() {
	return sessionFactory.openSession();
    }
}
