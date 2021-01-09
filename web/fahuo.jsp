<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>订单</title>

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

        <div style="margin:0 auto;margin-top:10px;width:950px;">
            <strong>订单详情</strong>
            <table class="table table-bordered">
                <tbody>
                <tr class="warning">
                    <th colspan="2">订单编号:${bean.oid } </th>
                    <th colspan="1">
                        <c:if test="${bean.state == 0 }">去付款</c:if>
                        <c:if test="${bean.state == 1 }">已付款</c:if>
                        <c:if test="${bean.state == 2 }">确认收货</c:if>
                        <c:if test="${bean.state == 3 }">已完成</c:if>
                    </th>
                    <th colspan="2">时间:<fmt:formatDate value="${bean.ordertime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </th>
                </tr>
                <tr class="warning">
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>
                <c:forEach items="${bean.items }" var="oi">
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
                                ${oi.count}
                        </td>
                        <td width="15%">
                            <span class="subtotal">￥${oi.subtotal}</span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div style="text-align:right;margin-right:120px;">
            商品金额: <strong style="color:#ff6600;">￥${bean.total }元</strong>
        </div>

    </div>

    <div style="padding-left: 830px ; padding-top: 20px">
            <a href="${pageContext.request.contextPath}/deliverServlet?oid=${bean.oid}" class="btn btn-primary btn-lg active" role="button">自己发货</a>
            <p href="#" class="btn btn-default btn-lg active" role="button">等待发货</p>

    </div>

</div>

<iframe src="bottom.jsp" width="100%" height="400" scrolling="no" frameborder="0"></iframe>
</body>
</html>
