<%-- 
    Document   : success
    Created on : 2016-11-21, 17:32:12
    Author     : qssheep
--%>


<%@page import="model.userBean"%>
<%@page import="java.util.List"%>


<%
    //log RBAC activity       
        //get client ip addr and request URI for activity log
        String sysSource = request.getRequestURI();
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
        <title>test3</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">IS2731</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="hostilelist.jsp">Hostile</a></li>
                        <li><a href="activitylog.jsp">Activity Log</a></li>
                        <li class="active"><a href="roleManage.jsp">Role Management</a></li>
                        <li><a href="admin.jsp">Admin Page</a></li>
                        <li><a href="RBACtest.jsp">RBAC Test</a></li>
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
        <div class="page-header">
                <h1>Role Management</h1>
        </div>
        
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous">
        </script>
        <script src="js/formCheck.js" type="text/javascript"></script>
    </body>
</html>
