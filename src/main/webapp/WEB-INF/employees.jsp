<%@ page import="java.util.List" %>
<%@ page import="org.example.companyemployeeservlet.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09.05.2024
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<% List<Employee> employees = (List<Employee>) request.getAttribute("employees");%>
<body>
<a href="/"> back </a>
<h2>Employees</h2> <a href="/createEmployee">Create Employee</a>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>company name</th>
        <th>action</th>
    </tr>
    <% if (employees != null && !employees.isEmpty()) {%>
    <% for (Employee employee : employees) { %>
    <tr>
        <td><%=employee.getId()%>
        </td>
        <td><%=employee.getName()%>
        </td>
        <td><%=employee.getSurname()%>
        </td>
        <td><%=employee.getEmail()%>
        </td>
        <td><%=employee.getCompany().getName()%>
        </td>
        <td><a href="/removeEmployee?id=<%=employee.getId()%>">Delete</a>
            / <a href="/updateEmployee?id=<%=employee.getId()%>">Update</a></td>
    </tr>
    <%}%>
    <%}%>
</table>
</body>
</html>
