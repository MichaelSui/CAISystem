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
 * 显示用户原有的信息。
 */
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

/*
 * 显示用户的在线编程成绩。
 */
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