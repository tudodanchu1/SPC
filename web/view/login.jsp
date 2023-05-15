<%-- 
    Document   : login
    Created on : Feb 17, 2023, 3:26:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="LoginController" method="POST">
            <h1>Welcome to Admin account management Page</h1>
            Admin ID: <input type ="text" name="tentaikhoan" value="admin" required=""></br>
            Password  : <input type ="password" name="matkhau" value="123" required=""></br>
            <input type="submit" name="action" value="Login"/>
        </form>
        ${errorLogin}</br>
        <a href="RegisterController">Register</a>
    </body>
</html>
