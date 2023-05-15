<%-- 
    Document   : history
    Created on : May 9, 2023, 4:36:11 PM
    Author     : TADAR
--%>

<%@page import="model.Users"%>
<%@page import="model.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.History"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <table border="1">
            <thead>
                <tr>
                    <th>CarID</th>
                    <th>CarName</th>
                    <th>CarPlate</th>
                    <th>UserID</th>
                    <th>thaotac</th>
                    
                </tr>
            </thead>
            <tbody>
                <%
                    List<Car> ds = (ArrayList<Car>) request.getAttribute("list");
                %>

                <%
                    for (Car x : ds) {
                %>
                <tr>
                    <td>
                        <input type="text" name="name" value="<%=x.getCarID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%=x.getCarName()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%=x.getCarPlate()%>" readonly=""/>
                    </td>
                    <% Users u = null;
            String userID;
                if (x.getUserID() == null) {
             userID = "null";
            }else{
               userID = x.getUserID().getUserID();
            }
                 %>
                    <td>
                        <input type="text" name="name" value="<%=(userID)%>" readonly=""/>
                    </td>
                    <td>
                        <a href="CarDeleteController?id=<%=x.getCarID()%>">Delete</a>
                        <a href="CarUpdateController?id=<%=x.getCarID()%>">update</a>
                    </td>
                    
                </tr>
                <%
                    }
                %> 
            </tbody>
        </table>
             <a href="CarCreateController">Create</a>
</html>
