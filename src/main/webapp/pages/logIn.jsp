<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="signIn.jsp">
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
<link rel="stylesheet" type="text/css" href="./css/logIn.css">
</head>

<body>
	<!-- Navigation. -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container">
			<a href="#"> <img id="nav-brand-img" src="./img/favicon.ico"
				alt="brand" />
			</a> <a class="navbar-brand ml-2" href="#">CAI System</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse ml-4" id="navbarsExampleDefault">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">在线编程</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">提交作业</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">提出问题</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">下载资源</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">我的信息</a></li>
				</ul>
				<a class="btn btn-primary" id="nav-btn-1" href="#">登陆</a>
			</div>
		</div>
	</nav>

	<!-- 登录功能。 -->
	<div class="container text-center" id="main-body">
		<form class="form-signin" action="loginAction.do" method="post">
			<img class="mb-4" src="./img/electronics.png" alt="" width="72px"
				height="72px">
			<h1 class="h3 mb-3 font-weight-normal">请登陆</h1>
			<input type="text" id="inputName" class="form-control" name="id"
				placeholder="用户名" required> <input type="password"
				id="inputPassword" class="form-control" name="password"
				placeholder="密码" required>
			<div class="radio mb-3">
				<input type="radio" id="remember" name="remember" value="remember"
					checked="checked"> 记住密码 <input class="ml-3" type="radio"
					id="notRemember" name="remember" value="notRemember"> 忘记密码
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
			<button class="btn btn-lg btn-danger btn-block">忘记密码</button>
		</form>
	</div>

	<!-- Footer. -->
	<footer class="footer bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 h-100 text-center text-lg-left my-auto">
					<ul class="list-inline mb-2">
						<li class="list-inline-item"><a href="./about.html">关于</a></li>
						<li class="list-inline-item">&sdot;</li>
						<li class="list-inline-item"><a href="./contact.html">联系</a>
						</li>
						<li class="list-inline-item">&sdot;</li>
						<li class="list-inline-item"><a href="./termsForUsage.html">使用条款</a>
						</li>
						<li class="list-inline-item">&sdot;</li>
						<li class="list-inline-item"><a href="./privacyPolicy.html">隐私政策</a>
						</li>
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
	<script src="./js/logIn.js"></script>
</body>

</html>