package cn.sjy.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.User;
import cn.sjy.utils.HibernateUtil;

// 登陆相关逻辑。用户名和密码正误的判断和Session信息的保存。
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
	try {
	    // 防止直接访问。
	    if (id == null || password == null || remember == null) {
		return "noPass";
	    }

	    // 记住密码功能。
	    if (remember.equals("remember")) {
		// 选中了记住密码。
		Cookie cookieId = new Cookie("userId", id);
		cookieId.setMaxAge(60 * 60 * 24 * 7);
		Cookie cookiePassword = new Cookie("userPassword", password);
		cookiePassword.setMaxAge(60 * 60 * 24 * 7);
		ActionContext actionContext = ActionContext.getContext();
		HttpServletResponse httpServletResponse = (HttpServletResponse) actionContext
			.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		httpServletResponse.addCookie(cookieId);
		httpServletResponse.addCookie(cookiePassword);
	    } else if (remember.equals("notRemember")) {
		// 选中了忘记密码。
		ActionContext actionContext = ActionContext.getContext();
		HttpServletResponse httpServletResponse = (HttpServletResponse) actionContext
			.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		HttpServletRequest httpServletRequest = (HttpServletRequest) actionContext
			.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		Cookie[] cookies = httpServletRequest.getCookies();
		for (int i = 0; i < cookies.length; i++) {
		    String name = cookies[i].getName();
		    if (name.equals("userId") || name.equals("userPassword")) {
			cookies[i].setMaxAge(0);
			httpServletResponse.addCookie(cookies[i]);
		    }
		}
	    }

	    Session session = HibernateUtil.getSession();
	    Transaction transaction = session.beginTransaction();

	    // 用户名和密码正误的判断和Session信息的保存。
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

		return "success";
	    } else {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> httpSession = actionContext.getSession();
		httpSession.put("errorMsg", "用户名或密码错误");

		transaction.commit();
		session.close();

		return "error";
	    }
	} catch (Exception e) {
	    e.printStackTrace();

	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    httpSession.put("errorMsg", "LoginAction抛出了异常");
	    return "error";
	}
    }
}
