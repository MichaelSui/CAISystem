<%@page import="cn.sjy.utils.GetNotice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="teacherPanel.jsp">
<meta name="author" content="MichaelSui">
<link rel="icon" href="./img/favicon.ico">

<title>CAI System</title>

<!-- Bootstrap core CSS. -->
<link rel="stylesheet"
	href="./vendor/bootstrap-4.0.0-dist/css/bootstrap.min.css">

<!-- Custom fonts and pictures for this template. -->
<link rel="stylesheet" type="text/css"
	href="./vendor/fontawesome-free-5.0.8/web-fonts-with-css/css/fa-brands.min.css">
<link rel="stylesheet" type="text/css"
	href="./vendor/fontawesome-free-5.0.8/web-fonts-with-css/css/fa-solid.min.css">
<link rel="stylesheet" type="text/css"
	href="./vendor/fontawesome-free-5.0.8/web-fonts-with-css/css/fontawesome.min.css">
<link rel="stylesheet" type="text/css"
	href="./vendor/fonts-googleapis/fonts-googleapis.css">

<!-- Custom styles for this page. -->
<link rel="stylesheet" href="./css/teacherPanel.css">
</head>

<body>
	<!-- Navigation. -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container">
			<a href="./index.jsp"> <img id="nav-brand-img"
				src="./img/favicon.ico" alt="brand" />
			</a> <a class="navbar-brand ml-2" href="./index.jsp">CAI System</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse ml-4" id="navbarsExampleDefault">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="goToCodeOnLineAction.do">在线编程</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="goToHandInHomeWorkAction.do">提交作业</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="goToQuestionListAction.do">提出问题</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="goToResourceSharingAction.do">资源共享</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="goToMyInformationAction.do">我的信息</a></li>
					<li class="nav-item active"><a class="nav-link" id="noticeBtn"
						href="#">通知</a></li>
				</ul>
				<a class="btn btn-primary" id="nav-btn-1" href="goToLogInAction.do">登陆</a>
			</div>
		</div>
	</nav>

	<!-- 通知窗口。 -->
	<div id="noticeBackground"></div>
	<div id="noticeDiv">
		<h2>
			通知窗口<a href="#" id="closeBtn">关闭</a>
		</h2>
		<div id="noticeMsg"></div>
	</div>

	<!-- 主体部分。 -->
	<div class="container" id="main-body">
		<div class="row">
			<h2 class="col-lg-12">查看学生的成绩：</h2>
			<div class="col-lg-12 mt-4">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>学号</th>
							<th>题目编号</th>
							<th>成绩</th>
						</tr>
					</thead>
					<tbody id="studentCodeScore"></tbody>
				</table>
			</div>
			<h2 class="col-lg-12 mt-4">查看学生的总成绩：</h2>
			<div class="col-lg-12 mt-4">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>学号</th>
							<th>总成绩</th>
						</tr>
					</thead>
					<tbody id="studentCodeScoreAll"></tbody>
				</table>
			</div>
			<h2 class="col-lg-12 mt-4">查看当前题库：</h2>
			<div class="col-lg-12 mt-4">
				<table class="table table-hover">
					<thead>
						<tr>
							<th width="20%">编号</th>
							<th width="40%">题目标题</th>
							<th width="40%">题目详情</th>
						</tr>
					</thead>
					<tbody id="questionList"></tbody>
				</table>
			</div>
			<h2 class="col-lg-12 mt-4">添加试题：</h2>
			<div class="col-lg-12 mt-4">
				<form class="form" role="form" action="addQuestionAction.do"
					method="post">
					<input type="text" class="form-control" name="addQuestionName"
						placeholder="请输入问题名称" required> <input type="text"
						class="form-control mt-2" name="addQuestionDetails"
						placeholder="请输入问题详情" required>
					<button type="submit" class="btn btn-primary mt-2 mb-4"
						id="addQuestionBtn">添加试题</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">删除试题：</h2>
			<div class="col-lg-12 mt-4">
				<form class="form" role="form" action="deleteQuestionAction.do"
					method="post">
					<input type="text" class="form-control" name="deleteQuestionId"
						placeholder="请输入问题序号" required>
					<button type="submit" class="btn btn-primary mt-2 mb-4"
						id="deleteQuestionBtn">删除试题</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">查看当前用例库：</h2>
			<div class="col-lg-12 mt-4">
				<table class="table table-hover">
					<thead>
						<tr>
							<th width="20%">题目编号</th>
							<th width="20%">用例编号</th>
							<th width="30%">输入</th>
							<th width="30%">输出</th>
						</tr>
					</thead>
					<tbody id="questionExampleList"></tbody>
				</table>
			</div>
			<h2 class="col-lg-12 mt-4">添加用例：</h2>
			<div class="col-lg-12 mt-4">
				<form class="form" role="form" action="addQuestionExampleAction.do"
					method="post">
					<input type="text" class="form-control"
						name="addQuestionExampleQuestionId" placeholder="请输入用例对应的题目编号"
						required> <input type="text" class="form-control mt-2"
						name="addQuestionExampleInput" placeholder="请输入用例输入" required><input
						type="text" class="form-control mt-2"
						name="addQuestionExampleOutput" placeholder="请输入用例输出" required>
					<button type="submit" class="btn btn-primary mt-2 mb-4"
						id="addQuestionExampleBtn">添加用例</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">删除用例：</h2>
			<div class="col-lg-12 mt-4">
				<form class="form" role="form"
					action="deleteQuestionExampleAction.do" method="post">
					<input type="text" class="form-control"
						name="deleteQuestionExampleQuestionId"
						placeholder="请输入删除用例对应的题目编号" required> <input type="text"
						class="form-control mt-2" name="deleteQuestionExampleExampleId"
						placeholder="请输入删除用例对应的用例编号" required>
					<button type="submit" class="btn btn-primary mt-2 mb-4"
						id="deleteQuestionExampleBtn">删除用例</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">程序目录：</h2>
			<div class="col-lg-12">
				<form class="form" role="form"
					action="openDockerFilesDirectoryAction.do" method="post">
					<button class="btn btn-primary mt-2 mb-4"
						id="openDockerFilesDirectoryBtn">打开程序目录</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">作业目录：</h2>
			<div class="col-lg-12">
				<form class="form" role="form"
					action="openHomeWorkDirectoryAction.do" method="post">
					<button class="btn btn-primary mt-2 mb-4"
						id="openHomeWorkDirectoryBtn">打开作业目录</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">资源目录：</h2>
			<div class="col-lg-12">
				<form class="form" role="form"
					action="openUploadAndDownloadFilesDirectoryAction.do" method="post">
					<button class="btn btn-primary mt-2 mb-4"
						id="openUploadAndDownloadFilesDirectoryBtn">打开资源目录</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">查看当前通知：</h2>
			<div class="col-lg-12 mt-4">
				<table class="table table-hover">
					<thead>
						<tr>
							<th width="30%">发布时间</th>
							<th width="70%">内容</th>
						</tr>
					</thead>
					<tbody id="noticeTable"></tbody>
				</table>
			</div>
			<h2 class="col-lg-12 mt-4">添加通知：</h2>
			<div class="col-lg-12 mt-4">
				<form class="form" role="form" action="addNoticeAction.do"
					method="post">
					<input type="text" class="form-control" name="content"
						placeholder="请输入新建通知内容" required>
					<button class="btn btn-primary mt-2 mb-4" id="addNoticeBtn">添加通知</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">删除通知：</h2>
			<div class="col-lg-12 mt-4">
				<form class="form" role="form" action="deleteNoticeAction.do"
					method="post">
					<input type="text" class="form-control" name="date"
						placeholder="请输入删除通知的具体发布时间" required>
					<button class="btn btn-primary mt-2 mb-4" id="deleteNoticeBtn">删除通知</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">添加单个学生：</h2>
			<div class="col-lg-12 mt-4">
				<form class="form" role="form" action="addUserAction.do"
					method="post">
					<input type="text" class="form-control" name="userId"
						placeholder="请输入新建学生编号" required>
					<button class="btn btn-primary mt-2 mb-4" id="addUserBtn">添加单个学生</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">批量添加学生：</h2>
			<div class="col-lg-12 mt-4">
				<form class="form" role="form" action="addUsersAction.do"
					method="post">
					<input type="text" class="form-control" name="userIdBegin"
						placeholder="请输入新建起始学生编号" required> <input type="text"
						class="form-control mt-2" name="userIdEnd"
						placeholder="请输入新建结束学生编号" required>
					<div class="col-lg-12 mt-2">请注意：批量添加仅适用于非零开头的学号，不适用于任何字母。</div>
					<button class="btn btn-primary mt-2 mb-4" id="addUsersBtn">添加多个学生</button>
				</form>
			</div>
			<h2 class="col-lg-12 mt-4">重置密码：</h2>
			<div class="col-lg-12 mt-4">
				<form class="form" role="form" action="resetPasswordAction.do"
					method="post">
					<input type="text" class="form-control" name="userId"
						placeholder="请输入重置密码的学生编号" required>
					<button class="btn btn-primary mt-2 mb-4" id="resetPasswordBtn">重置密码</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Footer. -->
	<footer class="footer bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 h-100 text-center text-lg-left my-auto">
					<ul class="list-inline mb-2">
						<li class="list-inline-item"><a href="goToAboutAction.do">关于</a></li>
						<li class="list-inline-item">&sdot;</li>
						<li class="list-inline-item"><a href="goToContactAction.do">联系</a></li>
						<li class="list-inline-item">&sdot;</li>
						<li class="list-inline-item"><a href="goToTermsAction.do">使用条款</a></li>
						<li class="list-inline-item">&sdot;</li>
						<li class="list-inline-item"><a
							href="goToPrivacyPolicyAction.do">隐私政策</a></li>
					</ul>
					<p class="text-muted small mb-4 mb-lg-0">&copy; CAI System
						2017-2018. All Rights Reserved.</p>
				</div>
				<div class="col-lg-6 h-100 text-center text-lg-right my-auto">
					<ul class="list-inline mb-0">
						<li class="list-inline-item mr-3"><a
							href="tencent://message/?Menu=yes&uin=2802138850"> <i
								class="fab fa-qq fa-2x fa-fw"></i>
						</a></li>
						<li class="list-inline-item"><a
							href="mailto:2802138850@qq.com"> <i
								class="fas fa-at fa-2x fa-fw"></i>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript and etc. -->
	<script src="./vendor/jquery-3.3.1/jquery-3.3.1.slim.min.js"></script>
	<script src="./vendor/popper/popper.min.js"></script>
	<script src="./vendor/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"></script>
	<%
	    //将后台的相关数据传递给js。    
	    String userId = session.getAttribute("userId").toString();
	    String userAuthority = session.getAttribute("userAuthority").toString();

	    // 获取通知信息。
	    ArrayList<String> dates = GetNotice.getDates();
	    ArrayList<String> notices = GetNotice.getNotices();
	    int noticeNum = dates.size();
	%>
	<input type="hidden" id="userId" value="<%=userId%>" />
	<input type="hidden" id="userAuthority" value="<%=userAuthority%>" />
	<input type="hidden" id="noticeNum" value="<%=noticeNum%>" />
	<%
	    for (int i = 0; i < noticeNum; i++) {
			String noticeDateKey = "notice" + i + "Date";
			String noticeDateValue = dates.get(i);

			String noticeMsgKey = "notice" + i + "Msg";
			String noticeMsgValue = notices.get(i);
	%>
	<input type="hidden" id="<%=noticeDateKey%>"
		value="<%=noticeDateValue%>" />
	<input type="hidden" id="<%=noticeMsgKey%>" value="<%=noticeMsgValue%>" />
	<%
	    }
	    // 获取成绩信息。
	    int codeScoreNum = Integer.parseInt(request.getAttribute("codeScoreNum").toString());
	%>
	<input type="hidden" id="codeScoreNum" value="<%=codeScoreNum%>" />
	<%
	    for (int i = 0; i < codeScoreNum; i++) {
			String codeScoreUserIdKey = "codeScore" + i + "UserId";
			String codeScoreUserIdValue = request.getAttribute(codeScoreUserIdKey).toString();
			String codeScoreQuestionIdKey = "codeScore" + i + "QuestionId";
			String codeScoreQuestionIdValue = request.getAttribute(codeScoreQuestionIdKey).toString();
			String codeScoreScoreKey = "codeScore" + i + "Score";
			String codeScoreScoreValue = request.getAttribute(codeScoreScoreKey).toString();
	%>
	<input type="hidden" id="<%=codeScoreUserIdKey%>"
		value="<%=codeScoreUserIdValue%>" />
	<input type="hidden" id="<%=codeScoreQuestionIdKey%>"
		value="<%=codeScoreQuestionIdValue%>" />
	<input type="hidden" id="<%=codeScoreScoreKey%>"
		value="<%=codeScoreScoreValue%>" />
	<%
	    }
	    // 获取试题信息。
	    int questionNum = Integer.parseInt(request.getAttribute("questionNum").toString());
	%>
	<input type="hidden" id="questionNum" value="<%=questionNum%>" />
	<%
	    for (int i = 0; i < questionNum; i++) {
			String questionIdKey = "question" + i + "Id";
			String questionIdValue = request.getAttribute(questionIdKey).toString();
			String questionQuestionNameKey = "question" + i + "QuestionName";
			String questionQuestionNameValue = request.getAttribute(questionQuestionNameKey).toString();
			String questionQuestionDetailsKey = "question" + i + "QuestionDetails";
			String questionQuestionDetailsValue = request.getAttribute(questionQuestionDetailsKey).toString();
	%>
	<input type="hidden" id="<%=questionIdKey%>"
		value="<%=questionIdValue%>" />
	<input type="hidden" id="<%=questionQuestionNameKey%>"
		value="<%=questionQuestionNameValue%>" />
	<input type="hidden" id="<%=questionQuestionDetailsKey%>"
		value="<%=questionQuestionDetailsValue%>" />
	<%
	    }
	    // 获取用例信息。
	    int questionExampleNum = Integer.parseInt(request.getAttribute("questionExampleNum").toString());
	%>
	<input type="hidden" id="questionExampleNum"
		value="<%=questionExampleNum%>" />
	<%
	    for (int i = 0; i < questionExampleNum; i++) {
			String questionExampleQuestionIdKey = "questionExample" + i + "QuestionId";
			String questionExampleQuestionIdValue = request.getAttribute(questionExampleQuestionIdKey).toString();
			String questionExampleExampleIdKey = "questionExample" + i + "ExampleId";
			String questionExampleExampleIdValue = request.getAttribute(questionExampleExampleIdKey).toString();
			String questionExampleInputKey = "questionExample" + i + "Input";
			String questionExampleInputValue = request.getAttribute(questionExampleInputKey).toString();
			String questionExampleOutputKey = "questionExample" + i + "Output";
			String questionExampleOutputValue = request.getAttribute(questionExampleOutputKey).toString();
	%>
	<input type="hidden" id="<%=questionExampleQuestionIdKey%>"
		value="<%=questionExampleQuestionIdValue%>" />
	<input type="hidden" id="<%=questionExampleExampleIdKey%>"
		value="<%=questionExampleExampleIdValue%>" />
	<input type="hidden" id="<%=questionExampleInputKey%>"
		value="<%=questionExampleInputValue%>" />
	<input type="hidden" id="<%=questionExampleOutputKey%>"
		value="<%=questionExampleOutputValue%>" />
	<%
	    }
	%>
	<script src="./js/teacherPanel.js"></script>
</body>

</html>