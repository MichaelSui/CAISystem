<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="codeOnLine.html">
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
<link rel="stylesheet" type="text/css"
	href="./vendor/jquery-3.3.1/jquery-labelauty.css" />

<!-- 使用CodeMirror。 -->
<link rel="stylesheet" type="text/css"
	href="./vendor/CodeMirror-master/lib/codemirror.css" />
<script src="./vendor/CodeMirror-master/lib/codemirror.js"></script>

<!-- C++代码高亮必须引入。 -->
<script src="./vendor/CodeMirror-master/mode/clike/clike.js"></script>

<!-- 引入css文件，用以支持主题。 -->
<link rel="stylesheet"
	href="./vendor/CodeMirror-master/theme/dracula.css" />

<!-- 支持代码折叠。 -->
<link rel="stylesheet"
	href="./vendor/CodeMirror-master/addon/fold/foldgutter.css" />
<script src="./vendor/CodeMirror-master/addon/fold/foldcode.js"></script>
<script src="./vendor/CodeMirror-master/addon/fold/foldgutter.js"></script>
<script src="./vendor/CodeMirror-master/addon/fold/brace-fold.js"></script>
<script src="./vendor/CodeMirror-master/addon/fold/comment-fold.js"></script>

<!-- 括号匹配。 -->
<script src="./vendor/CodeMirror-master/addon/edit/matchbrackets.js"></script>

<!-- Custom styles for this page. -->
<link rel="stylesheet" href="./css/codeOnLine.css">
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
						href="goToCodeOnLine">在线编程</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="./handInHomework.html">提交作业</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="./askQuestions.html">提出问题</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="./downloadResources.html">下载资源</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="./myInformation.html">我的信息</a></li>
				</ul>
				<a class="btn btn-primary" id="nav-btn-1" href="./signIn.html">登陆</a>
			</div>
		</div>
	</nav>

	<!-- 主体部分。 -->
	<div class="container" id="main-body">
		<div class="row">
			<form class="col-12">
				<ul>
					<li>
						<h2>问题列表:</h2>
					</li>
					<br />
					<div id="questions">
						<input type="radio" name="question" value="question0"
							data-labelauty="示例" checked="true">
					</div>
				</ul>
				<br />
				<h2 id="questionTitle">练习标准输入输出函数</h2>
				<div id="questionDetails">在控制台打印“Hello World!”字符串。</div>
				<br />
				<fieldset id="codeFieldSet">
					<legend>编程</legend>
					<textarea class="form-control" rows="12" id="code"></textarea>
					<button class="btn btn-primary mt-2 mb-3" type="submit">提交</button>
				</fieldset>
			</form>
			<h2 class="col-12">返回结果:</h2>
			<div class="col-12">详细结果</div>
		</div>
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

	<!-- Bootstrap core JavaScript. -->
	<script src="./vendor/jquery-3.3.1/jquery-3.3.1.slim.min.js"></script>
	<script src="./vendor/popper/popper.min.js"></script>
	<script src="./vendor/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"></script>
	<script src="./vendor/jquery-3.3.1/jquery-labelauty.js"></script>
	<script src="./js/codeOnLine.js"></script>
</body>

</html>