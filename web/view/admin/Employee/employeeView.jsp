<%-- 
    Document   : employeeView
    Created on : May 10, 2023, 4:46:23 PM
    Author     : TADAR
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table border="1">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Full Name</th>
                    <th>Pass</th>
                    <th>Aparment block</th>
                    <th>thao tac</th>
                  
                </tr>
            </thead>
            <tbody>
                <%
                    List<Employee> ds = (ArrayList<Employee>) request.getAttribute("list");
                %>

                <%
                    for (Employee x : ds) {
                %>
                <tr>
                    
                    <td>
                        <input type="text" name="name" value="<%=(x.getEmail())%>" readonly=""/>
                    </td>
                    
                    <td>
                        <input type="text" name="name" value="<%=x.getFullName()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%=x.getPassword()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%=(x.getAblockID().getAblockID())%>" readonly=""/>
                    </td>
                     <td>
                        <a href="EmployeeUpdateController?id=<%=x.getEmail()%>">Update</a>
                        
                    </td>
                   
                   
                    
                </tr>
                <%
                    }
                %> 
            </tbody>
        </table>
            <a href="EmployeeCreateController">Create</a>
    </body>
</html>
