<%@ page contentType ="text/html; charset = UTF-8" language = "java" pageEncoding = "UTF-8"%>

<html>
    <head>
        <title>Enter in account</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/enter/signIn" method="post">
        <p><b>Вход в аккаунт</b></p>
        <p>
                <label for="login">login: </label>
                <input id="login" type="text" name="login">
        </p>
        <p>
                <label for="password">password: </label>
                <input id="password" type="password" name="password">
        </p>
        <c:choose>
                <c:when test="${requestScope.error}">
                       <p style="color:red;">${requestScope.message}</p>
                </c:when>

        </c:choose>
        <p><input type="submit" value="Войти"></p>
        </form>

        <form action="/Register-1.0-SNAPSHOT/enter" method="get">
                 <button>Главная страница</button>
        </form>

