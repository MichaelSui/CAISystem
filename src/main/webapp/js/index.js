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

	var callToActionMsg = document.getElementById("callToActionMsg");
	callToActionMsg.innerHTML = "欢迎您的登陆";
	var callToActionBtn = document.getElementById("call-to-action-btn-1");
	callToActionBtn.innerHTML = "您好 " + userAuthority + " " + userId;
	classVal = callToActionBtn.getAttribute("class");
	classVal = classVal.concat(" disabled");
	callToActionBtn.setAttribute("class", classVal);
}
