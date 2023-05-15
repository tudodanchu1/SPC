<%-- 
    Document   : carCreate
    Created on : May 11, 2023, 4:31:54 PM
    Author     : TADAR
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form action="CarCreateController" method="POST">
            CarID: <input type="text" name="id" required=""/> </br>
            Car Name: <input type="text" name="name" required=""/>}</br>
            Car Plate: <input type="number" name="plate" required=""/></br>
            <select name="userID">
                <option value = "NULL"></option>
                <c:forEach var="item" items="${listuser}">
                    <option value="${item.getUserID()}">${item.getUserID()}</option>
                </c:forEach>
            </select>
            <input type="submit" name="action" value="Create"/></br>
        </form>
    </body>
</html>
