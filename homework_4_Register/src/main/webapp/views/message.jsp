<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Сообщение</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/messageAcc" method="post">
        <p>
            <label for="login">Кому отправить сообщение? </label>
            <input id="login" type="text" name="login">
        </p>

         <p>
             <label for="message">Введите сообщение </label>
            <input id="message" type="text" name="message">
         </p>

             <button>Отправить</button>

         <c:choose>
            <c:when test="${requestScope.error}">
                 <p style="color:red;">${requestScope.message}</p>
            </c:when>
         </c:choose>


    </form>

    <form action="${pageContext.request.contextPath}/users" method="get">
           <button>Вертнуться назад</button>
    </form>

</body>
</html>