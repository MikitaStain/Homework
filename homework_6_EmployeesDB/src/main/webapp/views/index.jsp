<%@ page contentType ="text/html; charset = UTF-8" language = "java" pageEncoding = "UTF-8"%>

<html>
    <head>
        <title>Working with a database</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/employee" method="post">
        <p><b>Add employee to data base</b></p>
        <p>
                <label for="name">Name: </label>
                <input id="name" type="text" name="name">
        </p>
        <p>
                <label for="salary">Salary: </label>
                <input id="salary" type="number" name="salary">

        </p>


        <p><input type="submit" value="Add"></p>

        <c:choose>
                        <c:when test="${requestScope.error}">
                               <p style="color:red;">${requestScope.message}</p>
                        </c:when>

                </c:choose>
        </form>

        <form action="/EmployesDB-1.0-SNAPSHOT/views/employee.jsp" method="get">
                    <button>See added employee</button>
                </form>

    </body>
</html>