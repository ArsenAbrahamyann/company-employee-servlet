<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 08.05.2024
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Company</title>
</head>
<%List<String> countries = (List<String>) request.getAttribute("countryList");%>
<body>
<a href="/companies"> Back</a>

<h2>Create Company</h2>
<form action="/createCompany" method="post">
    name: <input type="text" name="name"><br>
    country:
    <select> name="country">
    <% for (String country : countries) {%>
    <opyion value="<%=country%>"><%=country%></opyion>
    <%}%>
    </select>
    <input type="submit" value="create">
</form>
</body>
</html>
