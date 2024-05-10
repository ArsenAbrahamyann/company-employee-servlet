<%@ page import="java.util.List" %>
<%@ page import="org.example.companyemployeeservlet.model.Company" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<%List<Company> companies = (List<Company>) request.getAttribute("companies");%>
<body>
<a href="/employees"> Back</a>

<h2>Create Company</h2>
<form action="/createEmployee" method="post">
    name: <input type="text" name="name"><br>
    surname: <input type="text" name="surname"><br>
    email: <input type="text" name="email"><br>
    country:
    <select> name="companyId">
    <% for (Company company : companies) {%>
    <opyion value="<%=company.getId()%>"><%=company.getName()%><%=company.getCountry()%></opyion>
    <%}%>
    </select>
    <input type="submit" value="create">
</form>
</body>
</html>
