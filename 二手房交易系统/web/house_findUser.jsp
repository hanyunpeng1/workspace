<%@ page import="com.hanyun.entity.House" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/31
  Time: 16:54
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
            <td>二手房编号</td>
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
            <%--<td><input type="text" value="买方"/></td>--%>
        </tr>

        <%
            String userName = (String) request.getAttribute("userName");
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
            <td style="border-style:none;"><%=house.getHouseId()%></td>
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
                <a href="/myWeb/deal/add?houseId=<%=house.getHouseId()%>&userNameA=<%=house.getUserName()%>&userNameB=<%=userName%>"
                   target="right" style="text-decoration:none;">购买</a>
            </td>
        <%--    <td style="border-style:none;">
                <input type="text" name="userNameB" value="<%=userName%>"/>
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
