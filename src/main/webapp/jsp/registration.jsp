<%@ page contentType="text/html; charset=UTF-16" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authentication</title>
</head>
<body>

    <form method="post" action="registration">
        Login:
        <input type="text" name="login" placeholder="Enter your login">

        Password:
        <input type="text" name="password" placeholder="Enter your password">

        <input type="submit" value="Зарегистрироваться">
    </form>

</body>
</html>