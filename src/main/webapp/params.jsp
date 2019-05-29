<%--
  Created by IntelliJ IDEA.
  User: 24253
  Date: 2019/5/29
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
    <a href="param/test">绑定</a>

    <%--实体绑定--%>
    <form action="param/save" method="post">
        姓名：<input type="text" name="username">
        id：<input type="text" name="id">
        金额：<input type="text" name="money">
        客户姓名：<input type="text" name="user.username">
        客户id:<input type="text" name="user.id">
        <br/><input type="submit" value="提交">
    </form>
    <hr/>
    <form action="param/save" method="post">
        姓名：<input type="text" name="username">
        id：<input type="text" name="id">
        金额：<input type="text" name="money">

        <%--list--%>
        客户姓名：<input type="text" name="list[0].name">
        客户id:<input type="text" name="list[0].id">
        <%--map--%>
        客户姓名：<input type="text" name="map['one'].name">
        客户id:<input type="text" name="map['one'].id">

        <br/><input type="submit" value="提交">
    </form>
    <hr/>
    <form action="param/save2" method="post">
        姓名：<input type="text" name="name">
        id：<input type="text" name="id">
        日期：<input type="text" name="date">  <%--日期格式可以正常接收2019/12/31格式的日期--%>
        <br/><input type="submit" value="提交">
    </form>
    <hr/>
    <a href="param/getServlet?id=1&username=test">原生ServletAPI</a>
</body>
</html>
