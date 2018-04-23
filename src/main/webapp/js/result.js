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
 * 饼图的相关参数。
 */
var correctCount = document.getElementById("correctCount").value;
var errorCount = document.getElementById("errorCount").value;
var config = {
	type : 'pie',
	data : {
		datasets : [ {
			data : [ correctCount, errorCount, ],
			backgroundColor : [ "#088A08", "#FF0000", ],
		} ],
		labels : [ '通过用例', '错误用例', ]
	},
	options : {
		responsive : true
	}
};

window.onload = function() {
	var ctx = document.getElementById('chart-area').getContext('2d');
	window.myPie = new Chart(ctx, config);
};