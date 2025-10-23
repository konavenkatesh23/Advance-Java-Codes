<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h2>Hello, <%= user.getName() %>! Welcome to MVC Demo.</h2>
    <a href="index.jsp">Go Back</a>
</body>
</html>
