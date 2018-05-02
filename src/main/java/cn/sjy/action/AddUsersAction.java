package cn.sjy.action;

import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.sjy.db.Information;
import cn.sjy.db.User;
import cn.sjy.utils.Authority;
import cn.sjy.utils.HibernateUtil;

public class AddUsersAction {
    private String userIdBegin;
    private String userIdEnd;

    public String getUserIdBegin() {
	return userIdBegin;
    }

    public void setUserIdBegin(String userIdBegin) {
	this.userIdBegin = userIdBegin;
    }

    public String getUserIdEnd() {
	return userIdEnd;
    }

    public void setUserIdEnd(String userIdEnd) {
	this.userIdEnd = userIdEnd;
    }

    public static boolean isNumeric(String str) {
	Pattern pattern = Pattern.compile("[1-9][0-9]*");
	return pattern.matcher(str).matches();
    }

    public String execute() throws Exception {
	try {
	    // 先判断开始学号和结束学号是否合法，再看开始学号和结束学号的大小。
	    // 如果不满足要求则不进行改动，返回教师面板页面。
	    if (!isNumeric(userIdBegin) || !isNumeric(userIdEnd)
		    || Integer.parseInt(userIdBegin) > Integer.parseInt(userIdEnd)) {
		return "error";
	    }

	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    int start = Integer.parseInt(userIdBegin);
	    int end = Integer.parseInt(userIdEnd);
	    while (start <= end) {
		String hql = "from User u where u.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", String.valueOf(start));
		List<User> list = query.list();
		if (!list.isEmpty()) {
		    // 当该userId已经被占用时不再新建用户，直接跳过。
		    continue;
		}
		User u = new User();
		u.setId(String.valueOf(start));
		u.setPassword("000000");
		u.setAuthority(Authority.STUDENT.toString());
		session.save(u);
		Information i = new Information();
		i.setUserId(String.valueOf(start));
		session.save(i);

		start++;
	    }

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    return "error";
	}
    }
}
