<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/30 0030
  Time: 上午 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>找回密码</title>

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
            session.removeAttribute("wrong");
        }
    %>
    <style>
        body{
            background:url("../img/1.jpg") no-repeat ;
            background-size: cover;
        }
        .back{
            background-color: white;
            width:450px;
            height:520px;
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
            margin-top: 50px;
        }
        #username{
            width:300px;
        }
        #password1,#password2,#email{
            width:300px;
        }
        #regist{
            margin-left: 100px;
            color:white;
            background-color: brown;
        }
        #check{
            width:110px;
        }
        #checkpicture{
            float:left;
            margin-top: -8px;
        }
        #yanzhengma{

            width:135px;
        }
        #checkCode{
            height:40px;
            width:100px;
        }
        .uuu{

            width:330px;
        }

    </style>
    <script>

        window.onload = function(){

            document.getElementById("username").onblur=checkUsername;
            document.getElementById("zhuce").onsubmit=function () {
                return checkUsername();
            }
        }
        function checkUsername(){
            var username=/^[\u4e00-\u9fa5_a-zA-Z0-9_]{1,10}$/;
            var flag= username.test(document.getElementById("username").value);
            if(flag){
                document.getElementById("un").innerHTML="<img length='25' width='25' src='../img/4.png'/>";
            }else{
                document.getElementById("un").innerHTML="✘";
            }
            return flag;
        }
        var code;
        function get() {
            if(document.getElementById("email").value==null){
                alert("邮箱不能为空！")
            }else{
                $.post("/findpasswordServlet",{emailaddress:document.getElementById("email").value},function (result) {
                    document.getElementById("zhuce").setAttribute("action","/findServlet?code="+result)
                })
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
            <form class="navbar-form navbar-left" href="#">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入你想搜索的内容关键字" style="width:600px">
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
    <h2 align="center">找回密码</h2>
    <form class="form-horizontal" method="post" action="/findServlet" id="zhuce">
        <div class="form-group username" >
            <label for="username" class="col-sm-2 control-label">帐号</label>
            <div class="col-sm-10 uuu">
                <input type="text" class="form-control" id="username" name="username" placeholder="请输入帐号">
            </div>
            <span id="un"></span>

        </div>

        <div class="form-group email" >
            <label for="email" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-10 uuu">
                <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱">
            </div>
        </div>
        <div class="form-group" >
            <label for="check" class="col-sm-2 control-label">验证码</label>
            <div class="col-sm-10" id="yanzhengma">
                <input type="text" class="form-control" id="check" name="check" placeholder="请输入验证码">
            </div>
            <div id="checkpicture"><button class="btn btn-default navbar-btn" id="getcheck" onclick="get()" type="button">获取验证码</button></div>

        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" id="regist">提交</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>

