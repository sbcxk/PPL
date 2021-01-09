<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>购物车</title>

    <!--引入图标-->
    <link rel="shortcut icon" href="favicon.ico"/>
    <!--引入初始化样式文件-->
    <link rel="stylesheet" href="css/拼夕夕css初始化.css">
    <!--引入注册页面css-->
    <link rel="stylesheet" href="css/login.css">
    <!--引入公共的样式文件-->
    <link rel="stylesheet" href="css/commons.css">
    <!-- 引入自定义css文件 style.css -->

    <style>
        body {
            margin-top: 200px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        .container .row div {
            /* position:relative;
 float:left; */
        }

        font {
            color: #3164af;
            font-size: 18px;
            font-weight: normal;
            padding: 0 10px;
        }
    </style>
    <script type="text/javascript">
        function removeFromCart(pid){
            if(confirm("您忍心抛弃我吗?")){
                location.href="${pageContext.request.contextPath}/cartDeleteServlet?method=doPost&pid="+pid;
            }
        }
    </script>
</head>

<body>


<%@include file="top.jsp" %>

<div class="container">
    <div class="row">
        <c:if test="${empty cart || empty cart.cartItems }">
            <h3>芜湖！购物车的肚子空空如也，赶紧来填饱我吧@_@</h3>
        </c:if>
        <c:if test="${not empty cart.cartItems}">
        <div style="margin:0 auto; margin-top:10px;width:950px;">
            <strong style="font-size:16px;margin:5px 0;">购物车详情</strong>
            <table class="table table-bordered">
                <tbody>
                <tr class="warning">
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${cart.cartItems }" var="ci">
                    <tr class="active">
                        <td width="60" width="40%">
                            <input type="hidden" name="id" value="22">
                            <img src="goods/${ci.product.pimages}" width="70" height="60">
                        </td>
                        <td width="30%">
                            <a target="_blank">${ci.product.pname}</a>
                        </td>
                        <td width="20%">
                            ￥${ci.product.good_price}
                        </td>
                        <td width="10%">
                            <input type="text" readonly="readonly" name="quantity" value="${ci.count }" maxlength="4" size="10">
                        </td>
                        <td width="15%">
                            <span class="subtotal">￥${ci.subtotal }</span>
                        </td>
                        <td>
                            <a href="javascript:void(0);" onclick="removeFromCart('${ci.product.pid}')" class="delete">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div style="margin-right:130px;">
        <div style="text-align:right;">
            商品金额: <strong style="color:#ff6600;">￥${cart.total }元</strong>
        </div>
        <div style="text-align:right;margin-top:10px;margin-bottom:10px;">
            <a href="${pageContext.request.contextPath }/cartDelAllServlet?method=doPost" id="clear" class="clear">清空购物车</a>
            <a href="${pageContext.request.contextPath }/orderServlet">
                <input type="button" width="100" value="提交订单" name="submit" border="0" style="background: url('images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
                        height:35px;width:100px;color:white;">
            </a>
        </div>
    </div>
    </c:if>
</div>

<iframe src="bottom.jsp" width="100%" height="400" scrolling="no" frameborder="0"></iframe>

</body>
</html>