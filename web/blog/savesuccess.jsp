<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/22 0022
  Time: 下午 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>草稿保存成功</title>
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
            height:400px;
            border:5px solid #EEEEEE;
            margin:auto;
        }
    </style>
</head>
<body>
<div class="back">
    <h1 align="center">草稿保存成功</h1>
    <p align="center"><span id="span">6</span>秒后返回.....</p>
</div>
<script>
    var span=document.getElementById("span")
    var num=5;
    function fun(){
        num--;
        if(num==0){
            window.close();
        }
        span.innerHTML=num+"";
    }
    setInterval(fun,1000)
</script>
</body>
</html>
