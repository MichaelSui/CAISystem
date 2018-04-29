// 针对用户登陆后的界面变化。
var userId = document.getElementById("userId").value;
if (userId != "") {
	// 此时已登录。
	var userAuthority = document.getElementById("userAuthority").value;
	var loginButton = document.getElementById("nav-btn-1");
	if (userAuthority == "SUTDENT") {
		loginButton.innerHTML = "您好 学生 " + userId;
		var classVal = loginButton.getAttribute("class");
		classVal = classVal.concat(" disabled");
		loginButton.setAttribute("class", classVal);

		var callToActionMsg = document.getElementById("callToActionMsg");
		callToActionMsg.innerHTML = "欢迎您的登陆";
		var callToActionBtn = document.getElementById("call-to-action-btn-1");
		callToActionBtn.innerHTML = "您好 学生 " + userId;
		classVal = callToActionBtn.getAttribute("class");
		classVal = classVal.concat(" disabled");
		callToActionBtn.setAttribute("class", classVal);
	} else if (userAuthority == "TEACHER") {
		loginButton.innerHTML = "点击进入教师面板";
		loginButton.href = "goToTeacherPanelAction.do";
	} else if (userAuthority == "ADMIN") {
		loginButton.innerHTML = "点击进入管理员面板";
		loginButton.href = "goToAdminPanelAction.do";
	}
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