<%-- 
    Document   : show
    Created on : Dec 5, 2016, 10:28:25 PM
    Author     : duxia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.showQuestionnaire.QuestionnaireContent" %>
<jsp:useBean id="questionnaireContent" type="model.showQuestionnaire.QuestionnaireContent" scope="request"/>
<!DOCTYPE html>

<%
    //check whether the role ID of the user has priviledge for current page
    if (request.getSession().getAttribute("userName") == null) {
        response.sendRedirect("login.jsp");
    }
%>



<html>
    <body>
        <h1><jsp:getProperty name="questionnaireContent" property="questionnaireTitle"/></h1>
        <form action='FillQuestionnaire' method='post'>
           <jsp:getProperty name="questionnaireContent" property="result"/>
           <br><input type='submit' value='提交' name='submit'>
        </form>

    </body>
    
    
</html>