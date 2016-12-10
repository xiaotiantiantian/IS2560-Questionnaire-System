<%-- 
    Document   : DuXiao
    Created on : Dec 5, 2016, 10:17:13 PM
    Author     : duxia
--%>

<%
    //check whether the role ID of the user has priviledge for current page
    if (request.getSession().getAttribute("userName") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.showQuestionnaire.ShowSelectionResult" %>
<jsp:useBean id="vagueSearch" class="model.showQuestionnaire.ShowSelectionResult" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            if(session.getAttribute("userID")!=null){
                    System.out.println(Integer.toString((int)session.getAttribute("userID")));       
            }
            String userID =Integer.toString((int)session.getAttribute("userID"));

            %>
        <form action='' method='post'>
            <p>(杜啸)输入调查表的关键字: </p>
            <input type='text' name='keyword'>
            <br><input type='submit' value='提交' name='submit'>
        </form>
            <jsp:setProperty name="vagueSearch" property="userID" value="<%= userID %>"/>
            <jsp:setProperty name="vagueSearch" property="keyword"/>
            <jsp:getProperty name="vagueSearch" property="result"/>
    </body>
</html>
