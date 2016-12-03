<%-- 
    Document   : hostilelist
    Created on : Apr 10, 2016, 3:21:53 AM
    Author     : Zhirun Tian
--%>



<%@page import="model.QuestionnaireModel"%>
<%@page import="dataAccessObject.QuestionnaireDao"%>
<%@page import="model.QuestionAndSelection"%>
<%@page import="java.util.List"%>
<%@ page import="controller.Questionnaire" %> 




<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test2</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
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
                        <li><a href="index.jsp">Home</a></li>
                        <li class="active"><a href="QuestionnaireEdit.jsp">Edit Questionnaire</a></li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <!--put the name on the navigation bar-->
                        <br>
                        <%                            if (request.getSession().getAttribute("user") != null) {
//                                UserAccountInfo user = (UserAccountInfo) session.getAttribute("user");
//                                out.print("<a href='#'>" + user.getFirstName() + user.getLastName() + "</a>");
                                out.print("&nbsp;&nbsp;|&nbsp;&nbsp;");
                                out.print("<a href='LogOut'>Log Out</a>");
                            }
                        %>

                    </ul> 
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <!--content part--->
        <div class="container" style="margin-top:100px; margin-bottom:250px;">
            <div class="page-header">
                <h1 href="Questionnaire">Edit Questionnaire</h1>
            </div>

            <form name="edit_questionnaire" method="POST" action="Questionnaire">
        <!--        <input type="hidden" name="token" value="${param.token}">-->
                Enter Title <input name="Title" type="text" value="demo" />
                <br/><br/>
           

                <input type="submit">
            </form>

           
        </div><!--container-->

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous">
        </script>
    </body>

</html>
