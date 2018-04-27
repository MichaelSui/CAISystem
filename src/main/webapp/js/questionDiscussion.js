/*
 * 针对用户登陆后的界面变化。
 */
var userId = document.getElementById("userId").value;
if (userId != "") {
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
 * 展示问题探讨模块的相关信息。
 */
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