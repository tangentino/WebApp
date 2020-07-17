<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<titles>LOGIN PAGE</title>
<body>
<form action="/login" method="post">
    <input type="text" placeholder="Enter Username" name="uname" required>
    <input type="password" placeholder="Enter Password" name="psw" required>
    <button type="submit">Login</button>
</form>
</body>
</html>
