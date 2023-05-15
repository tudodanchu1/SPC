<%-- 
    Document   : userCreate
    Created on : May 10, 2023, 5:16:24 PM
    Author     : TADAR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="EmployeeCreateController" method="POST">
            email: <input type="text" name="email" required=""/>${errorEmail}</br>
            fullname <input type="text" name="fullname" required=""/></br>
            password <input type="text" name="pass" required=""/> </br>
            Current apartment block :
            <select name="AblockID">
                <c:forEach var="item" items="${listapartment}">
                    <option value="${item.getAblockID()}">${item.getAblockID()}</option>
                </c:forEach>
            </select>
            <input type="submit" name="action" value="Create"/></br>
        </form>
            
</html>
