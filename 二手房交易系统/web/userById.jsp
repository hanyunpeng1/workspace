<%@ page import="com.hanyun.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/28
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%Users user = (Users) request.getAttribute("key");%>
<center>
    <form action="/myWeb/user/update" method="get">
        <table border="2px";>
            <tr>
                <td>用户编号：</td>
                <td><input type="text" name="userId" value="<%=user.getUserId()%>"/></td>
            </tr>
            <tr>
                <td>用户账号：</td>
                <td><input type="text" name="userName" value="<%=user.getUserName()%>"/></td>
            </tr>
            <tr>
                <td>用户密码：</td>
                <td><input type="text" name="password" value="<%=user.getPassword()%>"/></td>
            </tr>
            <tr>
                <td>真实姓名：</td>
                <td><input type="text" name="realName" value="<%=user.getRealName()%>"/></td>
            </tr>
            <tr>
                <td>用户性别：</td>
                <td><input type="text" name="sex" value="<%=user.getSex()%>"/></td>
            </tr>
            <tr>
                <td>用户地址：</td>
                <td><input type="text" name="address" value="<%=user.getAddress()%>"/></td>
            </tr>
            <tr>
                <td>用户电话：</td>
                <td><input type="text" name="tel" value="<%=user.getTel()%>"/></td>
            </tr>
            <tr>
                <td>Email：</td>
                <td><input type="text" name="email" value="<%=user.getEmail()%>"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="更新信息"/></td>
                <td><input type="reset"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
