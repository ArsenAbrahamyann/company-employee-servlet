<%@ page import="java.util.List" %>
<%@ page import="org.example.companyemployeeservlet.model.Company" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Companies</title>
</head>
<body>
<a href="/"> Back</a>
<h2>Companies</h2> <a href="/createCompany" >Create Company</a>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>country</th>
        <th>action</th>
    </tr>
    <%
        List<Company> companies = (List<Company>) request.getAttribute("companies");
        if (companies != null && !companies.isEmpty()) {
            for (Company company : companies) {
    %>
    <tr>
        <td><%= company.getId() %></td>
        <td><%= company.getName() %></td>
        <td><%= company.getCountry() %></td>
        <td><a href="/removeCompany?id=<%=company.getId()%>">delete</a> / <a href="updateCompany?id=<%=company.getId()%>">Update</a> </td>

    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
