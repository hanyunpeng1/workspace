<%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/27
  Time: 13:54
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
        String userName = (String)request.getAttribute("key");
    %>
    <table border="2px" width="200px">
        <tr style="background-color: blue">
            <td colspan="3" align="center">
                <font color="white">欢迎你：<%=userName%></font>
            </td>
        </tr>
        <tr>
            <td colspan="3" style="border-style:none;" align="center">
                <a href="/myWeb" target="_parent" style="text-decoration:none;">退出</a>
            </td>
        </tr>
        <tr style="background-color: blue">
            <td colspan="3" align="center">
                <font color="white">用户信息</font>
            </td>
        </tr>
        <tr>
            <td colspan="3" style="border-style:none;" align="center">
                <a href="/myWeb/user/findById?userName=<%=userName%>" target="2" style="text-decoration:none;">查看我的信息</a>
            </td>
        </tr>
        <tr>
            <td colspan="3" style="border-style:none;" align="center">
                <a href="/myWeb/user/findById?userName=<%=userName%>" target="2" style="text-decoration:none;">修改我的信息</a>
            </td>
        </tr>

        <tr>
            <td colspan="3" style="border-style:none;" align="center">
                <a href="/myWeb/message/add?userName=<%=userName%>" target="2" style="text-decoration:none;">我要留言</a>
            </td>
        </tr>
        <tr>
            <td colspan="3" style="border-style:none;" align="center">
                <a href="/myWeb/message/findById?userName=<%=userName%>" target="2" style="text-decoration:none;">查看留言</a>
            </td>
        </tr>

        <tr style="background-color: blue">
            <td colspan="3" align="center">
                <font color="white">我的出售信息</font>
            </td>
        </tr>
        <tr>
            <td colspan="3" style="border-style:none;" align="center">
                <a href="/myWeb/house/findById?userName=<%=userName%>" target="2" style="text-decoration:none;">我的出售信息</a>
            </td>
        </tr>
        <tr>
            <td colspan="3" style="border-style:none;" align="center">
                <a href="/myWeb/houseAdd.html" target="2" style="text-decoration:none;">发布出售信息</a>
            </td>
        </tr>

        <tr style="background-color: blue">
            <td colspan="3" align="center">
                <font color="white">我要买房</font>
            </td>
        </tr>
        <tr>
            <td colspan="3" style="border-style:none;" align="center">
                <a href="/myWeb/house/findUser?userName=<%=userName%>" target="2" style="text-decoration:none;">查看出售的房源</a>
            </td>
        </tr>
        <tr>
            <td colspan="3" style="border-style:none;" align="center">
                <a href="/myWeb/deal/findById?userName=<%=userName%>" target="2" style="text-decoration:none;">查看我的购房信息</a>
            </td>
        </tr>

    </table>
</center>
</body>
</html>
