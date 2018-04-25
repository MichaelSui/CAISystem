<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="index.html">
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
	href="./vendor/simple-line-icons-master/css/simple-line-icons.css">
<link rel="stylesheet" type="text/css"
	href="./vendor/fonts-googleapis/fonts-googleapis.css">

<!-- Custom styles for this page. -->
<link rel="stylesheet" type="text/css" href="./css/index.css">
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

	<!-- Masthead. -->
	<header class="masthead text-white text-center">
		<div class="container">
			<div class="row">
				<div class="col-9 mx-auto">
					<h1 class="mb-5">使用CAI System提升学习效率</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-7"></div>
				<div class="col-2">
					<a class="btn btn-primary" href="#ImageShowcases">点击了解更多</a>
				</div>
			</div>
		</div>
	</header>

	<!-- Icons Grid. -->
	<section class="features-icons bg-light text-center">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
						<div class="features-icons-icon d-flex">
							<i class="icon-screen-desktop m-auto text-primary"></i>
						</div>
						<h3>全尺寸设备的支持</h3>
						<p class="lead mb-0">电脑、平板和高分辨率手机都能正常使用。</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
						<div class="features-icons-icon d-flex">
							<i class="icon-layers m-auto text-primary"></i>
						</div>
						<h3>功能全面的优化</h3>
						<p class="lead mb-0">集成全部实用的功能。</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="features-icons-item mx-auto mb-0 mb-lg-3">
						<div class="features-icons-icon d-flex">
							<i class="icon-check m-auto text-primary"></i>
						</div>
						<h3>使用简单</h3>
						<p class="lead mb-0">全面降低学习和工作成本。</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Image Showcases. -->
	<a name="ImageShowcases"></a>
	<section class="showcase">
		<div class="container-fluid p-0">
			<div class="row no-gutters">
				<div class="col-lg-6 order-lg-2 text-white showcase-img"
					id="showcase-img-1"></div>
				<div class="col-lg-6 order-lg-1 my-auto showcase-text">
					<h2>在线编程</h2>
					<p class="lead mb-0">Talk is cheap.Show me the code. 实际上手方知深浅。</p>
				</div>
			</div>
			<div class="row no-gutters">
				<div class="col-lg-6 text-white showcase-img" id="showcase-img-2"></div>
				<div class="col-lg-6 my-auto showcase-text">
					<h2>提交作业</h2>
					<p class="lead mb-0">按时上交作业才能有好成绩。</p>
				</div>
			</div>
			<div class="row no-gutters">
				<div class="col-lg-6 order-lg-2 text-white showcase-img"
					id="showcase-img-3"></div>
				<div class="col-lg-6 order-lg-1 my-auto showcase-text">
					<h2>提出问题</h2>
					<p class="lead mb-0">有问题及时解决，不留后患。</p>
				</div>
			</div>
			<div class="row no-gutters">
				<div class="col-lg-6 text-white showcase-img" id="showcase-img-4"></div>
				<div class="col-lg-6 my-auto showcase-text">
					<h2>下载资源</h2>
					<p class="lead mb-0">好资源大家一起共享。</p>
				</div>
			</div>
			<div class="row no-gutters">
				<div class="col-lg-6 order-lg-2 text-white showcase-img"
					id="showcase-img-5"></div>
				<div class="col-lg-6 order-lg-1 my-auto showcase-text">
					<h2>我的信息</h2>
					<p class="lead mb-0">查看或修改我的信息。</p>
				</div>
			</div>
		</div>
	</section>

	<!-- 各种优质资源。-->
	<section class="testimonials text-center bg-light">
		<div class="container">
			<h2 class="mb-5">其他优质学习网站</h2>
			<div class="row">
				<div class="col-lg-4">
					<div class="testimonial-item mx-auto mb-5 mb-lg-0">
						<a class="black" href="https://www.google.com.hk/" target="_blank">
							<i class="fab fa-google fa-9x fa-fw"></i>
							<h5 class="mt-2">Google</h5>
						</a>
						<p class="font-weight-light mb-0">搜索引擎时遇到问题的第一选择。</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="testimonial-item mx-auto mb-5 mb-lg-0">
						<a class="black" href="https://stackoverflow.com/" target="_blank">
							<i class="fab fa-stack-overflow fa-9x fa-fw"></i>
							<h5 class="mt-2">Stack Overflow</h5>
						</a>
						<p class="font-weight-light mb-0">专业的编程问答网站。</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="testimonial-item mx-auto mb-5 mb-lg-0">
						<a class="black" href="https://github.com/" target="_blank"> <i
							class="fab fa-github fa-9x fa-fw"></i>
							<h5 class="mt-2">Github</h5>
						</a>
						<p class="font-weight-light mb-0">学习别人的优秀代码和展示自己的机会。</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Call to Action. -->
	<section class="call-to-action text-white text-center">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<h2 class="mb-4" id="callToActionMsg">迫不及待想要开始学习了？请先登录。</h2>
				</div>
				<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
					<a class="btn btn-primary" id="call-to-action-btn-1"
						href="goToLogInAction.do">登陆</a>
				</div>
			</div>
		</div>
	</section>

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
	    try {
			userId = session.getAttribute("userId").toString();
			userAuthority = session.getAttribute("userAuthority").toString();
	    } catch (NullPointerException e) {
			userId = "null";
			userAuthority = "null";
	    }
	%>
	<input type="hidden" id="userId" value="<%=userId%>" />
	<input type="hidden" id="userAuthority" value="<%=userAuthority%>" />
	<script src="./js/index.js"></script>
</body>

</html>