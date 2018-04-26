<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="codeOnLine.jsp">
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
<link rel="stylesheet" type="text/css" href="./css/codeOnLine.css">
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

	<!-- 主体部分。 -->
	<div class="container" id="main-body">
		<div class="row">
			<form action="executionAction.do" method="post">
				<ul>
					<li>
						<h2 class="col-lg-12">问题列表:</h2>
					</li>
					<div class="col-lg-12" id="questions">
						<input type="radio" name="question" value="question0000"
							data-labelauty="示例" checked="true">
					</div>
				</ul>
				<h2 class="col-lg-12 mt-4" id="questionTitle">练习标准输入输出函数</h2>
				<div class="col-lg-12" id="questionDetails">在控制台打印“Hello
					World!”字符串。</div>
				<div class="col-lg-12">
					<fieldset id="codeFieldSet">
						<h2 class="mt-4">编程区域</h2>
						<textarea class="form-control" rows="12" id="code" name="code"></textarea>
						<button class="btn btn-primary mt-2 mb-3" id="submitBtn"
							type="submit">提交</button>
					</fieldset>
				</div>
			</form>
			<div>
				<h2 class="col-lg-12 mt-4">注意事项：</h2>
				<div class="col-lg-12">
					1、推荐使用本地编译器，经调试无误后复制到代码输入区提交。 <br />
					2、若程序有多个输出数据，请将所有输出数据置于一行，不同输出结果之间使用空格隔开，避免插入多余空格，引起系统误判。<br />
					3、若程序有输入数据，请先在程序头文件处加上“#include
					&lt;cstdlib&gt;”，然后在argv形参中读取数据，注意参数的类型转换。<br />
					举例：输入两个数据，分别是数字3和字符串“HelloWorld!”,在程序中使用“int num =
					atoi(argv[1]);”来获取数字3，使用“char* str=argv[2]”来获取字符串“HelloWorld!”。<br />
					4、C/C++语言提供了几个标准库函数，可以将字符串转换为任意类型(整型、长整型、浮点型等)。atof()：将字符串转换为双精度浮点型值。atoi()：将字符串转换为整型值。atol()：将字符串转换为长整型值。strtod()：将字符串转换为双精度浮点型值，并报告不能被转换的所有剩余数字。strtol()：将字符串转换为长整值，并报告不能被转换的所有剩余数字。strtoul()：将字符串转换为无符号长整型值，并报告不能被转换的所有剩余数字。<br />
					5、为保证服务器稳定，请不要使用文件读写等敏感操作。<br />
					6、所有的程序都将保存到服务器，请自行完成，不要抄袭，否则可能影响最终成绩。
				</div>
			</div>
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
	<script src="./vendor/jquery-3.3.1/jquery-labelauty.js"></script>
	<!-- 将后台的相关数据传递给js。 -->
	<%
	    String userId = null;
	    String userAuthority = null;
	    int questionNumber = 0;
	    try {
			userId = session.getAttribute("userId").toString();
			userAuthority = session.getAttribute("userAuthority").toString();
			questionNumber = Integer.parseInt(request.getAttribute("questionNumber").toString());
	    } catch (NullPointerException e) {
			userId = "null";
			userAuthority = "null";
			questionNumber = 0;
	    }
	%>
	<input type="hidden" id="userId" value="<%=userId%>" />
	<input type="hidden" id="userAuthority" value="<%=userAuthority%>" />
	<input type="hidden" id="questionNumber" value="<%=questionNumber%>" />
	<input type="hidden" id="questionName0" value="练习标准输入输出函数" />
	<input type="hidden" id="questionDetails0"
		value="在控制台打印“Hello World!”字符串。" />
	<%
	    for (int i = 1; i < questionNumber + 1; i++) {
			String questionName = "questionName" + i;
			String questionNameValue = request.getAttribute(questionName).toString();
			String questionDetails = "questionDetails" + i;
			String questionDetailsValue = request.getAttribute(questionDetails).toString();
	%>
	<input type="hidden" id="<%=questionName%>"
		value="<%=questionNameValue%>">
	<input type="hidden" id="<%=questionDetails%>"
		value="<%=questionDetailsValue%>">
	<%
	    }
	    ;
	%>
	<script src="./js/codeOnLine.js"></script>
</body>

</html>