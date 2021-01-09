<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>我的订单</title>

    <!--引入图标-->
    <link rel="shortcut icon" href="favicon.ico"/>
    <!--引入初始化样式文件-->
    <link rel="stylesheet" href="css/拼夕夕css初始化.css">
    <!--引入注册页面css-->
    <link rel="stylesheet" href="css/login.css">
    <!--引入公共的样式文件-->
    <link rel="stylesheet" href="css/commons.css">
    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>
<body>
<%@include file="top.jsp" %>
<div class="container">
    <div class="row">

        <div style="margin:0 auto; margin-top:10px;width:950px;">
            <strong>我的订单</strong>
            <table class="table table-bordered">
                <c:forEach items="${pb.data }" var="o">
                    <tbody>
                    <tr class="success">
                        <th colspan="2">订单编号:${o.oid } </th>
                        <th colspan="1">
                            <c:if test="${o.state == 0 }"><a href="${pageContext.request.contextPath }/getByIdServlet?method=doPost&oid=${o.oid}">去付款</a></c:if>
                            <c:if test="${o.state == 1 }"><a href="${pageContext.request.contextPath }/payMoneyServlet?method=doPost&oid=${o.oid}">已付款</a></c:if>
                            <c:if test="${o.state == 2 }"><a href="${pageContext.request.contextPath }/confirmServlet?method=doPost&oid=${o.oid}">确认收货</a></c:if>
                            <c:if test="${o.state == 3 }">已完成</c:if>
                        </th>
                        <th colspan="2">总金额:${o.total }元 </th>
                    </tr>
                    <tr class="warning">
                        <th>图片</th>
                        <th>商品</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                    </tr>
                    <c:forEach items="${o.items }" var="oi">
                        <tr class="active">
                            <td width="60" width="40%">
                                <input type="hidden" name="id" value="22">
                                <img src="goods/${oi.product.pimages}" width="70" height="60">
                            </td>
                            <td width="30%">
                                <a target="_blank">${oi.product.pname}</a>
                            </td>
                            <td width="20%">
                                ￥${oi.product.good_price}
                            </td>
                            <td width="10%">
                                    ${oi.count }
                            </td>
                            <td width="15%">
                                <span class="subtotal">￥${oi.subtotal }</span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </c:forEach>

            </table>
        </div>
    </div>
    <%@include file="page.jsp" %>
</div>

<iframe src="bottom.jsp" width="100%" height="400" scrolling="no" frameborder="0"></iframe>
</body>
</html>
