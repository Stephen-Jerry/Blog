<%@ page import="dao.gooddao" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/13 0013
  Time: 下午 6:09
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
    <title>博客</title>

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
        #room img{
            width:600px;
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
        .ren{
            background-color: white;
            width:350px;
            height:360px;
            border:5px solid #EEEEEE;
            margin-left: 40px;
        }
        .main{
            background-color: white;
            width:800px;

            border:5px solid #EEEEEE;
            margin-top:-360px;
            margin-right: 100px;
            float:right;
            min-height: 360px;
        }
        #tou{
            width:50px;
            height:50px;
            margin-left: 145px;
            margin-top:10px
        }
        #an1{
            width:95px;
            margin-left:50px;
        }
        #an2{
            margin-right: 50px;
            margin-top:-34px;
            float:right;
            width:70px
        }
        .tu{
            height:25px;
            width: 25px;
        }
        #foot{
            background-color: white;
            width:800px;
            border:5px solid #EEEEEE;
            min-height: 50px;
            float:right;
            margin-right: 100px;
            margin-top: 20px;
        }
    </style>
    <script>
        var num1,num2;
        window.onload=function(){
            $(".touxiang").click(function(){
                window.location.href="person.jsp"
            })
            var flag1=${sessionScope.isgood};
            num1=${sessionScope.good};
            if(${sessionScope.bloguserid}!=${sessionScope.userid}){
                document.getElementById("good").onclick=function(){
                    if(flag1==false){
                        document.getElementById("good").src="../img/9.png";
                        flag1=true;
                        $.post("/goodServlet",{blogid:${sessionScope.blogid},flag:0,userid:${sessionScope.userid},bloguserid:${sessionScope.bloguserid},good:${sessionScope.good}},function () {
                        })
                        num1++;
                        document.getElementById("dianzan").innerHTML="点赞："+num1;
                    }
                    else{
                        document.getElementById("good").src="../img/8.png"
                        flag1=false;

                        $.post("/goodServlet",{blogid:${sessionScope.blogid},flag:1,userid:${sessionScope.userid},bloguserid:${sessionScope.bloguserid}},function () {

                        })
                        num1--;
                        document.getElementById("dianzan").innerHTML="点赞："+num1;
                    }
                }
            }

            var flag2=${sessionScope.iscang};
            num2=${sessionScope.hide};
            if(${sessionScope.userid}!=${sessionScope.bloguserid}){
                document.getElementById("hide").onclick=function(){
                    if(flag2==false){
                        document.getElementById("hide").src="../img/11.png";
                        flag2=true;
                        $.post("/cangServlet",{blogid:${sessionScope.blogid},flag:1,userid:${sessionScope.userid},bloguserid:${sessionScope.bloguserid}},function () {

                        })
                        num2++;
                        document.getElementById("shoucang").innerHTML="收藏："+num2;
                    }else{
                        document.getElementById("hide").src="../img/10.png";
                        flag2=false;
                        $.post("/cangServlet",{blogid:${sessionScope.blogid},flag:0,userid:${sessionScope.userid},bloguserid:${sessionScope.bloguserid}},function () {

                        })
                        num2--;
                        document.getElementById("shoucang").innerHTML="收藏："+num2;
                    }

                }
            }
            if(${sessionScope.userid}!=${sessionScope.bloguserid}){
                var flag3=${sessionScope.isnotice};
                var num3=${sessionScope.blogUser.fan}
                    document.getElementById("notice").onclick=function(){
                        if(flag3==false){
                            document.getElementById("notice").innerHTML="已关注";
                            flag3=true;
                            $.post("/noticeServlet",{flag:1,userid:${sessionScope.userid},bloguserid:${sessionScope.bloguserid}},function () {

                            })
                            num3++;
                            document.getElementById("fan").innerHTML=num3;
                        }else{
                            document.getElementById("notice").innerHTML="关注";
                            flag3=false;
                            $.post("/noticeServlet",{flag:0,userid:${sessionScope.userid},bloguserid:${sessionScope.bloguserid}},function () {

                            })
                            num3--;
                            document.getElementById("fan").innerHTML=num3;
                        }
                    }
            }

        }
        function review(){
            $.post("/reviewServlet",{blogid:${sessionScope.blogid},userid:${sessionScope.userid},text:document.getElementById("text").value},function () {
                $("#total").load("/lookblogServlet?blogid=${sessionScope.blogid}&headline=${sessionScope.headline}&publicc=${sessionScope.publicc}&look=${sessionScope.look}&types=${sessionScope.types}&userid=${sessionScope.userid}&bloguserid=${sessionScope.bloguserid}&hide="+num2+"&good="+num1+"&state=${sessionScope.state}");
            })
        }
        function submit(reviewid,speakerid){
            $.post("/respondServlet",{userid:${sessionScope.userid},reviewid:reviewid,text:document.getElementById("answer").value,speakerid:speakerid},function () {
                $("#total").load("/lookblogServlet?blogid=${sessionScope.blogid}&headline=${sessionScope.headline}&publicc=${sessionScope.publicc}&look=${sessionScope.look}&types=${sessionScope.types}&userid=${sessionScope.userid}&bloguserid=${sessionScope.bloguserid}&hide="+num2+"&good="+num1+"&state=${sessionScope.state}");
            })
        }
        function respon(reviewid,speakerid) {
            var a=reviewid;
            var b=speakerid;
             document.getElementById("hfk"+reviewid).innerHTML="<input type='text' class='form-control' style='width: 350px' id='answer'><button class='btn btn-default navbar-btn' style='border-color: brown;margin-left: 360px;margin-top: -33px' onclick='submit("+a+","+b+")'>回复</button>"
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
            <a class="navbar-brand" href="/beginServlet?id=${sessionScope.userid}"><img src="../img/3.png" id="img"></a>
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
                <a href="writeblog.jsp" target="_blank"><button type="button" class="btn btn-default navbar-btn" id="button">创作中心</button></a>
                <c:if test="${sessionScope.islogin}"><li ><img src="${sessionScope.per.photo}" class="img-circle touxiang"></li></c:if>
                <c:if test="${!sessionScope.islogin}"><li><a href="login.jsp">登录/注册</a></li></c:if>
                <c:if test="${sessionScope.islogin}"><li><a href="/personServlet?id=${sessionScope.userid}">个人中心</a></li></c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid">
    <div class="ren">
        <div clas="row"><img src="${sessionScope.blogUser.photo}" class="img-circle" id="tou"></div>
        <div clas="row"><h3 align="center">${sessionScope.blogUser.username}</h3></div>
        <table cellspacing="0" align="center" cellpadding="0" width="100%" height="50%">
            <tr align="center">
                <td>访问量</td>
                <td>点赞</td>
                <td>粉丝</td>
            </tr>

            <tr align="center">
                <td>${sessionScope.blogUser.look}</td>
                <td>${sessionScope.blogUser.notice}</td>
                <td id="fan">${sessionScope.blogUser.fan}</td>
            </tr>
            <tr align="center">
                <td>原创</td>
            </tr>

            <tr align="center">
                <td>${sessionScope.blogUser.count}</td>
            </tr>
        </table>
        <c:if test="${sessionScope.userid!=sessionScope.bloguserid}">
            <div width="50%" id="an1"><button type="button" class="btn btn-default"><a target="_blank" href="/otherServlet?bloguserid=${sessionScope.bloguserid}&userid=${sessionScope.userid}">TA的主页</a></button></div>
            <c:if test="${sessionScope.isnotice==true}">
                <div width="50%" id="an2"><button type="button" class="btn btn-default" id="notice">已关注</button></div>
            </c:if>
            <c:if test="${sessionScope.isnotice!=true}">
                <div width="50%" id="an2"><button type="button" class="btn btn-default" id="notice">关注</button></div>
            </c:if>

        </c:if>

    </div>
    <div class="main">
        <h1>${sessionScope.headline}</h1>
        <div style="background-color: #c4e3f3">
            <div>
                <table cellspacing="0" cellpadding="0" width="60%">
                    <tr>
                        <td>${sessionScope.types}&emsp;&emsp;</td>
                        <td>${sessionScope.publicc}&emsp;&emsp;</td>
                        <td><img src="../img/7.png" class="tu">：${sessionScope.look}&emsp;&emsp;</td>
                        <c:if test="${sessionScope.userid!=sessionScope.bloguserid}">
                            <c:if test="${sessionScope.isgood==true}">
                                <td><img src="../img/9.png" style="height: 26px;width: 26px" id="good"></td>
                            </c:if>
                            <c:if test="${sessionScope.isgood!=true}">
                                <td><img src="../img/8.png" style="height: 26px;width: 26px" id="good"></td>
                            </c:if>

                        </c:if>
                        <td id="dianzan">点赞：${sessionScope.good}</td>
                        <c:if test="${sessionScope.userid!=sessionScope.bloguserid}">
                            <c:if test="${sessionScope.iscang==true}">
                                <td><img src="../img/11.png" style="height: 26px;width: 26px" id="hide"></td>
                            </c:if>
                            <c:if test="${sessionScope.iscang!=true}">
                                <td><img src="../img/10.png" style="height: 26px;width: 26px" id="hide"></td>
                            </c:if>
                        </c:if>
                        <td id="shoucang">收藏：${sessionScope.hide}</td>
                    </tr>
                </table>
            </div>
            <div><h5>专栏分类：
                <c:forEach items="${sessionScope.sort}" var="sort">
                    <c:if test="${sort!='默认'}">
                        ${sort}&emsp;
                    </c:if>
                </c:forEach>
            </h5></div>
            <div><h5>文章标签:
                <c:forEach items="${sessionScope.flag}" var="flag">
                    ${flag}&emsp;&emsp;
                </c:forEach>
            </h5></div>
        </div>
        <div id="room">
        ${sessionScope.text}
        </div>
    </div>
    <div id="foot">
        <div class="form-group">
            <input type="text" class="form-control" id="text" placeholder="优质评论可以帮助作者获得更高的权重" style="width:730px" maxlength="30">
        </div>
        <button type="button" class="btn btn-default" onclick="review()" style="margin-left: 735px;margin-top: -50px;background-color: brown;color: white">评论</button>
        <hr>
        <c:forEach items="${sessionScope.review}" var="review">
            <div>
            <h5><img src="${review.photo}" class="img-circle" style="height: 30px;width: 30px">  ${review.username}：${review.text}   <a style="text-decoration: none" onclick="respon('${review.reviewid}',${review.speakerid})">[回复]</a></h5>
                <c:forEach items="${review.answer}" var="answer">
                    <h5><img src="${answer.answerphoto}" class="img-circle" style="height: 30px;width: 30px">  ${answer.answername} 回复 <img src="${answer.speakphoto}" class="img-circle" style="height: 30px;width: 30px">  ${answer.speakname}：${answer.text}   <a style="text-decoration: none" onclick="respon('${review.reviewid}',${answer.answerid})">[回复]</a></h5>
                </c:forEach>
                <span id="hfk${review.reviewid}">
                </span>
            <hr>
            </div>

        </c:forEach>
    </div>
</div>
</body>
</html>