<%@ page contentType ="text/html; charset = UTF-8" language = "java" pageEncoding = "UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Register</title>
    </head>
    <body>

        <form action="/enter/signUp" method="post">
            <p><b>Регистрация!!</b></p>
            <p>
                <label for="login">login: </label>
                <input id="login" type="text" name="login">
            </p>
            <p>
                <label for="password">password: </label>
                <input id="password" type="password" name="password">
            </p>
            <p>
                <label for="name">name: </label>
                <input id="name" type="text" name="name">
            </p>
            <p>
                <label for="birth">birth: </label>
                <input id="birth" type="text" name="birth">
            </p>
            <p><input type="submit" value="Зарегистрироваться"></p>
            <c:choose>
                 <c:when test="${requestScope.error}">
                     <p style="color:red;">${requestScope.message}</p>
                 </c:when>
            </c:choose>
        </form>
        <form action="/Register-1.0-SNAPSHOT/enter" method="get">
            <button>Главная страница</button>
        </form>

    </body>
</html>