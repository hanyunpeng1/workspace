<%@ page import="com.hanyun.entity.Admin" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/27
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <%--<form action="/myWeb/admin/delete" method="get">--%>
            <table border="2px" >
                <tr align="center">
                    <td>管理员编号</td>
                    <td>管理员账号</td>
                    <td>密码</td>
                    <td colspan="2">操作</td>
                </tr>

                <%
                    List<Admin> list = (List) request.getAttribute("key");
                    for (int i = 0; i < list.size(); i++){
                        Admin admin = list.get(i);
                        if(i%2 == 0){
                %>
                <tr style="background-color: lawngreen">
                        <%
                }else {
             %>
                <tr style="background-color: dodgerblue">
                    <%
                        }
                    %>
                    <%--<td style="border-style:none;"><input type="text" name="adminId" value="<%=admin.getAdminId()%>"/></td>
                    <td style="border-style:none;"><input type="text" name="adminId" value="<%=admin.getAdminName()%>"/></td>
                    <td style="border-style:none;"><input type="text" name="adminId" value="<%=admin.getPassword()%>"/></td>--%>
                    <td style="border-style:none;"><%=admin.getAdminId()%></td>
                    <td style="border-style:none;"><%=admin.getAdminName()%></td>
                    <td style="border-style:none;"><%=admin.getPassword()%></td>
                    <td style="border-style:none;">
                        <%--<a href="/myWeb/admin/delete? adminId = <%=admin.getAdminId()%>" target="right" style="text-decoration:none;">删除信息</a>--%>
                        <a href="/myWeb/admin/delete? adminId=<%=admin.getAdminId()%>" target="right" style="text-decoration:none;">删除信息</a>
                    </td>
                    <td style="border-style:none;">
                        <a href="/myWeb/admin/findById? adminId=<%=admin.getAdminId()%>" target="right" style="text-decoration:none;">更新信息</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        <%--</form>--%>
    </center>
</body>
</html>
