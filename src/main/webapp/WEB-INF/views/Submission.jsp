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
    <h1>Please Add Employee Details......!!!</h1>
    <form method="post" action="Add">
        Employee ID :<input type=number name="id"/><br/>
        Employee Name :<input type="text" name="EmpName"/><br/>
        Employee Department :<input type="text" name="EmpDept"/><br/>
        Employee Blood Group :<input type="text" name="EmpBGrp"/><br/>
        <input type="submit" value="OK">
    </form>
</body>
</html>