<%--
  Created by IntelliJ IDEA.
  User: ABHIJITH.NUSAM
  Date: 07/06/21
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Failed</title>
</head>
<body>
    <h1>Wrong Credentials</h1>
    <form method="post" action="/login_validate">
        <snap>Username: </snap><snap><input type="text" name="username"/> </snap><br/>
        <snap>Password : </snap><snap><input type="password" name="password"/> </snap><br/>
        <input type="submit" name="Login">
    </form>
</body>
</html>
