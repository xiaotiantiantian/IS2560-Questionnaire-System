<%-- 
    Document   : fail
    Created on : 2016-11-21, 12:54:55
    Author     : qssheep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  String err = (String) session.getAttribute("err");
            out.print("<h1>"+err+"</h1>");
            String username = (String) session.getAttribute("userName");
            if(username != null)
                out.print("<a href='loginsuccess.jsp'>back to index page</a>");
            else
                out.print("<a href='index.html'>back to index page</a>");
        %>
   </body>
</html>
