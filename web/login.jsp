<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>个人登录</title>

    <!--引入图标-->
    <link rel="shortcut icon" href="favicon.ico"/>
    <!--引入初始化样式文件-->
    <link rel="stylesheet" href="css/拼夕夕css初始化.css">
    <!--引入注册页面css-->
    <link rel="stylesheet" href="css/login.css">
    <!--引入公共的样式文件-->
    <link rel="stylesheet" href="css/commons.css">

    <script type="text/javascript">
        //切换验证码
        function refreshCode(){
            var vcode = document.getElementById("vcode");
            vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }

    </script>
</head>
<body>
<div class="header">
    <div class="logo fl">
        <h1>
            <a href="index.jsp" title="拼夕夕">拼夕夕</a>
        </h1>
    </div>
</div>

<div class="login-main">
    <div class="w">
        <div class="loginfrom">
            <div class="a-from">
                <a href="#" class="from1 fl">扫描登陆</a>
                <span class="spa">|</span>
                <a href="#" class="from2 fr">账户登陆</a>
            </div>
            <div class="anno">公共场所不建议自动登录，以免账号丢失</div>
            <form action="${pageContext.request.contextPath}/loginServlet" method="post">
                <div class="logininput">
                    <input type="text" name="username" id="user" class="user" placeholder="邮箱/用户名/手机号">
                    <i class="useri"></i>
                    <input type="password" name="password" id="password" class="password" placeholder="请输入密码">
                    <i class="passwordi"></i>
                </div>
                <div class="form-inline">
                    <label for="vcode">验证码：</label>
                    <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="验证码" style="width: 120px; "/>
                    <a href="javascript:refreshCode()">
                        <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
                    </a>
                </div>
                <div class="check">
                    <input type="checkbox" checked="checked"><span>自动登录</span>
                    <a href="#">忘记密码?</a>
                </div>
                <div>
                    <input class="loginbtn" type="submit" value="登录">
                </div>
            </form>
            <div class="link">
                <!--<ul>
                    <li class="denglu_qq"></li>
                    <li class="denglu_wb"></li>
                    <li class="denglu_zfb"></li>
                    <li class="denglu_wx"></li>
                </ul>-->
                <a href="https://graph.qq.com/oauth2.0/show?which=Login&display=pc&response_type=code&state=F6F9AF1409610415EF86F1E00DFAFC03B4346008A5B4F8D5EA3BB1A7B40ECAB70768BA81F55E4E995B71DA0A2FE931B1&client_id=100273020&redirect_uri=https%3A%2F%2Fqq.jd.com%2Fnew%2Fqq%2Fcallback.action%3Fview%3Dnull%26uuid%3D18d9c2e7c4684bb8a12a5912f4c9d7ae"><img src="images/regetype.png" alt="" class="qitadenglu"></a>
                <a href="register.jsp"><span>立即注册</span></a>
            </div>
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" >
                    <span></span></button>

                    <strong>${login_msg}</strong>


            </div>

        </div>
    </div>
</div>
<script>
    <c:if test="${login_msg != null }">
            alert("验证码错误");
    </c:if>
</script>
<div class="mod_copyright">
    <p class="mod_copyright_links">
        关于我们 | 联系我们 | 联系客服 | 商家入驻 | 营销中心 | 手机品优购 | 友情链接 | 销售联盟 | 品优购社区 | 品优购公益 | English Site | Contact U
    </p>
    <p class="mod_copyright_info">
        Copyright ©2021 龚佳龙 . All rights reserved.<br>
        互联网商城信息服务资格证书：（湘）-经营性-2021-2580
    </p>
</div>
</body>
</html>