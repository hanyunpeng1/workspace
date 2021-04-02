<%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/31
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <%String dealId = (String) request.getAttribute("key");%>
        <form action="/myWeb/deal/upTime">
            <table border="2px" width="200px">
                <tr style="background-color: blue">
                    <td colspan="3" align="center">
                        <font color="white">
                            <input type="text"   style="display:none" name="dealId" value="<%=dealId%>"/>
                            请输入订单的交易时间：</font>
                    </td>
                </tr>
                <tr style="background-color: blue">
                    <td colspan="3" align="center">
                        <font color="white">
                            <input type="datetime-local" name="time"/>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" style="border-style:none;" align="center">
                        <input type="submit" value="更新订单交易时间"/>
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
