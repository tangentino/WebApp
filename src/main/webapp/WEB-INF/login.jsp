<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<titles>LOGIN PAGE</title>
<body>
<p>
    ${error}
</p>
<form action="/login" method="post">
    <input type="text" placeholder="Enter Username" name="username" required><br>
    <input type="password" placeholder="Enter Password" name="password" required><br>
    <button type="submit">Login</button>
</form>
<a href="/register">
    Register New User
</a>
</body>
</html>
