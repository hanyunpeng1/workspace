<%@ page import="com.hanyun.entity.Message" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/30
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>

    <table border="2px">
        <tr align="center">
            <%--<td>浏览编号</td>--%>
            <td>发部人姓名</td>
            <td>留言</td>
            <td>留言时间</td>
            <%--<td>更新房屋状态</td>--%>
        </tr>

        <%
            List<Message> list = (List) request.getAttribute("key");
            for (int i = 0; i < list.size(); i++){
                Message message = list.get(i);
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

            <td style="border-style:none;"><%=message.getUserName()%></td>
            <td style="border-style:none;"><%=message.getText()%></td>
            <td style="border-style:none;"><%=message.getTime()%></td>
<%--            <td style="border-style:none;">
                <a href="/myWeb/house/delete? houseId=<%=house.getHouseId()%>" target="right" style="text-decoration:none;">删除信息</a>
            </td>--%>
        </tr>
        <%
            }
        %>
    </table>
    <%--</form>--%>
</center>
</body>
</html>
