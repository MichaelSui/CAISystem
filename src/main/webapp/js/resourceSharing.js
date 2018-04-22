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
}

/*
 * 文件上传模块的配置。
 */
$('#file-zh').fileinput({
    theme: 'fa',
    language: 'zh'
});