<%-- 
    Document   : DuXiao
    Created on : Dec 5, 2016, 10:17:13 PM
    Author     : duxia
--%>

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
        <form action='' method='post'>
            <p>(杜啸)输入调查表的关键字: </p>
            <input type='text' name='keyword'>
            <br><input type='submit' value='提交' name='submit'>
        </form>
<jsp:setProperty name="vagueSearch" property="keyword"/>
<jsp:getProperty name="vagueSearch" property="result"/>
    </body>
</html>
