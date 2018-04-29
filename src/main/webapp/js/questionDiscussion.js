// 针对用户登陆后的界面变化。
var userId = document.getElementById("userId").value;
if (userId != "") {
	// 此时已登录。
	var userAuthority = document.getElementById("userAuthority").value;
	var loginButton = document.getElementById("nav-btn-1");
	if (userAuthority == "STUDENT") {
		loginButton.innerHTML = "您好 学生 " + userId;
		var classVal = loginButton.getAttribute("class");
		classVal = classVal.concat(" disabled");
		loginButton.setAttribute("class", classVal);
	} else if (userAuthority == "TEACHER") {
		loginButton.innerHTML = "点击进入教师面板";
		loginButton.href = "goToTeacherPanelAction.do";
	} else if (userAuthority == "ADMIN") {
		loginButton.innerHTML = "点击进入管理员面板";
		loginButton.href = "goToAdminPanelAction.do";
	}
}

// 展示问题探讨模块的相关信息。
var problemId = document.getElementById("problemId").value;
var problemUserId = document.getElementById("problemUserId").value;
var problemContent = document.getElementById("problemContent").value;
var replyCount = document.getElementById("replyCount").value;
var problem_1 = document.getElementById("problem_1");
problem_1.innerHTML = problemUserId;
var problem_2 = document.getElementById("problem_2");
problem_2.innerHTML = problemContent;
var reply = document.getElementById("reply");
for (var i = 0; i < replyCount; i++) {
	var replyId = document.getElementById("reply" + i + "Id").value;
	var replyUserId = document.getElementById("reply" + i + "UserId").value;
	var replyContent = document.getElementById("reply" + i + "Content").value;
	var td1 = document.createElement("td");
	td1.setAttribute("width", "20%");
	td1.innerHTML = replyUserId;
	var td2 = document.createElement("td");
	td2.setAttribute("width", "80%");
	td2.innerHTML = replyContent;
	var tr = document.createElement("tr");
	tr.appendChild(td1);
	tr.appendChild(td2);
	reply.appendChild(tr);
}

// 通知功能。
var noticeNum = document.getElementById("noticeNum").value;
var noticeStr = "";
for (var i = 0; i < noticeNum; i++) {
	var noticeItemDate = document.getElementById("notice" + i + "Date").value;
	var noticeItemMsg = document.getElementById("notice" + i + "Msg").value;
	noticeStr += noticeItemDate + "<br />" + noticeItemMsg + "<br />";
}
$(function() {
	$("#noticeBtn").click(function() {
		var str = noticeStr;
		$("#noticeMsg").html(str);
		$("#noticeBackground").css({
			display : "block",
			height : $(document).height()
		});
		var yscroll = document.documentElement.scrollTop;
		$("#noticeDiv").css("top", "350px");
		$("#noticeDiv").css("display", "block");
		document.documentElement.scrollTop = 0;
	});
	$("#closeBtn").click(function() {
		$("#noticeBackground").css("display", "none");
		$("#noticeDiv").css("display", "none");
	});
})