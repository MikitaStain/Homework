<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Акаунт</title>
</head>
<body>
    <h3>Привет</h3>
    <p>${user.name}</p>



    <form action="/Register-1.0-SNAPSHOT/messageAcc" method="get">
         <button>Отправить сообщение</button>
    </form>

    <form action="/Register-1.0-SNAPSHOT/views/listMessage.jsp">
         <button>Посмотреть сообщения</button>
    </form>

    <form action="/Register-1.0-SNAPSHOT/enter" method="get">
             <button>Главная страница</button>
    </form>


</body>
</html>