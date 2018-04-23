package cn.sjy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.Question;
import cn.sjy.utils.HibernateUtil;

public class GoToCodeOnLineAction {
    public String execute() throws Exception {
	/*
	 * 首先获取数据库中保存的试题数量，用来生成相应的页面。在js中保存试题相关信息。
	 */
	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
	String hql = "from Question";
	Query query = session.createQuery(hql);
	List<Question> list = query.list();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletRequest httpServletRequest = (HttpServletRequest) actionContext
		.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	httpServletRequest.setAttribute("questionNumber", list.size());
	for (int i = 1; i < list.size() + 1; i++) {
	    Question question = list.get(i - 1);
	    httpServletRequest.setAttribute("questionName" + i, question.getQuestionName());
	    httpServletRequest.setAttribute("questionDetails" + i, question.getQuestionDetails());
	}
	transaction.commit();
	session.close();
	return "success";
    }
}
