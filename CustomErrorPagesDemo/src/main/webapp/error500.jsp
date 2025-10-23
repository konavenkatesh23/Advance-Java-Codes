<!DOCTYPE html>
<html>
<head><title>Server Error</title></head>
<body style="background-color:#ffeeee;">
    <h2>Something Went Wrong (500)</h2>
    <p>Sorry, an internal server error occurred.</p>
    <a href="index.jsp">Back to Home</a>

    <hr>
    <h4>Metadata:</h4>
    <p>Status Code: <%= request.getAttribute("jakarta.servlet.error.status_code") %></p>
    <p>Exception: <%= request.getAttribute("jakarta.servlet.error.exception") %></p>
    <p>Requested URI: <%= request.getAttribute("jakarta.servlet.error.request_uri") %></p>
    <p>Servlet Name: <%= request.getAttribute("jakarta.servlet.error.servlet_name") %></p>
</body>
</html>
