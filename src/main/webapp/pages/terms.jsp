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
<meta name="description" content="terms.jsp">
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
<link rel="stylesheet" href="./css/terms.css">
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
			<h2 class="col-lg-12 mt-5">使用条款</h2>
			<div class="col-lg-12 mt-5">
				使用本网站前，请您仔细阅读以下条款，访问、浏览或使用本网站，即承认您已阅读、理解并同意接受这些条款或提及的所有条款，并遵守相关法律法规。如果您不接受这些条款，请不要使用本网站。<br />
				<br />
				本网站的内容仅供您个人而非商业性使用，对于内容中所含的任何权利声明您应予以遵守。即使本网站的内容没有相关权利声明，也并不代表本人对其不享有权利，您应尊重这些内容的合法权益并遵守相关法律规定。<br />
				<br />
				您不得以任何方式修改、复制、公布、出租、出售或以其他方式将本网站内容用于任何公开或商业目的，禁止以任何目的把本网站内容用于任何其他网站或媒体。<br />
				<br />
				本人可以随时对您访问或使用本网站进行任何修改、限制、暂停或终止，而无须事先通知，同时，也不对因此带给您或第三方的任何影响负责。<br />
				<br /> 本网站的内容受到法律法规的保护，若您违反了本使用条款，您应承担由此造成的一切后果和法律责任。<br /> <br />
				请您不要向本网站发送或提交任何机密的或私人的信息（或材料），您通过本网站发送或提交的任何信息（或材料）都将被认为是非保密和非专有的，本公司
				可以出于任何目的以任何方式无限制地免费使用或传播该信息（或材料），同时该发送或提交视为您已同意本公司可因任何目的通过复制、修改、透露、分发、合并、传输、显示、执行以及其他方式自由使用该信息（或材料）。<br />
				<br />
				您需要对通过本网站发送、提交、上载、张贴或以其他方式传输的所有内容承担全部责任。本公司可以单方随时修改、删除该内容，或可以单方无限时中止该内容的网上浏览，情节严重的，本公司将提交相关部门处理。您不得通过本网站发送、提交、上载、张贴或以其他方式传输以下内容：任何非法的、威胁性的、暴力性的、反动性的、侮辱诽谤的、淫秽色情的或其他违法性的内容；未经合法授权而披露的个人信息；侵犯他人合法的知识产权权益的内容；携带计算机病毒或包含有任何破坏计算机、网站功能的程序、代码、文件等；垃圾邮件、广告信息。<br />
				<br />
				本网站的信息按原样提供，不附加任何形式的明示或默示的保证。本公司已经采取谨慎措施确保登载的信息的准确性，但不保证本网站信息的绝对准确性和绝对完整性。对于与本网站所提供信息的准确性、安全性等相关的问题，本公司概不负责，并且使用此类信息所带来的结果和风险由您自行承担。<br />
				<br /> 本公司可以随时修改或更新本网站的信息而不另行通知，修改或更新后的内容一经登载在本网站上即发生效力，请您定期访问。<br />
				<br />
				您可能通过本网站访问任何其它的站点，本公司只是为了您的方便提供该等链接，同时本公司保留在任何时候中止任何链接的权利。链接的站点独立于本网站，本网
				站不能控制该站点上的内容，也不对该站点上的内容和信息承担任何责任。对于访问与本网站链接的任何其它站点，所带来的结果和风险全部由您自身承担。<br />
				<br />
				未经本公司的书面同意，不得对本网站的信息、文字、音乐、图片、商标、标识以及其他内容进行传播、修改、复制、发行、出租、出售或以其他方式使用，
				不得对本网站的任何软件进行下载、传播、修改、复制、出租、出售、反编译、反向工程等，不得删除或修改任何版权、商标权、专利权或其他所有权的声明。<br />
				<br /> 本公司没有以任何方式对您授予任何知识产权许可，请您遵守相关法律法规。<br />
				本公司对于任何因本网站使用或链接所引起的任何直接的、间接的、惩罚性的、特殊的、偶然的损失概不负责，包括但不限于业务、收入、利润、信誉、数据或其他
				损失，不管它们是否有保证、合同、侵权行为或任何其它法律根据以及事前已得到这类损害可能发生的忠告。如果您由于使用本网站而导致需要对数据或设备进行维护、修理或纠正，由此产生的任何费用全部由您自身承担。<br />
				<br />
				本使用条款或有关使用本网站的任何行为受中华人民共和国法律管辖，因此发生争议的，双方协商解决。如协商不成时，您同意由本人法定地址所在地的人民法院作出裁决。<br />
				<br /> 本使用条款的解释权以及有关本网站使用的解释权属于本公司所有。
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
	%>
	<script src="./js/terms.js"></script>
</body>

</html>