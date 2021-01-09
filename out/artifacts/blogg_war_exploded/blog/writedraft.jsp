<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/22 0022
  Time: 下午 10:10
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
    <title>创作中心</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/editor.md-master/css/editormd.css" />

    <script src="${pageContext.request.contextPath}/editor.md-master/examples/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/editor.md-master/editormd.js"></script>
    <style>
        body{
            background:url("../img/1.jpg") no-repeat ;
            background-size: cover;

        }
        #head{
            background-color: white;
            width:100%;
            height:40px;
            margin-bottom: 20px;
        }
        #button1{
            color: brown;
            border-color: brown;

        }
        #button2{
            color: white;

            background-color: brown;
        }
        .wenzhang{
            margin-left: 200px;
            width:120px;
        }
    </style>
    <script>
        window.onload=function(){
            document.getElementById("writeblog").onsubmit=function(){
                if(document.getElementById("test-editormd-markdown").value!=""){
                    if(document.getElementById("choice").selectedIndex!=0){
                        return true;
                    }else{
                        alert("文章类型不能为空！");
                        return false;
                    }
                }else{
                    alert("文章内容不能为空！")
                    return false;
                }

            }
            $(".touxiang").click(function(){
                window.location.href="person.jsp"
            })
            var biao=/^[\u4e00-\u9fa5_a-zA-Z0-9_]{1,4}$/;
            var num=0;
            document.getElementById("add").onclick=function(){
                if(biao.test(document.getElementById("log").value)){
                    num++;
                    if(num<6){
                        var log=document.getElementById("log").value;
                        var legg = document.createElement("input");
                        var wen=document.createElement("div");
                        var cancel=document.createElement("button");
                        cancel.innerHTML="✘";
                        cancel.setAttribute("id","cancel");
                        cancel.onclick=function(){
                            document.getElementById("wenzhang").removeChild(wen);
                            num--;
                        }
                        wen.setAttribute("class","wenzhang");
                        legg.setAttribute("style","width:80px;background-color: #c4e3f3");
                        legg.setAttribute("name","log");
                        legg.value=log;
                        wen.appendChild(legg);
                        wen.appendChild(cancel);
                        document.getElementById("wenzhang").appendChild(wen);
                        document.getElementById("log").value=null;
                    }else{
                        alert("最多只能添加五个标签")
                    }
                }else{
                    alert("标签格式不合法或标签为空标签")
                }
            }
            var num2=0;
            document.getElementById("add2").onclick=function(){
                if(biao.test(document.getElementById("sort").value)){
                    num2++;
                    if(num2<4){
                        var sort=document.getElementById("sort").value;
                        var sortt = document.createElement("input");
                        var wen=document.createElement("div");
                        var cancel=document.createElement("button");
                        cancel.innerHTML="✘";
                        cancel.setAttribute("id","cancel");
                        cancel.onclick=function(){
                            document.getElementById("fenlan").removeChild(wen);
                            num2--;
                        }
                        wen.setAttribute("class","wenzhang");
                        sortt.setAttribute("style","width:80px;background-color: #c4e3f3");
                        sortt.setAttribute("name","sort");
                        sortt.value=sort;
                        wen.appendChild(sortt);
                        wen.appendChild(cancel);
                        document.getElementById("fenlan").appendChild(wen);
                        document.getElementById("sort").value=null;
                    }else{
                        alert("最多只能添加三个分栏")
                    }
                }else{
                    alert("分栏格式不合法或标签为空分栏")
                }
            }
        }
        function save(){
            document.getElementById("writeblog").action="/savedraftagainServlet?id=${sessionScope.id}";
            document.getElementById("writeblog").submit();
        }
    </script>
</head>
<body>

<form method="post" action="/drafttowriteServlet?id=${sessionScope.id}" id="writeblog">
    <div id="head">
        <input type="text" class="form-control" value="${sessionScope.head}" style="width: 1050px;margin-left: 67px" name="headline" maxlength="29">
        <button type="button" class="btn btn-default" id="button1" style="margin-left:1120px;margin-top: -52px" onclick="save()">保存草稿</button>
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" id="button2"style="margin-top: -52px">发布文章</button>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">发布文章</h4>
                    </div>
                    <div class="modal-body">
                        <div id="wenzhang">文章标签：<!-- Small modal -->
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target=".bs-example-modal-sm" id="add">+添加文章标签</button>
                            <input type="text" id="log">
                        </div>
                        <hr>
                        <div id="fenlan">分类专栏：<!-- Small modal -->
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target=".bs-example-modal-sm" id="add2">+添加分类专栏</button>
                            <input type="text" id="sort">
                        </div>
                        <hr>
                        <div>文章类型：<!-- Small modal -->
                            <select name="type" id="choice">
                                <option selected value="请选择">请选择</option>
                                <option value="原创">原创</option>
                                <option value="转载">转载</option>
                                <option value="翻译">翻译</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-default" style="color: white;background-color: brown">发布文章</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="test-editormd" >
        <!--111111-->
        <textarea id="test-editormd-markdown" name="test-editormd-markdown"  style="display:none;">${sessionScope.text}</textarea>
        <!-- 注意：name属性的值-->
        <textarea id="test-editormd-htmlCode" name="test-editormd-htmlCode" style="display:none;"></textarea>
        <!-- 注意：name属性的值-->
    </div>

</form>

<script type="text/javascript">
    $(function() {
        editormd("test-editormd", {//注意1：这里的就是上面的DIV的id属性值
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            path    : "/editor.md-master/lib/",//注意2：你的路径
            saveHTMLToTextarea : true,//注意3：这个配置，方便post提交表单
            editorTheme: "pastel-on-dark",
            theme: "gray",
            previewTheme: "dark"
        });
    });
</script>
</body>
</html>

