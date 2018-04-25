package cn.sjy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.Problem;
import cn.sjy.db.Reply;
import cn.sjy.utils.HibernateUtil;

public class GoToProblemAction {
    private int problemId;

    public int getProblemId() {
	return problemId;
    }

    public void setProblemId(int problemId) {
	this.problemId = problemId;
    }

    public String execute() throws Exception {
	// 根据problemId获取提问的具体信息和各项回复传递给前端。
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

	String hql = "from Problem p where p.problemId = :problemId";
	Query query = session.createQuery(hql);
	query.setParameter("problemId", problemId);
	List<Problem> list = query.list();

	ActionContext actionContext = ActionContext.getContext();
	HttpServletRequest httpServletRequest = (HttpServletRequest) actionContext
		.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	if (!list.isEmpty()) {
	    httpServletRequest.setAttribute("problemId", problemId);
	    Problem p = list.get(0);
	    httpServletRequest.setAttribute("userId", p.getUserId());
	    httpServletRequest.setAttribute("content", p.getContent());
	} else {
	    httpServletRequest.setAttribute("problemId", problemId);
	    httpServletRequest.setAttribute("userId", "null");
	    httpServletRequest.setAttribute("content", "null");
	}

	hql = "from Reply r where r.problemId = :problemId";
	query = session.createQuery(hql);
	query.setParameter("problemId", problemId);
	List<Reply> replyList = query.list();
	httpServletRequest.setAttribute("replyCount", replyList.size());
	for (int i = 0; i < replyList.size(); i++) {
	    Reply r = replyList.get(i);
	    httpServletRequest.setAttribute("reply" + i + "Id", r.getReplyId());
	    httpServletRequest.setAttribute("reply" + i + "UserId", r.getUserId());
	    httpServletRequest.setAttribute("reply" + i + "Content", r.getContent());
	}

	tx.commit();
	session.close();

	return "success";
    }
}