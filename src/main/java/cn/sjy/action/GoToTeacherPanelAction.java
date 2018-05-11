package cn.sjy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.sjy.db.CodeScore;
import cn.sjy.db.Notice;
import cn.sjy.db.Question;
import cn.sjy.db.QuestionExample;
import cn.sjy.utils.HibernateUtil;

public class GoToTeacherPanelAction {
    public String execute() throws Exception {
	try {
	    Session session = HibernateUtil.getSession();
	    Transaction tx = session.beginTransaction();

	    // 获取全部的学生成绩。
	    Query query = session.createQuery("from CodeScore");
	    List<CodeScore> list = query.list();
	    int codeScoreNum = list.size();
	    ActionContext actionContext = ActionContext.getContext();
	    HttpServletRequest httpServletRequest = (HttpServletRequest) actionContext
		    .get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	    httpServletRequest.setAttribute("codeScoreNum", codeScoreNum);
	    for (int i = 0; i < codeScoreNum; i++) {
		CodeScore cs = list.get(i);
		httpServletRequest.setAttribute("codeScore" + i + "UserId", cs.getUserId());
		httpServletRequest.setAttribute("codeScore" + i + "QuestionId", cs.getQuestionId());
		httpServletRequest.setAttribute("codeScore" + i + "Score", cs.getScore());
	    }

	    // 获取全部的试题信息。
	    query = session.createQuery("from Question");
	    List<Question> questionList = query.list();
	    int questionNum = questionList.size();
	    httpServletRequest.setAttribute("questionNum", questionNum);
	    for (int i = 0; i < questionNum; i++) {
		Question q = questionList.get(i);
		httpServletRequest.setAttribute("question" + i + "Id", q.getId());
		httpServletRequest.setAttribute("question" + i + "QuestionName", q.getQuestionName());
		httpServletRequest.setAttribute("question" + i + "QuestionDetails", q.getQuestionDetails());
	    }

	    // 获取全部的用例信息。
	    query = session.createQuery("from QuestionExample");
	    List<QuestionExample> questionExampleList = query.list();
	    int questionExampleNum = questionExampleList.size();
	    httpServletRequest.setAttribute("questionExampleNum", questionExampleNum);
	    for (int i = 0; i < questionExampleNum; i++) {
		QuestionExample qe = questionExampleList.get(i);
		httpServletRequest.setAttribute("questionExample" + i + "QuestionId", qe.getQuestionId());
		httpServletRequest.setAttribute("questionExample" + i + "ExampleId", qe.getExampleId());
		httpServletRequest.setAttribute("questionExample" + i + "Input", qe.getInput());
		httpServletRequest.setAttribute("questionExample" + i + "Output", qe.getOutput());
	    }

	    tx.commit();
	    session.close();

	    return "success";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "error";
	}
    }
}
