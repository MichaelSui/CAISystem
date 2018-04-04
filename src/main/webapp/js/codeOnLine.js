/*
 * 数字左端自动补0。
 */
var MANY_ZEROS = "000000000000000000";

function leftZeroPad(val, minLength) {
	if (typeof (val) != "string")
		val = String(val);
	return (MANY_ZEROS.substring(0, minLength - val.length)) + val;
}

/*
 * 获取后台传来的信息并处理问题展示模块。
 */
// var questionNumber = 100;//TODO
// var questions = document.getElementById("questions");
//
// for(var i = 0; i < questionNumber; i++) {
// var element = document.createElement("input");
// element.setAttribute("type", "radio");
// element.setAttribute("name", "question");
// element.setAttribute("value", "question" + leftZeroPad(i + 1, 4));
// element.setAttribute("data-labelauty", "问题" + leftZeroPad(i + 1, 4));
// var elementOutter = document.createElement("li");
// elementOutter.appendChild(element);
// questions.appendChild(elementOutter);
// }
$(function() {
	$(':input').labelauty();
});

/*
 * 根据DOM元素的id构造出一个编辑器。
 */
var editor = CodeMirror.fromTextArea(document.getElementById("code"), {
	/*
	 * 实现C++代码高亮。
	 */
	mode : "text/x-c++src",
	/*
	 * 显示行号。
	 */
	lineNumbers : true,
	/*
	 * 设置主题。
	 */
	theme : "dracula",
	/*
	 * 代码折叠。
	 */
	lineWrapping : true,
	/*
	 * 提供折叠的显示区域。
	 */
	foldGutter : true,
	gutters : [ "CodeMirror-linenumbers", "CodeMirror-foldgutter" ],
	/*
	 * 括号匹配
	 */
	matchBrackets : true,
});
editor.setSize('100%', '500px');
editor.setValue("");
var scriptCode = "#include<iostream>\nusing namespace std;\nint main(int argc, char* argv[])\n{\n\tcout << \"Hello World!\" << endl;\n\treturn 0;\n}";
editor.setValue(scriptCode);

/*
 * 根据选择的按钮显示对应的内容。
 */
// $(function() {
// $(":radio").click(function() {
// var questionName = $("input:radio:checked").val();
// questionName += "Title";
// questionDetails += "Details";
// var questionTitle = $(requestScope.questionName);
// var questionDetails = $(requestScope.questionDetails);
// alert(questionTitle + questionDetails);
// $("#questionTitle").text(questionTitle);
// $("#questionDetails").text(questionDetails);
// });
// });
