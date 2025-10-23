<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Student" %>
<html>
<body>
<h2>Student List</h2>
<a href="addStudent.jsp">Add New Student</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Country</th><th>Actions</th></tr>
<%
List<Student> list = (List<Student>)request.getAttribute("listStudent");
for(Student s : list){
%>
<tr>
    <td><%=s.getId()%></td>
    <td><%=s.getName()%></td>
    <td><%=s.getEmail()%></td>
    <td><%=s.getCountry()%></td>
    <td>
        <a href="edit?id=<%=s.getId()%>">Edit</a>
        <a href="delete?id=<%=s.getId()%>">Delete</a>
    </td>
</tr>
<% } %>
</table>
</body>
</html>
