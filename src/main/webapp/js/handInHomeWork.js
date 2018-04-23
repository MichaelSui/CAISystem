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
 * 文件上传模块的配置。
 */
$('#file-zh').fileinput({
	theme : 'fa',
	language : 'zh'
});

/*
 * 文件下载模块的信息展示。
 */
var fileListNum = document.getElementById("fileListNum").value;
for (var i = 0; i < fileListNum; i++) {
	var element1 = document.createElement("td");
	var fileName = document.getElementById("fileList" + i).value;
	element1.innerHTML = fileName;
	var element_tr = document.createElement("tr");
	element_tr.appendChild(element1);
	var element_tbody = document.getElementById("resourceList");
	element_tbody.appendChild(element_tr);
}