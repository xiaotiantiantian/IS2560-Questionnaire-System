<%-- 
    Document   : show
    Created on : Dec 5, 2016, 10:28:25 PM
    Author     : duxia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.showQuestionnaire.QuestionnaireContent" %>
<%--<%@page import="model.showQuestionnaire.ShowFilledResult" %>--%>
<jsp:useBean id="questionnaireContent" type="model.showQuestionnaire.QuestionnaireContent" scope="request"/>
<%--<jsp:useBean id="showResult" type="model.showQuestionnaire.ShowFilledResult" scope="request"/>--%>
<!DOCTYPE html>
<html>
    <body>
        <h1><jsp:getProperty name="questionnaireContent" property="questionnaireTitle"/></h1>
        <form action='FillQuestionnaire' method='post'>
           <jsp:getProperty name="questionnaireContent" property="result"/>
           <br><input type='submit' value='提交' name='submit'>
        </form>

    </body>
    
    
</html>
