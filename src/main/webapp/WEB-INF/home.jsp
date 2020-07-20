<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script>
    function removeClick(){
        return confirm('Are you sure you want to remove this user?');
    }
</script>


<style>
    table,th,td {
        text-align: center;
        vertical-align: middle;
        border: 1px solid black;
    }


</style>

<html>
    <title>Home Page</title>
    <body>
        <div>
            <h2>Welcome, ${username}!</h2>
        </div>
        <table style="width:100%">
            <tr>
                <th>Username</th>
                <th>Firstname</th>
                <th>Surname</th>
                <th></th>
            </tr>
            <c:forEach items="${userList}" var="currentUser">
                <tr>
                    <td> ${currentUser.getUsername()} </td>
                    <td> ${currentUser.getFirstname()} </td>
                    <td> ${currentUser.getSurname()} </td>
                    <td>
                        <form action="/remove" method="post" class="rm-btn">
                            <input name="username" type="hidden" value="${currentUser.getUsername()}">
                            <button type="submit" onclick="return removeClick();">Remove</button>
                        </form>
                    </td>
                    <td>
                        <form action="/edit" method="get">
                            <input name="username" type="hidden" value="${currentUser.getUsername()}">
                            <button type="submit">Edit</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p></p>
        <form action="/add" method="get">
            <button type="submit">Add User</button>
        </form>
        <span>${info}</span>
        <form action="/logout" method="get">
            <button type="submit">Logout</button>
        </form>
    </body>
</html>
