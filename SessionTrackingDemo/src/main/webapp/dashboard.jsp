<%@ page import="jakarta.servlet.http.*,jakarta.servlet.*" %>
<%
    String user = null;

    if (session != null) {
        user = (String) session.getAttribute("user");
    }

    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
    <h3>Welcome <%= user %></h3>
    <a href="logout">Logout</a>
</body>
</html>
