<%--
  Created by IntelliJ IDEA.
  User: 24253
  Date: 2019/5/28
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h3>success ${requestScope.msg}</h3>
    ${sessionScope.msg}
    <h1/>
    user:
        ${user.username}
        ${user.password}
        ${user.age}
</body>
</html>
