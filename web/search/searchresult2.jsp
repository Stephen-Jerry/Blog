<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/29 0029
  Time: 下午 8:20
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
    <title>搜索结果</title>

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

        #zuo{
            background-color: white;
            width:750px;
            height:50px;
            margin-left: 300px;
            margin-top: 20px;
            border:5px solid #EEEEEE;
        }
        #you{
            background-color: white;
            width:750px;
            height:620px;
            margin-left: 300px;
            border:5px solid #EEEEEE;
        }
    </style>
    <script>
        window.onload=function(){
            $(".touxiang").click(function(){
                window.location.href="person.jsp"
            })
            $("ul.pagination li.disabled a").click(function () {
                return false;
            });
        }

    </script>
</head>
<body id="total">

<div>
    <div id="zuo">
        <ul class="nav nav-pills">
            <li role="presentation" style="width: 184px"><a href="/searchServlet?search=${sessionScope.search}">按关键字</a></li>
            <li role="presentation" class="active" style="width: 184px"><a href="/searchServlet2?search=${sessionScope.search}">按标签</a></li>
            <li role="presentation" style="width: 184px"><a href="/searchServlet3?search=${sessionScope.search}">分类专栏</a></li>
            <li role="presentation" style="width:182px"><a href="/searchresult4?search=${sessionScope.search}">博主</a></li>
        </ul>
    </div>
    <div id="you">
        <hr>
        <c:if test="${page.totalpage!=0}">
            <c:forEach items="${page.list}" var="user" varStatus="s">
                <div>
                    <a href="/lookblogServlet?blogid=${user.id}&headline=${user.head}&types=${user.types}&look=${user.look}&publicc=${user.publicc}&bloguserid=${user.userid}&userid=${id}&hide=${user.hide}&good=${user.good}&state=${user.state}"><h3 style="margin-top: 0px">${user.head}</h3></a>
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
                        <a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${page.nowpage-1}&count=5&search=${sessionScope.search}" aria-label="Previous">
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
                                <li class="active"><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${i}&count=5&search=${sessionScope.search}">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${i}&count=5&search=${sessionScope.search}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <!--前半部分有多余页-->
                    <c:if test="${page.nowpage-2>1}">
                        <c:if test="${1==page.nowpage}">
                            <li class="active"><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=1&count=5&search=${sessionScope.search}">1</a></li>
                        </c:if>
                        <c:if test="${1!=page.nowpage}">
                            <li><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=1&count=5&search=${sessionScope.search}">1</a></li>
                        </c:if>
                        <li><a>...</a></li>
                        <c:forEach begin="${page.nowpage-2}" end="${page.nowpage}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${i}&count=5&search=${sessionScope.search}">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${i}&count=5&search=${sessionScope.search}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <!--后半部分-->
                    <c:if test="${page.nowpage+2<page.totalpage}">
                        <c:forEach begin="${page.nowpage+1}" end="${page.nowpage+2}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${i}&count=5&search=${sessionScope.search}">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${i}&count=5&search=${sessionScope.search}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        <li><a>...</a></li>
                        <c:if test="${page.totalpage==page.nowpage}">
                            <li class="active"><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${page.totalpage}&count=5&search=${sessionScope.search}">${page.totalpage}</a></li>
                        </c:if>
                        <c:if test="${page.totalpage!=page.nowpage}">
                            <li><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${page.totalpage}&count=5&search=${sessionScope.search}">${page.totalpage}</a></li>
                        </c:if>
                    </c:if>
                    <c:if test="${page.nowpage+2>=page.totalpage}">
                        <c:forEach begin="${page.nowpage+1}" end="${page.totalpage}" var="i">
                            <c:if test="${page.nowpage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${i}&count=5&search=${sessionScope.search}">${i}</a></li>
                            </c:if>
                            <c:if test="${page.nowpage!=i}">
                                <li><a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${i}&count=5&search=${sessionScope.search}">${i}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if>

                    <c:if test="${page.nowpage == page.totalpage}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${page.nowpage!= page.totalpage}">
                    <li>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/searchServlet2?nowpage=${page.nowpage + 1}&count=5&search=${sessionScope.search}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>

        </c:if>
        <c:if test="${page.totalpage==0}">
            未搜索到结果！
        </c:if>

    </div>

</div>
</body>
</html>
