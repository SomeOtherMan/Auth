<%@ page contentType="text/html; charset=UTF-16" pageEncoding="UTF-16" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authentication</title>
</head>
<body>

    <form method="post" action="auth">
        Login:
        <input type="text" name="login" value="${login}" placeholder="Enter your login">

        Password:
        <input type="text" name="password" value="${password}" placeholder="Enter your password">

        <input type="submit" value="Log in">
    </form>

    <c:if test="${not empty errorMessage}">
        ${errorMessage}
    </c:if>

    <a href="reg">Зарегистрироваться</a>
</body>
</html>