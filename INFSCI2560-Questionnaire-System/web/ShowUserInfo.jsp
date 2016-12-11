<%-- 
    Document   : ShowUserInfo
    Created on : Dec 10, 2016, 6:45:52 PM
    Author     : duxia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.showQuestionnaire.ShowUserInfo" %>
<jsp:useBean id="userinfo" class="model.showQuestionnaire.ShowUserInfo" scope="page"/>
<!DOCTYPE html>
<%
    //check whether the role ID of the user has priviledge for current page
    if (request.getSession().getAttribute("userName") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show User Account Information  Overview</title>
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
                        <li><a href="QuestionnaireBasicInfo.jsp">Edit Questionnaire</a></li>
                        <li><a href="showCreatedQuestionnaire.jsp">Show My Questionnaire</a></li>
                        <li><a href="Search.jsp">Search Questionnaire</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Personal Information <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="ShowUserInfo.jsp">View User Info</a></li>
                                <li class="divider"></li>
                                <li class="active"><a href="changepsw.jsp">Change Password</a></li>
                                <li><a href="changeuserinfo.jsp">Change User Info</a></li>
                                <li><a href="upload.jsp">Change User Photo</a></li>
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
                <h1>User Account Information Overview</h1>
            </div>
            <%
                String userID = Integer.toString((int) session.getAttribute("userID"));
            %>
            <jsp:setProperty name="userinfo" property="userID" value="<%= userID%>"/>

            <div class="row">
                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <img src="image/<jsp:getProperty name='userinfo' property='picture' />" width=100 hight=100></img>
                        <div class="caption">
                            <p>
                                <a href="upload.jsp" class="btn btn-primary btn-lg btn-block" role="button">
                                    Change User Picture
                                </a> 
      
                            </p>
                        </div>
                    </div>
                </div>
                        <div class="table-responsive">

                <table class="table table-striped">
                    <caption>User Info</caption>
                    <tbody>
                        <tr>
                            <td>Name</td>
                            <td><jsp:getProperty name="userinfo" property="userName" /></td>
                        </tr>
                        <tr>
                            <td>Gender</td>
                            <td><jsp:getProperty name="userinfo" property="gender" /></td>
                        </tr>
                        <tr>
                            <td>Created</td>
                            <td> <jsp:getProperty name="userinfo" property="createNumber" /></td>
                        </tr>            
                        <tr>
                            <td>Filled</td>
                            <td><jsp:getProperty name="userinfo" property="filledNumber" /></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            </div>

<!--            <div class="table-responsive">

                <table class="table table-striped">
                    <caption>User Info</caption>
                    <tbody>
                        <tr>
                            <td>Name</td>
                            <td><jsp:getProperty name="userinfo" property="userName" /></td>
                        </tr>
                        <tr>
                            <td>Gender</td>
                            <td><jsp:getProperty name="userinfo" property="gender" /></td>
                        </tr>
                        <tr>
                            <td>Created</td>
                            <td> <jsp:getProperty name="userinfo" property="createNumber" /></td>
                        </tr>            
                        <tr>
                            <td>Filled</td>
                            <td><jsp:getProperty name="userinfo" property="filledNumber" /></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <img src=image/<jsp:getProperty name="userinfo" property="picture" /> ></img>-->
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