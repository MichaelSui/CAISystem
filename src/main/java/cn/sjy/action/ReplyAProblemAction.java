package cn.sjy.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.Reply;
import cn.sjy.db.User;
import cn.sjy.utils.HibernateUtil;

public class ReplyAProblemAction {
    private String replyDetails;
    private int problemId;

    public int getProblemId() {
	return problemId;
    }

    public void setProblemId(int problemId) {
	this.problemId = problemId;
    }

    public String getReplyDetails() {
	return replyDetails;
    }

    public void setReplyDetails(String replyDetails) {
	this.replyDetails = replyDetails;
    }

    public String execute() throws Exception {
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();

	// 添加一个问题的回复。
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> httpSession = actionContext.getSession();
	String userId = httpSession.get("userId").toString();
	// 没有找到复合主键其中之一自增的配置文件写法，只好使用程序模拟这个自增的过程。
	int maxReplyId = 1;
	String hql = "from Reply r where r.problemId = :problemId";
	Query query = session.createQuery(hql);
	query.setParameter("problemId", problemId);
	List<Reply> list = query.list();
	for (Reply reply : list) {
	    maxReplyId = reply.getReplyId() > maxReplyId ? reply.getReplyId() : maxReplyId;
	}

	Reply r = new Reply();
	r.setProblemId(problemId);
	r.setReplyId(maxReplyId + 1);
	r.setUserId(userId);
	r.setContent(replyDetails);
	session.save(r);

	tx.commit();
	session.close();

	return "success";
    }
}
