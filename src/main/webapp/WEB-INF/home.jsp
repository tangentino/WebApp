<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<titles>HOME PAGE</title>
<body>
<h2>
    This is content of home page ahaha
</h2>
<h3>
    <%
        Date date = new Date();
        out.println(date);
    %>
</h3>
</body>
</html>
