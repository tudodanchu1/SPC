<%-- 
    Document   : history
    Created on : May 9, 2023, 4:36:11 PM
    Author     : TADAR
--%>

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
                    <th>Id</th>
                    <th>CarID</th>
                    <th>TimeIn</th>
                    <th>TimeOut</th>
                  
                </tr>
            </thead>
            <tbody>
                <%
                    List<History> ds = (ArrayList<History>) request.getAttribute("listHistory");
                %>

                <%
                    for (History x : ds) {
                %>
                <tr>
                    <td>
                        <input type="text" name="name" value="<%=x.getHistoryID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%=(x.getCarID().getCarID())%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%=x.getTime_In()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%=x.getTime_Out()%>" readonly=""/>
                    </td>
                   
                    
                </tr>
                <%
                    }
                %> 
            </tbody>
        </table>
</html>
