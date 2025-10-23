<!DOCTYPE html>
<html>
<head><title>Page Not Found</title></head>
<body style="background-color:#ffdddd;">
    <h2>Oops! Page Not Found (404)</h2>
    <p>The page you’re looking for doesn’t exist.</p>
    <a href="index.jsp">Go Home</a>

    <hr>
    <h4>Metadata:</h4>
    <p>Status Code: <%= request.getAttribute("jakarta.servlet.error.status_code") %></p>
    <p>Requested URI: <%= request.getAttribute("jakarta.servlet.error.request_uri") %></p>
    <p>Servlet Name: <%= request.getAttribute("jakarta.servlet.error.servlet_name") %></p>
</body>
</html>
