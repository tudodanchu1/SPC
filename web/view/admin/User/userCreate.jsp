<%-- 
    Document   : userCreate
    Created on : May 10, 2023, 5:16:24 PM
    Author     : TADAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="UserCreateController" method="POST">
            Id: <input type="text" name="userID" required=""/> ${errorId}</br>
            email: <input type="text" name="email" required=""/>${errorEmail}</br>
            phone: <input type="text" name="phone" required=""/> ${errorPhone}</br>
            fullname <input type="text" name="fullname" required=""/></br>
            password <input type="text" name="pass" required=""/> </br>

            <input type="submit" name="action" value="Create"/></br>
        </form>
            
</html>
