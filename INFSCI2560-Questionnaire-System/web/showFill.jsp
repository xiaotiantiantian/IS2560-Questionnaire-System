<%-- 
    Document   : showFill
    Created on : Dec 7, 2016, 6:23:16 PM
    Author     : duxia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.showQuestionnaire.ShowFilledResult" %>
<jsp:useBean id="filledQuestionnaire" type="model.showQuestionnaire.ShowFilledResult" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:getProperty name="filledQuestionnaire" property="result"/>
    </body>
</html>
