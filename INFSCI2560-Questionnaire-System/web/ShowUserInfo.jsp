<%-- 
    Document   : ShowUserInfo
    Created on : Dec 10, 2016, 6:45:52 PM
    Author     : duxia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.showQuestionnaire.ShowUserInfo" %>
<jsp:useBean id="userinfo" class="model.showQuestionnaire.ShowUserInfo" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Information</title>
    </head>
    <body>
        <%
            String userID = Integer.toString((int)session.getAttribute("userID"));
            %>
            <jsp:setProperty name="userinfo" property="userID" value="<%= userID%>"/>
        <table>
            <tr>
                <td>
                    <p>Name: </p>
                </td>
                <td>
                    <jsp:getProperty name="userinfo" property="userName" />
                </td>
            </tr>
            <tr>
                <td>
                    <p>Gender: </p>
                </td>
                <td>
                    <jsp:getProperty name="userinfo" property="gender" />
                </td>
            </tr>
            <tr>
                <td>
                    <p>Created: </p>
                </td>
                <td>
                    <jsp:getProperty name="userinfo" property="createNumber" />
                </td>
            </tr>
            <tr>
                <td>
                    <p>Filled: </p>
                </td>
                <td>
                    <jsp:getProperty name="userinfo" property="filledNumber" />
                </td>
            </tr>
        </table>
                <img src=image/<jsp:getProperty name="userinfo" property="picture" /> ></img>
       
 
    </body>
</html>
