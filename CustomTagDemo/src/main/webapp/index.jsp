<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" uri="http://demo.com/mytags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Custom Tag Demo</title>
</head>
<body>
    <h1>Using Custom JSP Tag</h1>

    <!-- Tag with name -->
    <ct:hello name="Venkatesh" />

    <!-- Tag without name -->
    <ct:hello />
</body>
</html>
