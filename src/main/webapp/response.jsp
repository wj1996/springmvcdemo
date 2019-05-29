<%--
  Created by IntelliJ IDEA.
  User: 24253
  Date: 2019/5/29
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>  <%--注意这个地方的写法，如果写闭合的 不会生效--%>
    <script>
        $(function(){
            $("#btn").click(function(){
                // alert("hello");
                //发送ajax请求
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"test","password":"123","age":"12"}',
                    dataType:'json',
                    type:"post",
                    success:function(data){
                        alert(data);
                        console.log(data);
                    }
                })
            });
        })
    </script>
</head>
<body>
    <a href="user/testString">testString</a><br/>
    <a href="user/testVoid">testVoid</a><br/>
    <a href="user/testModelAndView">testModelAndView</a><br/>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br/>
    <hr/>
    <button id="btn">发送ajax的请求</button>
</body>
</html>
