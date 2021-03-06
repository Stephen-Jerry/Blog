<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>

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
        #zuo{
            background-color: white;
            width:200px;
            height:550px;
            margin-top: 30px;
            margin-left: 70px;
            border:5px solid #EEEEEE;
        }
        #you{
            background-color: white;
            width:750px;
            height:620px;
            margin-top: -550px;
            margin-left: 400px;
            border:5px solid #EEEEEE;
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
            <a class="navbar-brand" href="/mainc/begin.jsp"><img src="../img/3.png" id="img"></a>
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
    <div id="zuo">
        <ul class="nav nav-pills nav-stacked">
            <c:if test="${sessionScope.flag!='推荐'}">
                <li role="presentation">
            </c:if>
                <c:if test="${sessionScope.flag=='推荐'}">
                <li role="presentation" class="active">
                </c:if>

                <a href="/beginServlet?flag=推荐">推荐</a></li>
            <hr>
                <c:if test="${sessionScope.flag!='Python'}">
                <li role="presentation">
                </c:if>
                    <c:if test="${sessionScope.flag=='Python'}">
                <li role="presentation" class="active">
                    </c:if>
            <a href="/beginServlet?flag=Python">Python</a></li>
            <hr>
                <c:if test="${sessionScope.flag!='Java'}">
                <li role="presentation">
                </c:if>
                    <c:if test="${sessionScope.flag=='Java'}">
                <li role="presentation" class="active">
                    </c:if>
            <a href="/beginServlet?flag=Java">Java</a></li>
            <hr>
                <c:if test="${sessionScope.flag!='前端'}">
                <li role="presentation">
                </c:if>
                    <c:if test="${sessionScope.flag=='前端'}">
                <li role="presentation" class="active">
                    </c:if>
            <a href="/beginServlet?flag=前端">前端</a></li>
            <hr>
                <c:if test="${sessionScope.flag!='架构'}">
                <li role="presentation">
                </c:if>
                    <c:if test="${sessionScope.flag=='架构'}">
                <li role="presentation" class="active">
                    </c:if>
            <a href="/beginServlet?flag=架构">架构</a></li>
            <hr>
                <c:if test="${sessionScope.flag!='数据库'}">
                <li role="presentation">
                </c:if>
                    <c:if test="${sessionScope.flag=='数据库'}">
                <li role="presentation" class="active">
                    </c:if>
            <a href="/beginServlet?flag=数据库">数据库</a></li>
            <hr>
                <c:if test="${sessionScope.flag!='C语言'}">
                <li role="presentation">
                </c:if>
                    <c:if test="${sessionScope.flag=='C语言'}">
                <li role="presentation" class="active">
                    </c:if>
           <a href="/beginServlet?flag=C语言">C语言</a></li>
        </ul>
    </div>
    <div id="you">
        <br>
        <hr>
        <c:if test="${page.totalpage!=0}">
            <c:forEach items="${page.list}" var="user" varStatus="s">
                <div>
                    <a href="/lookblogServlet?blogid=${user.id}&headline=${user.head}&types=${user.types}&look=${user.look}&publicc=${user.publicc}&bloguserid=${user.userid}&userid=${sessionScope.id}&hide=${user.hide}&good=${user.good}&state=${user.state}"><h3 style="margin-top: 0px">${user.head}</h3></a>

                    <span>${user.types}</span>
                    <span style="margin-left: 20px">${user.publicc}</span>
                    <span style="margin-left: 20px">浏览量:${user.look}</span>
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
                        <a href="${pageContext.request.contextPath}/beginServlet?nowpage=${page.nowpage-1}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}" aria-label="Previous">
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
                                <li class="active"><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${i}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${i}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <!--前半部分有多余页-->
                    <c:if test="${page.nowpage-2>1}">
                        <c:if test="${1==page.nowpage}">
                            <li class="active"><a href="${pageContext.request.contextPath}/beiginServlet?nowpage=1&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">1</a></li>
                        </c:if>
                        <c:if test="${1!=page.nowpage}">
                            <li><a href="${pageContext.request.contextPath}/beginServlet?nowpage=1&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">1</a></li>
                        </c:if>
                        <li><a>...</a></li>
                        <c:forEach begin="${page.nowpage-2}" end="${page.nowpage}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${i}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${i}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <!--后半部分-->
                    <c:if test="${page.nowpage+2<page.totalpage}">
                        <c:forEach begin="${page.nowpage+1}" end="${page.nowpage+2}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${i}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${i}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <li><a>...</a></li>
                        <c:if test="${page.totalpage==page.nowpage}">
                            <li class="active"><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${page.totalpage}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${page.totalpage}</a></li>
                        </c:if>
                        <c:if test="${page.totalpage!=page.nowpage}">
                            <li><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${page.totalpage}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${page.totalpage}</a></li>
                        </c:if>
                    </c:if>
                    <c:if test="${page.nowpage+2>=page.totalpage}">
                        <c:forEach begin="${page.nowpage+1}" end="${page.totalpage}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${i}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/beginServlet?nowpage=${i}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>

                    <c:if test="${page.nowpage == page.totalpage}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${page.nowpage!= page.totalpage}">
                    <li>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/beginServlet?nowpage=${page.nowpage + 1}&count=5&id=${sessionScope.userid}&flag=${sessionScope.flag}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>

        </c:if>
        <c:if test="${page.totalpage==0}">
            还未发布博客
        </c:if>
    </div>

</div>
</body>
</html>
