<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<style>
    table,th,td {
        text-align: center;
        vertical-align: middle;
        border: 1px solid #000000;
    }
</style>

<html>

    <title>Editing User Info</title>
    <body>
        <h3>${info}</h3>
        <form action="/edit" method="post" id="edit-f"></form>
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
                <input type="hidden" value="${user.getUsername()}" name="oldname" form="edit-f">
                <td> <input type="text" value="${user.getUsername()}" name="username" form="edit-f" required></td>
                <td> <input type="text" value="${user.getFirstname()}" name="firstname" form="edit-f" required></td>
                <td> <input type="text" value="${user.getSurname()}" name="surname" form="edit-f" required></td>
                <td> <input type="text" name="password" form="edit-f" required></td>
                <td> <input type="submit" value="Confirm" form="edit-f"> </td>
                <td><input type="submit" value="Cancel" form="home"></td>
            </tr>

        </table>
    </body>
</html>
