<%@ page import="com.hanyun.entity.Deal" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/31
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <%--<form action="/myWeb/deal/update" method="get">--%>
    <table border="2px">
        <tr align="center">
            <td>订单编号</td>
            <td>房屋编号</td>
            <td>卖方姓名</td>
            <td>买方姓名</td>
            <td>完成订单时间</td>
            <td>操作</td>
        </tr>

        <%
            List<Deal> list = (List) request.getAttribute("key");
            for (int i = 0; i < list.size(); i++){
                Deal deal = list.get(i);
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
            <td style="border-style:none;"><%=deal.getDealId()%></td>
            <td style="border-style:none;"><%=deal.getHouseId()%></td>
            <td style="border-style:none;"><%=deal.getUserNameA()%></td>
            <td style="border-style:none;"><%=deal.getUserNameB()%></td>
            <td style="border-style:none;">
                <a href="/myWeb/deal/update? dealId=<%=deal.getDealId()%>" target="right" style="text-decoration:none;">
                    <%=deal.getTime()%>
                </a>
            </td>

            <td style="border-style:none;">
                <a href="/myWeb/deal/delete? dealId=<%=deal.getDealId()%>" target="right" style="text-decoration:none;">删除信息</a>
            </td>
            <!--update houses set status=? where houseId =?-->
        </tr>
        <%
            }
        %>
    </table>
    <%--</form>--%>
</center>
</body>
</html>
