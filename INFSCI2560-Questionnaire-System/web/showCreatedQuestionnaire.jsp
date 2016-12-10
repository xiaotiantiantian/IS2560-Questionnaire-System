<%-- 
    Document   : showCreatedQuestionnair
    Created on : Dec 9, 2016, 2:32:21 PM
    Author     : duxia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.showQuestionnaire.ShowCreatedQuestionnair" %>
<jsp:useBean id="createdQuestionnaire" class="model.showQuestionnaire.ShowCreatedQuestionnair" scope="page"/>
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
        <%
            String userID = Integer.toString((int)session.getAttribute("userID"));
            %>
            <jsp:setProperty name="createdQuestionnaire" property="userID" value="<%= userID%>"/>
        <jsp:getProperty name="createdQuestionnaire" property="result"/>
    </body>
</html>
