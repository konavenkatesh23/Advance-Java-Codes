<!DOCTYPE html>
<html>
<head><title>Error Occurred</title></head>
<body style="background-color:#fff0e6;">
    <h2>Unexpected Error</h2>
    <p>We’re sorry, but something went wrong.</p>
    <a href="index.jsp">Back to Home</a>

    <hr>
    <h4>Metadata:</h4>
    <p>Status Code: <%= request.getAttribute("jakarta.servlet.error.status_code") %></p>
    <p>Message: <%= request.getAttribute("jakarta.servlet.error.message") %></p>
    <p>Requested URI: <%= request.getAttribute("jakarta.servlet.error.request_uri") %></p>
    <p>Servlet Name: <%= request.getAttribute("jakarta.servlet.error.servlet_name") %></p>
</body>
</html>
