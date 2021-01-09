<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/12 0012
  Time: 上午 8:29
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
    <title>个人中心</title>

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
        #myhead{
            width: 150px;
            height: 150px;
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
            height:550px;
            width:15%;
            margin-left:20px;
            margin-top: 10px;
        }
        .you{
            border:3px solid;
            background-color: white;
            height:720px;
            width:60%;
            margin-top: -550px;
            margin-left: 350px;
        }
    </style>
    <script>
        window.onload=function(){
            $(".touxiang").click(function(){
                window.location.href="person.jsp"
            })
            $("#myphoto").change(function () {
                var file=this.files[0];
                if(file.type.indexOf("image")==0){
                    var reader=new FileReader();
                    reader.readAsDataURL(file);
                    reader.onload=function () {
                        var newURL=this.result;
                        $("#myhead").prop("src",newURL);
                    }
                }
            })
        }
        function modifyusername(username){
            document.getElementById("username").innerHTML="昵称：<input id=input>";
            document.getElementById("input").value=username;
            document.getElementById("input").onblur=function(){
                $.post({
                        url : "/checkusernameServlet",
                        data : {
                            username : document.getElementById("input").value,
                            lastname : username,
                            userid:${sessionScope.id}
                        },
                        success : function (result) {
                            if(result=="0"){
                                alert("昵称已存在！")
                            }else{
                                $("#total").load("/personServlet?id=${id}");
                            }
                        }
                    }
                )
            }
        }
        function modifyinformation(uname,birthday,school,tel,introduce){
            document.getElementById("anniu").innerHTML="<button type='button' style='margin-left: 670px;margin-top: -35px' class='btn btn-default navbar-btn' id='save'>保存修改</button>"
            document.getElementById("uname").innerHTML="姓名：<input id=input1>";
            if(uname!=null){
                document.getElementById("input1").value=uname;
            }
            document.getElementById("birthday").innerHTML="生日：<input id=input2 type='date'>";
            if(birthday!=null){
                document.getElementById("input2").value=birthday;
            }
            document.getElementById("school").innerHTML="学校：<input id=input3>";
            if(school!=null){
                document.getElementById("input3").value=school;
            }
            document.getElementById("tel").innerHTML="联系方式：<input id=input4>";
            if(tel!=null){
                document.getElementById("input4").value=tel;
            }
            document.getElementById("introduce").innerHTML="简介：<input id=input5 style='width: 500px;height: 80px'>";
            if(introduce!=null){
                document.getElementById("input5").value=introduce;
            }
            document.getElementById("save").onclick=function(){
                $.post({
                    url : "/modifyinformationServlet",
                    data : {
                        uname : document.getElementById("input1").value,
                        birthday : document.getElementById("input2").value,
                        school : document.getElementById("input3").value,
                        tel : document.getElementById("input4").value,
                        introduce : document.getElementById("input5").value,
                        userid : ${sessionScope.id}
                    },
                    success : function () {
                            $("#total").load("/personServlet?id=${id}");
                    }
                    }
                )
            }
        }
        function imgonclick() {
            document.getElementById("myphoto").click();
        }
    </script>
</head>
<body id="total">
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
            <a class="navbar-brand" href="/beginServlet?id=${sessionScope.id}"><img src="../img/3.png" id="img"></a>
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
                <a href="../blog/writeblog.jsp" target="_blank"><button type="button" class="btn btn-default navbar-btn" id="button">创作中心</button></a>
                <c:if test="${sessionScope.islogin}"><li><img src="${sessionScope.per.photo}" class="img-circle touxiang"></li></c:if>
                <c:if test="${!sessionScope.islogin}"><li><a href="login.jsp">登录/注册</a></li></c:if>
                <c:if test="${sessionScope.islogin}"><li><a href="/personServlet?id=${id}">个人中心</a></li></c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->

</nav>
<div class="container-fluid head">
    <div><a data-toggle="modal" data-target="#myModal"><img src="${sessionScope.per.photo}" class="img-circle touxiang2"><h1 style="color:white">username:${sessionScope.per.username}</h1></a></div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">上传头像</h4>
                </div>
                <div class="modal-body">
                    <form method="post" enctype="multipart/form-data" action="/userheadServlet?id=${sessionScope.id}">
                        <img src="${sessionScope.per.photo}" class="img-circle" style="margin-left: 35%" id="myhead" onclick="imgonclick()">
                        <input type="file" name="filehead" id="myphoto" style="display: none" >
                        <button type="submit" style="margin-top: 20px;margin-left: 45%;border-color: brown" class="btn btn-default navbar-btn">确认上传</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="container-fluid shenzi">
        <ul class="nav nav-pills  nav-stacked">
            <li role="presentation" class="active"><a href="/personServlet?id=${id}">个人资料</a></li>
            <hr>
            <li role="presentation"><a href="/pageServlet?id=${sessionScope.id}">我的博客</a></li>
            <hr>
            <li role="presentation"><a href="/pageServlet4?id=${sessionScope.id}">草稿箱</a></li>
            <hr>
            <li role="presentation"><a href="/pageServlet5?id=${sessionScope.id}">我的粉丝</a></li>
            <hr>
            <li role="presentation"><a href="/pageServlet6?id=${sessionScope.id}">我的关注</a></li>
            <hr>
            <li role="presentation"><a href="/pageServlet7?id=${sessionScope.id}">我的收藏</a></li>
            <hr>
            <li role="presentation"><a href="/sortpageServlet?id=${sessionScope.id}">我的专栏</a></li>
        </ul>
    </div>
    <div class="container-fluid you" style="min-height: 100px">
        <div>
            <h3>帐号信息─────────────────────────────────</h3>
            <button type="button" style="margin-left: 670px;margin-top: -35px" class="btn btn-default navbar-btn" onclick="modifyusername('${sessionScope.per.username}')">修改资料</button>
            <h4>ID:${sessionScope.id}</h4>
            <hr>
            <span id="username"><h4>昵称：${sessionScope.per.username}</h4></span>
            <hr>
            <h4>注册时间：${sessionScope.per.register}</h4>
            <hr>
        </div>
        <div>
            <h3>个人信息─────────────────────────────────</h3>
            <span id="anniu"><button type="button" style="margin-left: 670px;margin-top: -35px" class="btn btn-default navbar-btn" onclick="modifyinformation('${sessionScope.per.uname}','${sessionScope.per.birthday}','${sessionScope.per.school}','${sessionScope.per.tel}','${sessionScope.per.introduce}')">修改信息</button></span>
            <span id="uname"><h4>姓名：${sessionScope.per.uname}<c:if test="${sessionScope.per.uname==null}">未填写</c:if></h4></span>
            <hr>
            <h4>性别:${sessionScope.per.sex}</h4>
            <hr>
            <span id="birthday"><h4>生日:${sessionScope.per.birthday}<c:if test="${sessionScope.per.birthday==null}">未填写</c:if></h4></span>
            <hr>
            <span id="school"><h4>学校：${sessionScope.per.school}<c:if test="${sessionScope.per.school==null}">未填写</c:if></h4></span>
            <hr>
            <span id="tel"><h4>联系方式：${sessionScope.per.tel}<c:if test="${sessionScope.per.tel==null}">未填写</c:if></h4></span>
            <hr>
            <span id="introduce"><h4>简介：${sessionScope.per.introduce}<c:if test="${sessionScope.per.introduce==null}">未填写</c:if></h4></span>
        </div>
    </div>
</div>
</body>
</html>
