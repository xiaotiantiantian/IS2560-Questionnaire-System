<%-- 
    Document   : register
    Created on : 2016-11-21, 19:38:39
    Author     : qssheep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
    </head>
    <body>
        <form action="register" method="post">
            username:<input type="text" name="username"><br>
            password:<input type="password" name="pwd"><br>
            <legend>gender:</legend>
            <p class="row">
                <input type="radio" id="gender-male" name="gender" value="male"/>
                <label for="gender-male">Male</label>
            </p>
            <p class="row">
                <input type="radio" id="gender-female" name="gender" value="female"/>
                <label for="gender-female">Female</label>
            </p>
            <p class="row">
                <input type="radio" id="gender-others" name="gender" value="others"/>
                <label for="gender-others">Others</label>
            </p>
            <input type="submit">
        </form>
    </body>
</html>
