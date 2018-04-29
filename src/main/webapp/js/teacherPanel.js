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

// 处理学生成绩的显示。
var codeScoreNum = document.getElementById("codeScoreNum").value;
var studentCodeScore = document.getElementById("studentCodeScore");
for (var i = 0; i < codeScoreNum; i++) {
	var td1 = document.createElement("td");
	td1.innerHTML = document.getElementById("codeScore" + i + "UserId").value;
	var td2 = document.createElement("td");
	td2.innerHTML = document.getElementById("codeScore" + i + "QuestionId").value;
	var td3 = document.createElement("td");
	td3.innerHTML = document.getElementById("codeScore" + i + "Score").value;
	var tr = document.createElement("tr");
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	studentCodeScore.appendChild(tr);
}

var codeScore = new Map();
for (var i = 0; i < codeScoreNum; i++) {
	var userId = document.getElementById("codeScore" + i + "UserId").value;
	var score = document.getElementById("codeScore" + i + "Score").value;
	if (codeScore.has(userId)) {
		codeScore.set(userId, parseInt(score) + parseInt(codeScore.get(userId)));
	} else {
		codeScore.set(userId, score);
	}
}
var studentCodeScoreAll = document.getElementById("studentCodeScoreAll");
for (let item of codeScore.entries()) {
	var td1 = document.createElement("td");
	td1.innerHTML = item[0];
	var td2 = document.createElement("td");
	td2.innerHTML = item[1];
	var tr = document.createElement("tr");
	tr.appendChild(td1);
	tr.appendChild(td2);
	studentCodeScoreAll.appendChild(tr);
}

// 处理试题信息的显示。
var questionNum = document.getElementById("questionNum").value;
var questionList = document.getElementById("questionList");
for (var i = 0 ; i < questionNum; i++) {
	var td1 = document.createElement("td");
	td1.innerHTML = document.getElementById("question" + i + "Id").value;
	var td2 = document.createElement("td");
	td2.innerHTML = document.getElementById("question" + i + "QuestionName").value;
	var td3 = document.createElement("td");
	td3.innerHTML = document.getElementById("question" + i + "QuestionDetails").value;
	var tr = document.createElement("tr");
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	questionList.appendChild(tr);
}