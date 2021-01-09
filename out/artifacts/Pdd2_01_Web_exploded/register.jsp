<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>个人注册</title>
    <!--引入图标-->
    <link rel="shortcut icon" href="favicon.ico"/>
    <!--引入初始化样式文件-->
    <link rel="stylesheet" href="css/拼夕夕css初始化.css">
    <!--引入注册页面css-->
    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript">
        //切换验证码
        function refreshCode(){
            var vcode = document.getElementById("vcode");
            vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }

        window.onload = function () {
            document.getElementById("form").onsubmit = function () {
                return checkUsername() && checkPassword() && checkEmail();
            }
            //绑定立交事件
            document.getElementById("username").onblur = checkUsername;
            document.getElementById("password").onblur = checkPassword;
            document.getElementById("email").onblur = checkEmail;
        }
    </script>
    <script>

        //校验用户名
        function checkUsername() {
            //获取用户名值
            var username = document.getElementById("username").value;
            var reg_username = /^\w{6,12}$/;
            var flag = reg_username.test(username);
            var s_username = document.getElementById("s_username");
            if (flag)
                s_username.innerHTML = "<img widtn='35' height='25' src='images/gou.png'/>";
            else
                s_username.innerHTML = "用户名格式错误";
            return flag;
        }

        function checkPassword() {
            //获取用户名值
            var password = document.getElementById("password").value;
            var reg_password = /^\w{6,12}$/;
            var flag = reg_password.test(password);
            var s_password = document.getElementById("s_password");
            if (flag)
                s_password.innerHTML = "<img widtn='35' height='25' src='images/gou.png'/>";
            else
                s_password.innerHTML = "密码格式错误";
            return flag;
        }

        function checkEmail() {
            //获取用户名值
            var email = document.getElementById("email").value;
            /*数字开头包含@.2-4个字母结尾*/
            var reg_email = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
            var flag = reg_email.test(email);
            var s_email = document.getElementById("s_email");
            if (flag)
                s_email.innerHTML = "<img widtn='35' height='25' src='images/gou.png'/>";
            else
                s_email.innerHTML = "邮箱格式错误";
            return flag;
        }
        // $(function () {
        //     //当表单提交时，调用所有的校验方法
        //     $("#form").submit(function(){
        //         //1.发送数据到服务器
        //         if(checkUsername() && checkPassword() && checkEmail()){
        //             //校验通过,发送ajax请求，提交表单的数据   username=zhangsan&password=123
        //
        //             $.post("/enrollServlet",$(this).serialize(),function(data){
        //                 //处理服务器响应的数据  data  {flag:true,errorMsg:"注册失败"}
        //
        //                 if(data.flag){
        //                     //注册成功，跳转成功页面
        //                     location.href="register_ok.html";
        //                 }else{
        //                     //注册失败,给errorMsg添加提示信息
        //                     $("#errorMsg").html(data.errorMsg);
        //
        //                 }
        //             });
        //
        //         }
        //         //2.不让页面跳转
        //         return false;
        //         //如果这个方法没有返回值，或者返回为true，则表单提交，如果返回为false，则表单不提交
        //     });
        //     //当某一个组件失去焦点是，调用对应的校验方法
        //     $("#s_username").blur(checkUsername);
        //     $("#s_password").blur(checkPassword);
        //     $("#s_email").blur(checkEmail);
        //
        //
        // });

    </script>
</head>
<body>
<div class="w">
    <header>
        <div class="logo">
            <a href="index.jsp"><img src="images/pdd_logo.png" alt=""></a>
        </div>
    </header>
    <div class="registerarea">
        <h3>
            注册新用户
            <div class="login">我有账号，马上<a href="login.jsp">登录</a></div>
        </h3>
        <div class="rg_center" >
            <div class="rg_form" style="color:#A6A6A6;">

                <form action="${pageContext.request.contextPath}/enrollServlet" method="post" id="form">
                    <table >
                        <tr>
                            <td class="td_left" ><label for="username">用户名</label> </td>
                            <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入用户名">
                                <span id="s_username" class="error"></span>
                            </td>
                        </tr>
                        <tr>
                            <td class="td_left"><label for="password">密码</label> </td>
                            <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码">
                                <span id="s_password" class="error"></span>
                            </td>
                        </tr>
                        <tr>
                            <td class="td_left"><label for="email">邮箱</label> </td>
                            <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入邮箱">
                                <span id="s_email" class="error"></span>
                            </td>
                        </tr>

                        <tr>
                            <td class="td_left"><label for="vcode">验证码</label> </td>
                            <td class="td_right"><input type="text" name="verifycode" id="verifycode" placeholder="请输入验证码">
                                <a href="javascript:refreshCode()">
                                    <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
                                </a>
                            </td>
                        </tr>
                        <div class="alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" >
                                <span>&times;</span></button>
                            <strong>${regist_msg;regist}</strong>
                        </div>
                        <tr>
                            <td  id="td_sub" colspan="2">
                                <input type="submit" id="btn_sub" value="注册">
                            </td>
                        </tr>

                    </table>
                </form>
            </div>

        </div>
    </div>
    <footer>
        <div class="mod_copyright">
            <div class="links">
                <a href="#">关于我们</a> | <a href="#">联系我们</a> | 联系客服 | 商家入驻 | 营销中心 | 手机品优购 | 友情链接 | 销售联盟 | 品优购社区 |
                品优购公益 | English Site | Contact U
            </div>
            <div class="copyright">
                Copyright ©2021 龚佳龙 . All rights reserved.<br>
                互联网商城信息服务资格证书：（湘）-经营性-2021-2580
            </div>
        </div>
    </footer>
</div>
</body>
</html>