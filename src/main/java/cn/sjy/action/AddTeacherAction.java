package cn.sjy.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.Information;
import cn.sjy.db.User;
import cn.sjy.utils.Authority;
import cn.sjy.utils.HibernateUtil;

public class AddTeacherAction {
    private String addTeacherId;

    public String getAddTeacherId() {
	return addTeacherId;
    }

    public void setAddTeacherId(String addTeacherId) {
	this.addTeacherId = addTeacherId;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    // 添加一个教师。
	    // 先看当前的userId是否已经被占用。
	    String hql = "from User u where u.id = :id";
	    Query query = session.createQuery(hql);
	    query.setParameter("id", addTeacherId);
	    List<User> list = query.list();
	    if (!list.isEmpty()) {
		// 当该userId已经被占用时不再新建用户，直接跳过。
		return "error";
	    }

	    User u = new User();
	    u.setId(addTeacherId);
	    u.setPassword("000000");
	    u.setAuthority(Authority.TEACHER.toString());
	    session.save(u);
	    Information i = new Information();
	    i.setUserId(addTeacherId);
	    session.save(i);

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();

	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    httpSession.put("errorMsg", "AddTeacherAction抛出了异常");
	    return "error";
	}
    }
}
