<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="myInformation.jsp">
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
<link rel="stylesheet" href="./css/myInformation.css">
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
					<li class="nav-item active"><a class="nav-link" href="#">我的信息</a></li>
				</ul>
				<a class="btn btn-primary" id="nav-btn-1" href="goToLogInAction.do">登陆</a>
			</div>
		</div>
	</nav>

	<!-- 主题部分。 -->
	<div class="container" id="main-body">
		<div class="col-lg-12">
			<h2 class="mb-4">查看、修改个人信息</h2>
			<form class="needs-validation" action="changeMyInformationAction.do"
				method="post" novalidate>
				<div class="row">
					<div class="col-lg-6 mb-3">
						<label for="userId">学号</label> <input type="text"
							class="form-control" id="final_userId" name="userId" readOnly>
					</div>

					<div class="col-lg-6 mb-3">
						<label for="name">姓名</label> <input type="text"
							class="form-control" id="name" name="name" required>
					</div>
				</div>

				<div class="mb-3">
					<label for="email">电子邮箱</label> <input type="email"
						class="form-control" id="email" name="email">
				</div>

				<div class="mb-3">
					<label for="phone">联系方式<span class="text-muted">(推荐手机号码)</span></label>
					<input type="text" class="form-control" id="phone" name="phone"
						required>
				</div>

				<div class="mb-3">
					<label for="QQ/TIM">QQ/TIM</label> <input type="text"
						class="form-control" id="qqOrTim" name="qqOrTim" required>
				</div>

				<div class="mb-3">
					<label for="wechat">微信</label> <input type="text"
						class="form-control" id="wechat" name="wechat" required>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<button class="btn btn-primary mb-3" type="submit"
							id="changeMyInformationBtn">修改</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- Footer. -->
	<footer class="footer bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 h-100 text-center text-lg-left my-auto">
					<ul class="list-inline mb-2">
						<li class="list-inline-item"><a href="#">关于</a></li>
						<li class="list-inline-item">&sdot;</li>
						<li class="list-inline-item"><a href="#">联系</a></li>
						<li class="list-inline-item">&sdot;</li>
						<li class="list-inline-item"><a href="#">使用条款</a></li>
						<li class="list-inline-item">&sdot;</li>
						<li class="list-inline-item"><a href="#">隐私政策</a></li>
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
	<!-- 将后台的相关数据传递给js。 -->
	<%
	    String userId = null;
	    String userAuthority = null;
	    String name = null;
	    String email = null;
	    String phone = null;
	    String qqOrTim = null;
	    String wechat = null;
	    try {
			userId = session.getAttribute("userId").toString();
			userAuthority = session.getAttribute("userAuthority").toString();
	    } catch (NullPointerException e) {
			userId = "";
			userAuthority = "";
	    }
	    try {
			name = request.getAttribute("name").toString();
			email = request.getAttribute("email").toString();
			phone = request.getAttribute("phone").toString();
			qqOrTim = request.getAttribute("qqOrTim").toString();
			wechat = request.getAttribute("wechat").toString();
	    } catch (NullPointerException e) {
			name = "";
			email = "";
			phone = "";
			qqOrTim = "";
			wechat = "";
	    }
	%>
	<input type="hidden" id="userId" value="<%=userId%>" />
	<input type="hidden" id="userAuthority" value="<%=userAuthority%>" />
	<input type="hidden" id="o_name" value="<%=name%>" />
	<input type="hidden" id="o_email" value="<%=email%>" />
	<input type="hidden" id="o_phone" value="<%=phone%>" />
	<input type="hidden" id="o_qqOrTim" value="<%=qqOrTim%>" />
	<input type="hidden" id="o_wechat" value="<%=wechat%>" />
	<script src="./js/myInformation.js"></script>
</body>

</html>