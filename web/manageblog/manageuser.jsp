<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/29 0029
  Time: 下午 4:16
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
    <title>管理用户</title>

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
        #you{
            background-color: white;
            width:750px;
            height:620px;
            margin-left: 310px;
            border:5px solid #EEEEEE;
        }
        .touxiang3{
            width:60px;
            height:60px;
        }
    </style>
    <script>
        window.onload=function(){
            $(".touxiang").click(function(){
                window.location.href="person.jsp"
            })
        }
        function chu(userid) {
            $.post("/chuServlet",{userid:userid},function () {
                $("#total").load("/managepersonServlet");
            })
        }
        function remove(userid) {
            $.post("/removeuserServlet",{userid:userid},function () {
                $("#total").load("/managepersonServlet");
            })
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
            <a class="navbar-brand" href="/beginServlet?id=${id}"><img src="../img/3.png" id="img"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">博客</a></li>

            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入你想搜索的内容关键字" style="width: 600px">
                </div>
                <button type="submit" class="btn btn-default" id="submit">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <a href="../blog/writeblog.jsp" target="_blank"><button type="button" class="btn btn-default navbar-btn" id="button">创作中心</button></a>
                <c:if test="${sessionScope.per.ismanage==1}"><li><a href="/manageblogServlet">管理博客</a></li></c:if>
                <c:if test="${sessionScope.per.ismanage==1}"><li><a href="/managepersonServlet">管理用户</a></li></c:if>
                <c:if test="${sessionScope.islogin}"><li ><img src="${sessionScope.per.photo}" class="img-circle touxiang"></li></c:if>
                <c:if test="${!sessionScope.islogin}"><li><a href="login.jsp">登录/注册</a></li></c:if>
                <c:if test="${sessionScope.islogin}"><li><a href="/personServlet?id=${id}">个人中心</a></li></c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div>
    <div id="you" style="min-height: 100px">
        <hr>
        <c:if test="${page.totalpage!=0}">
            <c:forEach items="${page.list}" var="user" varStatus="s">
                <br>
                <div>
                    <img src="${user.photo}" class="img-circle touxiang3">
                    <a target="_blank" href="/otherServlet?bloguserid=${user.id}&userid=${id}"><h4 style="margin-left: 80px;margin-top: -40px">${user.username}</h4></a>
                    <button type="button" style="margin-left: 540px;margin-top: -40px;border-color: brown;" id="chu${user.id}" onclick="chu(${user.id})" class="btn btn-default navbar-btn">初始化密码</button>
                    <button type="button" style="border-color: brown;margin-top: -40px" id="remove${user.id}" onclick="remove(${user.id})" class="btn btn-default navbar-btn">注销用户</button>
                </div>
                <hr>
            </c:forEach>
            <nav aria-label="Page navigation" style="text-align: center">
                <ul class="pagination">
                    <c:if test="${page.nowpage == 1}">
                    <li class="disabled">
                        </c:if>

                        <c:if test="${page.nowpage!= 1}">
                    <li>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${page.nowpage-1}&count=5" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>


                        <%--            <c:forEach begin="1" end="${page.totalpage}" var="i" >--%>
                        <%--                    <c:if test="${page.nowpage == i}">--%>
                        <%--                        <li class="active"><a href="${pageContext.request.contextPath}/pageServlet?nowpage=${i}&count=5">${i}</a></li>--%>
                        <%--                    </c:if>--%>
                        <%--                    <c:if test="${page.nowpage != i}">--%>
                        <%--                        <li><a href="${pageContext.request.contextPath}/pageServlet?nowpage=${i}&count=5">${i}</a></li>--%>
                        <%--                    </c:if>--%>
                        <%--                </c:forEach>--%>
                    <!-- 前半部分-->
                    <!--前半部分无多余页-->
                    <c:if test="${page.nowpage-2<=1}">
                        <c:forEach begin="1" end="${page.nowpage}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${i}&count=5">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${i}&count=5">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <!--前半部分有多余页-->
                    <c:if test="${page.nowpage-2>1}">
                        <c:if test="${1==page.nowpage}">
                            <li class="active"><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=1&count=5">1</a></li>
                        </c:if>
                        <c:if test="${1!=page.nowpage}">
                            <li><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=1&count=5">1</a></li>
                        </c:if>
                        <li><a>...</a></li>
                        <c:forEach begin="${page.nowpage-2}" end="${page.nowpage}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${i}&count=5">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${i}&count=5">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <!--后半部分-->
                    <c:if test="${page.nowpage+2<page.totalpage}">
                        <c:forEach begin="${page.nowpage+1}" end="${page.nowpage+2}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${i}&count=5">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${i}&count=5">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <li><a>...</a></li>
                        <c:if test="${page.totalpage==page.nowpage}">
                            <li class="active"><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${page.totalpage}&count=5">${page.totalpage}</a></li>
                        </c:if>
                        <c:if test="${page.totalpage!=page.nowpage}">
                            <li><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${page.totalpage}&count=5">${page.totalpage}</a></li>
                        </c:if>
                    </c:if>
                    <c:if test="${page.nowpage+2>=page.totalpage}">
                        <c:forEach begin="${page.nowpage+1}" end="${page.totalpage}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${i}&count=5">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${i}&count=5">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>

                    <c:if test="${page.nowpage == page.totalpage}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${page.nowpage!= page.totalpage}">
                    <li>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/managepersonServlet?nowpage=${page.nowpage + 1}&count=5" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>

        </c:if>
        <c:if test="${page.totalpage==0}">
            暂无用户！
        </c:if>

    </div>

</div>
</body>
</html>
