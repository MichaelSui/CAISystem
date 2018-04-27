package cn.sjy.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.Information;
import cn.sjy.utils.HibernateUtil;

public class GoToMyInformationAction {
    public String execute() throws Exception {
	// 获取个人信息。
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

	String hql = "from Information i where i.userId = :userId";
	Query query = session.createQuery(hql);
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> httpSession = actionContext.getSession();
	String userId = httpSession.get("userId").toString();
	query.setParameter("userId", userId);
	List<Information> list = query.list();
	// 创建学生的时候一定会创建相应的人员信息表，所以这里获取时一定是可以获取到的。
	Information i = list.get(0);
	HttpServletRequest httpServletRequest = (HttpServletRequest) actionContext
		.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	httpServletRequest.setAttribute("name", i.getName());
	httpServletRequest.setAttribute("email", i.getEmail());
	httpServletRequest.setAttribute("phone", i.getPhone());
	httpServletRequest.setAttribute("qqOrTim", i.getQqOrTim());
	httpServletRequest.setAttribute("wechat", i.getWechat());

	tx.commit();
	session.close();
	return "success";
    }
}
