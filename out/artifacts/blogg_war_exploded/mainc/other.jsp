<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/23 0023
  Time: 下午 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>TA的主页</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="../js/bootstrap.min.js"></script>
    <style>
        body{
            background:url("../img/1.jpg") no-repeat ;
            background-size: cover;
        }
        #img{
            height: 30px;
            pedding:0px;
        }
        #submit{
            color:white;
            background-color: brown;
        }
        #button{
            color:white;
            background-color: brown;
        }
        .touxiang{
            width:40px;
            height:40px;
            margin-top: 5px;
        }
        .head{
            border:3px solid;
            margin-top: -20px;
            background-image: url("../img/5.jpg");
            background-color: white;
            width:100%;
            height:180px;;
        }
        .touxiang2{
            width:85px;
            height:85px;
            margin-left: 40px;
            margin-top: 30px;
        }
        .shenzi{
            border:3px solid;
            background-color: white;
            height:230px;
            width:15%;
            margin-left:20px;
            margin-top: 10px;
        }
        .you{
            border:3px solid;
            background-color: white;
            height:650px;
            width:60%;
            margin-top: -230px;
            margin-left: 350px;
        }
    </style>
    <script>
        window.onload=function(){
            $(".touxiang").click(function(){
                window.location.href="person.jsp"
            })
        }

    </script>
</head>
<body>

<div class="container-fluid head">
    <div><img src="${sessionScope.per.photo}" class="img-circle touxiang2"><h1 style="color:white">username:${sessionScope.per.username}</h1></div>
</div>
<div class="container-fluid">
    <div class="container-fluid shenzi">
        <ul class="nav nav-pills  nav-stacked">
            <li role="presentation" class="active"><a href="/otherServlet?bloguserid=${sessionScope.bloguserid}&userid=${sessionScope.userid}">他的资料</a></li>
            <hr>
            <li role="presentation"><a href="/otherpageServlet?bloguserid=${bloguserid}&userid=${userid}">他的博客</a></li>
            <hr>
            <li role="presentation"><a href="/othersortpageServlet?bloguserid=${sessionScope.bloguserid}&userid=${sessionScope.userid}">他的专栏</a></li>
        </ul>
    </div>
    <div class="container-fluid you">
        <div>
            <h3>帐号信息────────────────────────────────────</h3>
            <h4>ID:${sessionScope.bloguserid}</h4>
            <hr>
            <h4>昵称：${sessionScope.per.username}</h4>
            <hr>
            <h4>注册时间：${sessionScope.per.register}</h4>
            <hr>
        </div>
        <div>
            <h3>个人信息────────────────────────────────────</h3>
            <h4>姓名：${sessionScope.per.uname}<c:if test="${sessionScope.per.uname==null}">未填写</c:if></h4>
            <hr>
            <h4>性别:${sessionScope.per.sex}</h4>
            <hr>
            <h4>生日:${sessionScope.per.birthday}<c:if test="${sessionScope.per.birthday==null}">未填写</c:if></h4>
            <hr>
            <h4>学校：${sessionScope.per.school}<c:if test="${sessionScope.per.school==null}">未填写</c:if></h4>
            <hr>
            <h4>联系方式：${sessionScope.per.tel}<c:if test="${sessionScope.per.tel==null}">未填写</c:if></h4>
            <hr>
            <h4>简介：${sessionScope.per.introduce}<c:if test="${sessionScope.per.introduce==null}">未填写</c:if></h4>
        </div>
    </div>
</div>
</body>
</html>

