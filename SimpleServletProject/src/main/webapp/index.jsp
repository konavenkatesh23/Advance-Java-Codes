<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting Form</title>
</head>
<body style="font-family: Arial, sans-serif; text-align: center; margin-top: 100px;">
    <h2>Welcome to the Greeting App!</h2>
    <form action="greet" method="post">
        <label for="name">Enter your name:</label>
        <input type="text" id="name" name="name" required />
        <br><br>
        <input type="submit" value="Greet Me" />
    </form>
</body>
</html>
