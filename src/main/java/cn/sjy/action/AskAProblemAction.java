package cn.sjy.action;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.Problem;
import cn.sjy.utils.HibernateUtil;

public class AskAProblemAction {
    private String problemDetails;

    public String getProblemDetails() {
	return problemDetails;
    }

    public void setProblemDetails(String problemDetails) {
	this.problemDetails = problemDetails;
    }

    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction transaction = session.beginTransaction();

	    // 添加提问。
	    ActionContext actionContext = ActionContext.getContext();
	    Map<String, Object> httpSession = actionContext.getSession();
	    String userId = httpSession.get("userId").toString();
	    Problem p = new Problem();
	    p.setUserId(userId);
	    p.setContent(problemDetails);
	    session.save(p);

	    transaction.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    return "error";
	}
    }
}
