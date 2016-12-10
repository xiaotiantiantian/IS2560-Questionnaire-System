<%-- 
    Document   : showFill
    Created on : Dec 7, 2016, 6:23:16 PM
    Author     : duxia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.showQuestionnaire.ShowFilledResult" %>
<jsp:useBean id="filledQuestionnaire" type="model.showQuestionnaire.ShowFilledResult" scope="request"/>
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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:getProperty name="filledQuestionnaire" property="result"/>
    </body>
</html>
