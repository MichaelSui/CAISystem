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
	loginButton.href = "#";

	var callToActionMsg = document.getElementById("callToActionMsg");
	callToActionMsg.innerHTML = "欢迎您的登陆";
	var callToActionBtn = document.getElementById("call-to-action-btn-1");
	callToActionBtn.innerHTML = "您好 " + userAuthority + " " + userId;
	callToActionBtn.href = "#";
}
