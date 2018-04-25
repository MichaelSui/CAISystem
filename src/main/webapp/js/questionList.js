/**
 * 针对用户登陆后的界面变化。
 */
var userId = document.getElementById("userId").value;
if (userId != "null") {
	/*
	 * 此时已登录。
	 */
	var userAuthority = document.getElementById("userAuthority").value;
	var loginButton = document.getElementById("nav-btn-1");
	loginButton.innerHTML = "您好 " + userAuthority + " " + userId;
	var classVal = loginButton.getAttribute("class");
	classVal = classVal.concat(" disabled");
	loginButton.setAttribute("class", classVal);
}

/*
 * 提问信息的展示。
 */
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
	/* element3.innerHTML = "./goToProblemAction.do?problemId=" + problemId; */
	var element = document.createElement("tr");
	element.appendChild(element1);
	element.appendChild(element2);
	element.appendChild(element3);
	var element_tbody = document.getElementById("problemList");
	element_tbody.appendChild(element);
}