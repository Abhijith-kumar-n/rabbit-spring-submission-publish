<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Registration Form</title>
</head>
<body>
<form method="get" action="/submit">
    <h1>ADDED....!!!!!!!!!!</h1><br>
    <h2>Details Recevied:</h2>
    <h3>Employee ID : ${id} </h3>
    <h3>Employee Name : ${EmpName}</h3>
    <h3>Employee Dept : ${EmpDept}</h3>
    <h3>Employee BGrp : ${EmpBGrp}</h3>
    <input type="submit" name="Ok" value="submit">
</form>
</body>
</html>