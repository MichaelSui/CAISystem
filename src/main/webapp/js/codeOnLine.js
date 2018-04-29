// 数字左端自动补0。
var MANY_ZEROS = "000000000000000000";

function leftZeroPad(val, minLength) {
	if (typeof (val) != "string")
		val = String(val);
	return (MANY_ZEROS.substring(0, minLength - val.length)) + val;
}

// 获取后台传来的信息并处理问题展示模块。
var questionNumber = document.getElementById("questionNumber").value;

for (var i = 0; i < questionNumber; i++) {
	var element = document.createElement("input");
	element.setAttribute("type", "radio");
	element.setAttribute("name", "question");
	element.setAttribute("value", "question" + leftZeroPad(i + 1, 4));
	element.setAttribute("data-labelauty", "问题" + leftZeroPad(i + 1, 4));
	var elementOutter = document.createElement("li");
	elementOutter.appendChild(element);
	questions.appendChild(elementOutter);
}

$(function() {
	$(':input').labelauty();
});

// 根据DOM元素的id构造出一个编辑器。
var editor = CodeMirror.fromTextArea(document.getElementById("code"), {
	// 实现C++代码高亮。
	mode : "text/x-c++src",
	// 显示行号。
	lineNumbers : true,
	// 设置主题。
	theme : "dracula",
	// 代码折叠。
	lineWrapping : true,
	// 提供折叠的显示区域。
	foldGutter : true,
	gutters : [ "CodeMirror-linenumbers", "CodeMirror-foldgutter" ],
	// 括号匹配
	matchBrackets : true,
});
editor.setSize('100%', '500px');
editor.setValue("");
var scriptCode = "#include<iostream>\nusing namespace std;\n\nint main(int argc, char* argv[])\n{\n\tcout << \"Hello World!\" << endl;\n\treturn 0;\n}";
editor.setValue(scriptCode);

// 根据选择的按钮显示对应的内容。
$(function() {
	$(":radio").click(function() {
		var questionName = $("input:radio:checked").val();
		var num = questionName.replace(/[^0-9]/gi, "");
		var questionDetails = "";
		if (num.replace(/\b(0+)/gi, "") == "") {
			questionName = "questionName0";
			questionDetails = "questionDetails0";
		} else {
			questionName = "questionName" + num.replace(/\b(0+)/gi, "");
			questionDetails = "questionDetails" + num.replace(/\b(0+)/gi, "");
		}
		var questionTitle0 = document.getElementById(questionName).value;
		var questionDetails0 = document.getElementById(questionDetails).value;
		$("#questionTitle").text(questionTitle0);
		$("#questionDetails").text(questionDetails0);
	});
});

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
