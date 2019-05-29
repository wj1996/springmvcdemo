<%--
  Created by IntelliJ IDEA.
  User: 24253
  Date: 2019/5/29
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
    <a href="anno/testRequestParam?name=test">testRequestParam</a>
    <hr/>
    <form action="anno/testRequestBody" method="post">
        用户名:<input type="text" name="username" />
        密码:<input type="text" name="password" />
        <br/><input type="submit" value="提交">
    </form>
    <hr/>
    <a href="anno/testPathVaribale/10">testPathVaribale</a>
    <hr/>
    <a href="anno/testRequestHeader">testRequestHeader</a>
    <hr/>
    <a href="anno/testCookieValue">testCookieValue</a>
    <hr/>
    <form action="anno/testModelAttribute" method="post">
        用户名:<input type="text" name="name" />
        密码:<input type="text" name="password" />
        id:<input name="id">
        <br/><input type="submit" value="提交">
    </form>
    <hr/>
    <a href="anno/testSessionAttribute">testSessionAttribute</a>
    <a href="anno/getSessionAttribute">getSessionAttribute</a>
</body>
</html>
