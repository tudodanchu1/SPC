<%-- 
    Document   : carUpdate
    Created on : May 12, 2023, 2:04:36 PM
    Author     : TADAR
--%>

<%@page import="model.Users"%>
<%@page import="model.Car"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <form action="CarUpdateController" method="POST">
        <%Car c = (Car) request.getAttribute("car");%>
            CarID: <input type="text" name="id" value="<%out.println(c.getCarID());%>" readonly=""/> </br>
            Car Name: <input type="text" name="name" value="<%out.println(c.getCarName());%>" required=""/></br>
            Car Plate: <input type="text" name="plate" value="<%out.println(c.getCarPlate());%>" required=""/> </br>
            <% Users u = null;
            String userID;
                if (c.getUserID() == null) {
             userID = "null";
            }else{
               userID = c.getUserID().getUserID();
            }
            %>
            Customer ID :  <input type="text" name="userID" value="<%out.println(userID);%>" readonly=""/> </br>
            <input type="submit" name="action" value="UPDATE"/>
        </form>

</html>
