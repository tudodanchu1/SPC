<%-- 
    Document   : carUpdate
    Created on : May 12, 2023, 2:04:36 PM
    Author     : TADAR
--%>

<%@page import="model.ApartmentBlock"%>
<%@page import="model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <form action="EmployeeUpdateController" method="POST">
            <%Employee c = (Employee) request.getAttribute("employee");%>
            Email: <input type="text" name="email" value="<%out.println(c.getEmail());%>" readonly=""/> </br>
            Password: <input type="text" name="password" value="<%out.println(c.getPassword());%>" required=""/></br>
            Full Name: <input type="text" name="fullname" value="<%out.println(c.getFullName());%>" required=""/> </br>
            Apartment block :  <input type="text" name="AblockID" value="<%out.println(c.getAblockID().getAblockID());%>" readonly=""/> </br>
            <input type="submit" name="action" value="UPDATE"/>
        </form>

</html>
