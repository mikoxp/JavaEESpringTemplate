<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Login</title>
</head>
<body>
<form action="login" method="POST">
    <input type="text" name="username" placeholder="Nazwa użytkownika"/>
    <input type="password" name="password" placeholder="Hasło"/>
    <input type="submit" name="submit" value="Zaloguj"/>
</form>
</body>
</html>
