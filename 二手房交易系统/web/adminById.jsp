<%@ page import="com.hanyun.entity.Admin" %><%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/28
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%Admin admin = (Admin) request.getAttribute("key");%>
    <center>
        <form action="/myWeb/admin/update" method="get">
            <table border="2px";>
                <tr>
                    <td>管理员编号：</td>
                    <td><input type="text" name="adminId" value="<%=admin.getAdminId()%>"/></td>
                </tr>
                <tr>
                    <td>管理员账号：</td>
                    <td><input type="text" name="adminName" value="<%=admin.getAdminName()%>"/></td>
                </tr>
                <tr>
                    <td>管理员密码：</td>
                    <td><input type="text" name="password" value="<%=admin.getPassword()%>"/></td>
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
