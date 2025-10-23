<%@ page import="com.example.model.Student" %>
<%
Student s = (Student)request.getAttribute("student");
%>
<html>
<body>
<h2>Edit Student</h2>
<form action="edit" method="post">
    <input type="hidden" name="id" value="<%=s.getId()%>">
    Name: <input type="text" name="name" value="<%=s.getName()%>"><br>
    Email: <input type="text" name="email" value="<%=s.getEmail()%>"><br>
    Country: <input type="text" name="country" value="<%=s.getCountry()%>"><br>
    <input type="submit" value="Update Student">
</form>
</body>
</html>
