<%-- 
    Document   : QuestionnaireBasicInfo
    Created on : Dec 5, 2016, 9:10:55 PM
    Author     : Zhirun Tian
--%>

<!DOCTYPE html>
<%@page import="model.QuestionnaireModel"%>
<%@page import="dataAccessObject.QuestionDao"%>
<%@page import="model.QuestionAndSelection"%>
<%@page import="java.util.List"%>
<%@ page import="controller.Questionnaire" %> 
<%@ page import="dataAccessObject.QuestionnaireDao" %> 

<%
    //check whether the role ID of the user has priviledge for current page
    if (request.getSession().getAttribute("userName") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Questionnaire</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    </head>
    <!--<script src="js/formQuestionnaireEditAdd.js?ver=2" type="text/javascript"></script>-->
    <body>

        <!-- Fixed navbar -->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">IS2560</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="loginsuccess.jsp">Home</a></li>
                        <li class="active"><a href="QuestionnaireBasicInfo.jsp">Edit Questionnaire</a></li>
                        <li><a href="showCreatedQuestionnaire.jsp">Show My Questionnaire</a></li>
                        <li><a href="Search.jsp">Search Questionnaire</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Personal Information <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">View User Info</a></li>
                                <li class="divider"></li>
                                <li><a href="changepsw.jsp">Change Password</a></li>
                                <li><a href="changeuserinfo.jsp">Change User Info</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <!--put the name on the navigation bar-->
                        <br>
                        <%                            if (request.getSession().getAttribute("userName") != null) {
                                String username = (String) session.getAttribute("userName");
                                out.print("<a href='#'>" + username + "</a>");
                                out.print("&nbsp;&nbsp;|&nbsp;&nbsp;");
                                out.print("<a href='LogOut'>Log Out</a>");
                            }
                        %>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>


        <!-- Begin page content -->
        <div class="container" style="margin-top:100px;margin-bottom:250px;">

            <div class="page-header">
                <h1>Edit Questionnaire</h1>
            </div>

            <!-- some script about add question and selecton-->
            <script language="javascript">
                var countSelection = 0;
                var countQuestion = 1;
                var maxSelection = 5;
//                var maxQuestion = 225
//                增加元素
                function addSelection() {
                    if (countSelection >= maxSelection) {
//                        countQuestion
                        return;//限制最多maxSelection个文件框
                    }
                    countSelection++;
//自增id不同的HTML对象，并附加到容器最后
                    var newDiv = "<div class='form-group' id=selectionQ" + countQuestion + "Sel" + countSelection + ">"
                            + "<label for='questionnaireQ" + countQuestion + "Sel" + countSelection + "'>Selection " + countSelection + "</label>"
                            + " <input id='questionnaireQ" + countQuestion + "Sel" + countSelection + "' class='form-control' name='questionnaireQ" + countQuestion + "Sel" + countSelection + "'  placeholder='input text here' maxlength='254'  required='' type='text'>"
                            + " <a href=javascript:delSelection('selectionQ" + countQuestion + "Sel" + countSelection + "');>delete</a>"
                            + " </div>";
                    document.getElementById("Questionnaire").insertAdjacentHTML("beforeEnd", newDiv);
                }
//删除指定元素
                function delSelection(diva) {
                    countSelection--;
                    document.getElementById(diva).parentNode.removeChild(document.getElementById(diva));
                }
                function addQuestion() {
                    countSelection = 0;
                    countQuestion++;
                    var newDiv = " <div class=\"form-group\">"
                            + " <label for=\"questionnaireQ" + countQuestion + "\"><h3>Question " + countQuestion + "</h3></label>"
                            + "<input name=\"questionnaireQ" + countQuestion + "\" id=\"questioinnaireQ" + countQuestion + "\" type=\"text\" class=\"form-control\" placeholder=\"input text here\" maxlength=\"254\" required>"
                            + "<p class=\"row\">"
                            + "<input type=\"radio\" id=\"question-type-single" + countQuestion + "\" name=\"question-type" + countQuestion + "\" value=\"S\"/>"
                            + "<label for=\"question-type-single" + countQuestion + "\">Single Selection Question</label>"
                            + "<input type=\"radio\" id=\"question-type-multiple" + countQuestion + "\" name=\"question-type" + countQuestion + "\" value=\"M\"/>"
                            + "<label for=\"question-type-multiple" + countQuestion + "\">Multiple Selection Question</label>"
                            + "<input type=\"radio\" id=\"question-type-fillblank" + countQuestion + "\" name=\"question-type" + countQuestion + "\" value=\"F\"/>"
                            + "<label for=\"question-type-fillblank" + countQuestion + "\">Fill in blank Question</label>"
                            + "</p>"
                            + "</div>"
                            + "<button type=\"button\" id=\"addSelection" + countQuestion + "\" class=\"btn btn-default\" onclick = \"addSelection();\">Add Selection</button>"
                            + "<button type=\"button\" id=\"addQuestion" + countQuestion + "\" class=\"btn btn-default\" onclick = \"addQuestion();\">Add Question</button> "
                            + " <a href=javascript:delSelection('selection" + countSelection + "');>delet</a>";
                    document.getElementById("Questionnaire").insertAdjacentHTML("beforeEnd", newDiv);

                }
            </script>
            <!--management area-->
            <div class="ManagementArea" style="margin-top:30px">
                <form id="Questionnaire" action="Questionnaire" method="post">
                    <div class="form-group">
                        <label for="questionnaireTitle"><h2>Questionnaire Title</h2></label>
                        <input name="questionnaireTitle" id="questionnaireTitle" type="text" class="form-control"  placeholder="input a title here" maxlength="254"  required>
                    </div>
                    <div class="form-group">
                        <label for="questionnaireQ1"><h3>Question 1</h3></label>
                        <input name="questionnaireQ1" id="questionnaireQ1" type="text" class="form-control"  placeholder="input text here" maxlength="254"  required>
                        <label for="sel1">Select list:</label>
                        <select class="form-control" id="questiont-type1">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                        <!--                        <p class="row">
                                                    <input type="radio" id="question-type-single" name="question-type1" value="S"/>
                                                    <label for="question-type-single">Single Selection Question</label>
                                                    <input type="radio" id="question-type-single" name="question-type1" value="M"/>
                                                    <label for="question-type-multiple">Multiple Selection Question</label>                           
                                                    <input type="radio" id="question-type-single" name="question-type1" value="F"/>
                                                    <label for="question-type-fillblank">Fill in blank Question</label>                            
                                                </p>-->
                    </div>
                    <button type="submit" id="submit" class="btn btn-default">Submit</button>
                    <button type="button" id="addSelection1" class="btn btn-default" onclick = "addSelection();">Add Selection</button>
                    <button type="button" id="addQuestion1" class="btn btn-default" onclick = "addQuestion();">Add Question</button>       

                </form>
                <div class="message">
                    <!--show message when change role successfully-->
                    <%                        if (request.getAttribute("message") != null && !request.getAttribute("message").equals("")) {
                            out.print(request.getAttribute("message"));
                        }
                    %>
                    <div id="errEmailMsg" style="color: red;"></div>

                </div>
            </div><!--management area-->


        </div><!--container-->

        <footer class="footer">
            <div class="container">
                <p class="text-muted">&copy; 2016 Web Technology and Standard &middot; <a href="#">Privacy</a>
                    &middot; <a href="#">Terms</a></p>
            </div>
        </footer>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <script src="js/formCheck.js" type="text/javascript"></script>
        <!--<script src="js/formQuestionnaireEditAdd.js?ver=2" type="text/javascript"></script>-->
    </body>
</html>

