<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.beans.User" %>

<jsp:useBean id="user" class="com.example.beans.User" scope="request" />
<%
    // Get parameters from form
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    // Set values into bean
    user.setName(name);
    user.setEmail(email);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result Page</title>
</head>
<body>
    <h2>User Details Submitted</h2>
    <p>Name: <b><jsp:getProperty name="user" property="name"/></b></p>
    <p>Email: <b><jsp:getProperty name="user" property="email"/></b></p>
</body>
</html>
