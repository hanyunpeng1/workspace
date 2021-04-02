<%@ page import="java.util.List" %>
<%@ page import="com.hanyun.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/27
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table border="2px" >
        <tr align="center">
            <td>用户编号</td>
            <td>用户账号</td>
            <td>密码</td>
            <td>真实姓名</td>
            <td>性别</td>
            <td>地址</td>
            <td>联系电话</td>
            <td>email</td>
            <td>操作</td>
        </tr>

        <%
            List<Users> list = (List) request.getAttribute("key");
            for (int i = 0; i < list.size(); i++){
                Users users = list.get(i);
                if(i%2 == 0){
        %>
        <tr style="background-color: burlywood">
                <%
                }else {
             %>
        <tr style="background-color:darkkhaki">
            <%
                }
            %>
            <td><%=users.getUserId()%></td>
            <td><%=users.getUserName()%></td>
            <td><%=users.getPassword()%></td>
            <td><%=users.getRealName()%></td>
            <td><%=users.getSex()%></td>
            <td><%=users.getAddress()%></td>
            <td><%=users.getTel()%></td>
            <td><%=users.getEmail()%></td>
            <td><a href="/myWeb/user/delete? userId=<%=users.getUserId()%>" target="right" style="text-decoration:none;">删除信息</a></td>
        </tr>
        <%
            }
        %>
    </table>
</center>
</body>
</html>
