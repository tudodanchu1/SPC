<%-- 
    Document   : userUpdate
    Created on : May 12, 2023, 1:20:18 PM
    Author     : TADAR
--%>

<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="UserUpdateController" method="POST">
        <%Users u = (Users) request.getAttribute("user");%>
            Id: <input type="text" name="userID" value="<%out.println(u.getUserID());%>" readonly=""/></br>
            email: <input type="text" name="email" value="<%out.println(u.getEmail());%>" required=""/>${errorEmail}</br>
            phone: <input type="text" name="phone" value="0<%out.println(u.getPhoneNumber());%>" required=""/> ${errorPhone}</br>
            fullname <input type="text" name="fullname" value="<%out.println(u.getFullName());%>" required=""/></br>
            password <input type="text" name="pass" value="<%out.println(u.getPass());%>" required=""/> </br>

            <input type="submit" name="action" value="Update"/></br>
        </form>
</html>
