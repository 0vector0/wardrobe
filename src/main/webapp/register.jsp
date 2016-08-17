<%--
  Created by IntelliJ IDEA.
  User: vector
  Date: 17.08.2016
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Registration Form</h1>
<form action="register" method="post">
    <table cellpadding="3pt">
        <tr>
            <td>User Name :</td>
            <td><input type="text" name="userName" size="30" /></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="password" name="password1" size="30" /></td>
        </tr>

        <tr>
            <td>Confirm Password :</td>
            <td><input type="password" name="password2" size="30" /></td>
        </tr>
        <tr>
            <td>email :</td>
            <td><input type="text" name="email" size="30" /></td>
        </tr>
        <tr>
            <td>Phone :</td>
            <td><input type="text" name="phone" size="30" /></td>
        </tr>
        <tr>
            <td>City :</td>
            <td><input type="text" name="city" size="30" /></td>
        </tr>
    </table>
    <p />
    <input type="submit" value="Register" />
</form>

</body>
</html>
