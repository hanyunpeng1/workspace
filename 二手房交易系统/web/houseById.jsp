<%@ page import="com.hanyun.entity.House" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/29
  Time: 13:14
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
    <table border="2px">
        <tr align="center">
            <%--<td>二手房编号</td>--%>
            <td>户型</td>
            <td>面积</td>
            <td>装修</td>
            <td>价格</td>
            <td>地址</td>
            <td>发部人姓名</td>
            <td>发布人联系电话</td>
            <td>发布人编号</td>
            <td>发布状态</td>
            <td>操作</td>
            <%--<td>更新房屋状态</td>--%>
        </tr>

        <%
            List<House> list = (List) request.getAttribute("key");
            for (int i = 0; i < list.size(); i++){
                House house = list.get(i);
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
            <%--<td style="border-style:none;"><%=house.getHouseId()%></td>--%>
            <td style="border-style:none;"><%=house.getType()%></td>
            <td style="border-style:none;"><%=house.getAcreage()%></td>
            <td style="border-style:none;"><%=house.getFinish()%></td>
            <td style="border-style:none;"><%=house.getPrice()%></td>
            <td style="border-style:none;"><%=house.getAddress()%></td>
            <td style="border-style:none;"><%=house.getUserName()%></td>
            <td style="border-style:none;"><%=house.getTel()%></td>
            <td style="border-style:none;"><%=house.getUserId()%></td>
            <td style="border-style:none;"><%=house.getStatus()%></td>
            <td style="border-style:none;">
                <a href="/myWeb/house/delete? houseId=<%=house.getHouseId()%>" target="right" style="text-decoration:none;">删除信息</a>
            </td>
            <%--<td style="border-style:none;">
                <a href="/myWeb/house/update? adminId=<%=house.getHouseId()%>&status=出售中" target="right" style="text-decoration:none;">出售中</a>
                <a href="/myWeb/house/update? adminId=<%=house.getHouseId()%>&status=已出售" target="right" style="text-decoration:none;">已出售</a>
                <a href="/myWeb/house/update? adminId=<%=house.getHouseId()%>&status=审核失败" target="right" style="text-decoration:none;">审核失败</a>
            </td>--%>
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
