<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<titles>Setting Page</title>
<body>
<h2>
    This is content
</h2>
<h3>
    <%
        Date date = new Date();
        out.println(date);
    %>
</h3>
</body>
</html>
