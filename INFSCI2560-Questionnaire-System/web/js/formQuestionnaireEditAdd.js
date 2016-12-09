/* 
 *  @author Zhirun Tian
 */
var data = "";
var dataWithButton = "";
var isNewQuestion = 0;
var question = 1;
var selection = 1;
function addQuestion() {
    alert("666");
    question = question +1;
    document.getElementById("questionNumber").innerHTML = "Question number is: "+question;
//    if (document.getElementById("Num").value == "" || document.getElementById("Num").value.search("^[0-9]*$") == -1) {
//        document.getElementById("errmsg1").style.display = "block";//判断Num是否为空或不是数字    提示错误
//        document.getElementById("errmsg1").innerHTML = "提示信息：行数为空或不是数字！";
//    } else {
//        document.getElementById("errmsg1").style.display = "none";//隐藏提示信息
//        var Num = parseInt(document.getElementById("Num").value); //获取行数           
//        var flag = true;
//
//        data += " <table >";
//        data += " <tr>" +
//                "<td >we are</td>" +
//                "<td >zhuzhu</td>" +
//                "<td >dudu</td>" +
//                "</tr>";
//        for (var i = 1; i <= Num; i++) {
//            data += "<tr >";
//            data += "<td>" + i + "</td>";
//            data += "<td><input name='ColdDay" + i + "' type='text' class='input'></td>";
//            data += "<td><input name='ColdCureMethod" + i + "' type='text' class='input'></td>";
//            data += "</tr>";
//        }
//
//        data += "</table>";
//        document.getElementById("div1").style.display = "block";
//        document.getElementById("table1").innerHTML = data;
//    }
}

function addSelection(){
    alert("selection add");
        selection =selection+1;
    document.getElementById("questionNumber").innerHTML = "Question number is: "+question+"  "+"Selection number in the question is:"+selection;
}



/////////////////////
///add function to disable the submit button, enable it only all the problem is solved
$(document).ready(function () {
//    if ( $('#abc').length ) //If checking if the element exists, use .length
//        alert("yes");
//    $('input[type="submit"]').attr('disabled','disabled');
});