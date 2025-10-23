<%
    // Use the implicit 'session' object directly
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("login.html");
        return;
    }
%>
<html>
<body>
    <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
    <a href="LogoutServlet">Logout</a>
    <p>Session ID: <%= session.getId() %></p>
    <p>Creation Time: <%= new java.util.Date(session.getCreationTime()) %></p>
    <p>Last Accessed Time: <%= new java.util.Date(session.getLastAccessedTime()) %></p>
</body>
</html>
