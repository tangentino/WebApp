<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<style>
    table,th,td {
        text-align: center;
        vertical-align: middle;
        border: 1px solid black;
    }
</style>

<html>

    <title>Adding User</title>
    <body>
        <h3>${info}</h3>
        <form action="/add" method="post" id="add"></form>
        <form action="/" method="get" id="home"></form>
        <table style="width:100%">
            <tr>
                <th>Username</th>
                <th>Firstname</th>
                <th>Surname</th>
                <th>Password</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td> <input type="text" placeholder="Add username" name="username" form="add" required></td>
                <td> <input type="text" placeholder="Add firstname" name="firstname" form="add" required></td>
                <td> <input type="text" placeholder="Add surname" name="surname" form="add" required></td>
                <td> <input type="text" placeholder="Add password" name="password" form="add" required></td>
                <td> <input type="submit" value="Confirm" form="add"></td>
                <td> <input type="submit" value="Cancel" form="home"></td>
            </tr>
        </table>
    </body>
</html>
