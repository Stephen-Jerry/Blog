<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/30 0030
  Time: 下午 6:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回成功！</title>
    <style>
        body{
            background:url("../img/1.jpg") no-repeat ;
            background-size: cover;
        }
        span{
            color:red;
        }
        .back{
            background-color: white;
            width:500px;
            height:520px;
            border:5px solid #EEEEEE;
            margin:auto;
        }
    </style>
</head>
<body >
<div class="back">
    <h1 align="center">找回成功！</h1>
    <h3>帐号：</h3><h3>${sessionScope.ID}</h3>
    <h3>密码：</h3><h3>${sessionScope.password}</h3>
    <p align="center"><span id="span">8</span>秒后返回.......</p>
</div>
<script>
    var span=document.getElementById("span")
    var num=8;
    function fun(){
        num--;
        if(num==0){
            location.href="http://localhost/mainc/login.jsp";
        }
        span.innerHTML=num+"";
    }
    setInterval(fun,1000)
</script>
</body>
</html>
