<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ru">
    <head>
        <title>Ваши сообщения</title>
    </head>
    <body>
        <table border="1">

            <c:forEach items="${requestScope.message}"
            			var="message">
            			<br>

            </c:forEach>

        </table>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/';" value="index" /></p>
    </body>
</html>