<%--
  Created by IntelliJ IDEA.
  User: hanyu
  Date: 2021/3/29
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <%String userName = (String) request.getAttribute("key");%>
        <form action="/myWeb/message/twoadd" method="get">
            <table border="2px" width="200px">
                <tr style="background-color: blue">
                    <td colspan="3" align="center">
                        <font color="white">
                            <input type="text"   style="display:none" name="userName" value="<%=userName%>"/>
                            请在下面写入您的留言：</font>
                    </td>
                </tr>
                <tr style="background-color: blue">
                    <td colspan="3" align="center">
                        <font color="white">
                            时间<input type="datetime-local" name="time"/>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" style="border-style:none;" align="center">
                        <%--<input type="text"/>--%>
                        <textarea cols="40" rows="10" name="text"></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" style="border-style:none;" align="center">
                        <input type="submit" value="发表留言"/>
                        <%--<a href="/myWeb/message/add02?userName=<%=userName%>&text=">发表留言</a>--%>
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
