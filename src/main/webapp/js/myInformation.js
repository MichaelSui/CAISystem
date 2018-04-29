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

// 显示用户原有的信息。
var name = document.getElementById("o_name").value;
var email = document.getElementById("o_email").value;
var phone = document.getElementById("o_phone").value;
var qqOrTim = document.getElementById("o_qqOrTim").value;
var wechat = document.getElementById("o_wechat").value;
document.getElementById("final_userId").setAttribute("value", userId);
document.getElementById("name").setAttribute("value", name);
document.getElementById("email").setAttribute("value", email);
document.getElementById("phone").setAttribute("value", phone);
document.getElementById("qqOrTim").setAttribute("value", qqOrTim);
document.getElementById("wechat").setAttribute("value", wechat);

// 显示用户的在线编程成绩。
var codeScoreNum = document.getElementById("codeScoreNum").value;
for (var i = 0; i < codeScoreNum; i++) {
	var questionId = document.getElementById("codeScoreName" + i).value;
	var score = document.getElementById("codeScoreScore" + i).value;
	var scoreList = document.getElementById("scoreList");
	var td1 = document.createElement("td");
	td1.innerHTML = questionId;
	var td2 = document.createElement("td");
	td2.innerHTML = score;
	var tr = document.createElement("tr");
	tr.appendChild(td1);
	tr.appendChild(td2);
	scoreList.appendChild(tr);
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