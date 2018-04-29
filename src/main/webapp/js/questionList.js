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

// 提问信息的展示。
var problemNum = document.getElementById("problemNum").value;
for (var i = 0; i < problemNum; i++) {
	var problemId = document.getElementById("p" + i + "_problemId").value;
	var userId = document.getElementById("p" + i + "_userId").value;
	var content = document.getElementById("p" + i + "_content").value;
	var element1 = document.createElement("td");
	element1.innerHTML = userId;
	var element2 = document.createElement("td");
	element2.innerHTML = content;
	var element3 = document.createElement("td");
	var element_a = document.createElement("a");
	var href = "./goToProblemAction.do?problemId=" + problemId;
	element_a.setAttribute("href", href);
	element_a.innerHTML = "点击跳转到该问题页面";
	element3.appendChild(element_a);
	var element = document.createElement("tr");
	element.appendChild(element1);
	element.appendChild(element2);
	element.appendChild(element3);
	var element_tbody = document.getElementById("problemList");
	element_tbody.appendChild(element);
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