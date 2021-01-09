<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/8 0008
  Time: 上午 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="../js/bootstrap.min.js"></script>
    <%
        String error=(String)request.getSession().getAttribute("wrong");
        System.out.println(error);
        if (null != error) {
    %>
    <script type="text/javascript" language="JavaScript">
        alert("<%=error%>");
    </script>
    <%

        }
    %>
    <style>
        body{
            background:url("../img/1.jpg") no-repeat ;
            background-size: cover;
        }
        .back{
            background-color: white;
            width:425px;
            height:365px;
            border:5px solid #EEEEEE;
            margin:auto;
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
            align:center;
            margin-top: 5px;
        }
        .username{

           margin-top: 75px;
        }
        #username{
            width:300px;
        }
        #password{
            width:300px;
        }
        #login{
           margin-left: 100px;
            color:white;
            background-color: brown;
        }
        #regist{
            width:170px;
            margin-left: 260px;
            margin-top: -20px;
        }
        #sp{
            width:250px;
            margin-left: 80px;
        }
        
    </style>
    <script>
        window.onload=function(){
            document.getElementById("denglu").onsubmit=function(){
                return checkusername()&&checkPassword();
            }
            document.getElementById("username").onblur=checkusername;
            function checkusername(){
                var username=/^\d{1,}$/;
                var flag=username.test(document.getElementById("username").value);
                if(!flag){
                    document.getElementById("sp").innerHTML="请检查输入的帐号是否是纯数字";
                }else{
                    document.getElementById("sp").innerHTML="";
                }
                return flag;
            }
            function checkPassword(){
                var password=/^\w{1,}$/;
                var flag=password.test(document.getElementById("password").value);
                return flag;
            }
        }
    </script>

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/beginServlet"><img src="../img/3.png" id="img"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">博客</a></li>

            </ul>
            <form class="navbar-form navbar-left" method="post" action="/searchServlet" target="_blank">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入你想搜索的内容关键字" style="width: 600px" name="search">
                </div>
                <button type="submit" class="btn btn-default" id="submit">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <a href="#"><button type="button" class="btn btn-default navbar-btn" id="button">创作中心</button></a>
                <li><a href="login.jsp">登录/注册</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid back">
    <h2 align="center">登录博客</h2>
    <form class="form-horizontal" method="post" action="/loginServlet" id="denglu">
        <div class="form-group username" >
            <label for="username" class="col-sm-2 control-label">帐号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username"  name="username" placeholder="请输入帐号,必须是纯数字">
            </div>
            <div id="sp"></div>
        </div>
        <div class="form-group password">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" id="login">登录</button>
            </div>
        </div>
    </form>
    <div style="width:80px;margin-top: 80px;margin-left: 120px"><a href="findpassword.jsp">找回密码</a></div>
    <div style="width: 80px;margin-left: -15px;margin-top: -20px"><a href="modifypassword.jsp">修改密码</a></div>
    <div id="regist">还没有帐号？<a href="regist.jsp">点击注册</a></div>
</div>


</body>
</html>
