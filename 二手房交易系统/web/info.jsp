<%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/23
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <%
            String result = (String) request.getAttribute("key");
        %>
        <font style="color: red" font-size="40px">
            <%=result%>

        </font>
    </center>
</body>
</html>
