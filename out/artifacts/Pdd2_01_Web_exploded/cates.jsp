<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>拼夕夕-综合网购首选-正品低价、品质保障、配送及时、轻松购物!
    </title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <!--网站说明-->
    <meta name="description" content="拼多多作为新电商开创者，致力于将娱乐社交的元素融入电商运营中，
                    通过“社交+电商”的模式，让更多的用户带着乐趣分享实惠，享受全新的共享式购物体验。"/>
    <!--关键字-->
    <meta name="keywords" content="拼多多 拼多多商城 pinduoduo 拼 拼团 团购 团购app 购物 零食 划算 好货 捡漏"/>
    <!--引入图标-->
    <link rel="shortcut icon" href="favicon.ico"/>
    <!--引入初始化样式文件-->
    <link rel="stylesheet" href="css/拼夕夕css初始化.css">
    <!--引入公共的样式文件-->
    <link rel="stylesheet" href="css/commons.css">
    <!--引入index首页文件-->
    <link rel="stylesheet" href="css/index.css">
    <!--取消链接下划线-->
    <link rel="stylesheet" href="css/a_a.css">
</head>
<body>
<%@include file="/top.jsp" %>
<c:forEach items="${list}" var="newPro">

    <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
        <a href="${pageContext.request.contextPath}/productServlet?method=getById&gid=${newPro.pid}">
            <img src="goods/${newPro.pimages }" width="130" height="130" style="display: inline-block;">
        </a>
        <p><a href="${pageContext.request.contextPath}/productServlet?method=getById&gid=${newPro.pid}" style='color:#666'>${newPro.pname }</a></p>
        <p><font color="#E4393C" style="font-size:16px">&yen;${newPro.market_price }</font></p>
    </div>

</c:forEach>

<iframe src="bottom.jsp" width="100%" height="400" scrolling="no" frameborder="0"></iframe>
</body>
</html>
