/**
 * 读取Cookie中的用户名和密码信息。
 */
function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=")
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1
			c_end = document.cookie.indexOf(";", c_start)
			if (c_end == -1)
				c_end = document.cookie.length
			return unescape(document.cookie.substring(c_start, c_end))
		}
	}
	return ""
}

var inputName = document.getElementById("inputName");
inputName.value = getCookie("userId");
var inputPassword = document.getElementById("inputPassword");
inputPassword.value = getCookie("userPassword");
