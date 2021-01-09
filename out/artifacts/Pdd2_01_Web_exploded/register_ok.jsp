<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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

        <!--取消链接下划线-->
        <link rel="stylesheet" href="css/a_a.css">
		<!--导入jquery-->
		<script src="js/jquery-3.2.1.min.js"></script>
    </head>
    <body>
    <!--引入头部-->
    <section class="shortcut">
        <div class="w">
            <div class="f1">
                <ul>
                    <li><div>
                        ${user.name},欢迎您！
                    </div>&nbsp;&nbsp;</li>
                    <li>
                        <a href="login.jsp">请登录</a> &nbsp;
                        <a href="register.jsp" class="style_red">免费注册</a>
                    </li>
                </ul>
            </div>

            <div class="fr">
                <ul>
                    <li>我的订单</li>
                    <li></li>
                    <li>
                        <div class="dropdown">
                            <button  type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                我的拼夕夕
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <div>&nbsp;&nbsp;<a href="#">砍一刀</a></div>
                                <div>&nbsp;&nbsp;<a href="#">已买宝贝</a></div>
                                <div>&nbsp;&nbsp;<a href="#">已卖宝贝</a></div>
                            </ul>
                        </div>
                    </li>
                    <li></li>
                    <li>拼夕夕VIP</li>
                    <li></li>
                    <li>企业采购</li>
                    <li></li>

                    <li>
                        <div class="dropdown">
                            <button  type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                关注夕夕
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <div>&nbsp;&nbsp;<a href="#">砍一刀</a></div>
                                <div>&nbsp;&nbsp;<a href="#">已买宝贝</a></div>
                                <div>&nbsp;&nbsp;<a href="#">已卖宝贝</a></div>
                            </ul>
                        </div>
                    </li>
                    <li></li>
                    <li>
                        <div class="dropdown">
                            <button  type="button" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                客服热线
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <div>&nbsp;&nbsp;<a href="#">砍一刀</a></div>
                                <div>&nbsp;&nbsp;<a href="#">已买宝贝</a></div>
                                <div>&nbsp;&nbsp;<a href="#">已卖宝贝</a></div>
                            </ul>
                        </div>
                    </li>
                    <li></li>
                    <li>
                        <div class="dropdown">
                            <button  type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                网站导航
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <div>&nbsp;&nbsp;<a href="#">砍一刀</a></div>
                                <div>&nbsp;&nbsp;<a href="#">已买宝贝</a></div>
                                <div>&nbsp;&nbsp;<a href="#">已卖宝贝</a></div>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </section>
    <!--头部模块-->
    <header class="header w">
        <!--logo模块-->
        <div class="logo">
            <h1>
                <a href="index.jsp" title="拼夕夕商城">拼夕夕商城</a>
            </h1>
        </div>

        <!--搜索模块-->
        <div class="search">
            <input type="search" name=" " id=" " placeholder="拼一下·更实惠">
            <button>搜索</button>
        </div>

        <!--热词模块-->
        <div class="hotwords">
            <a href="#" class="style_red">百亿补贴</a>
            <a href="#">优惠首发</a>
            <a href="#">9.9包邮</a>
            <a href="#">满减活动</a>
            <a href="#">拼团活动</a>
            <a href="#">全场1折</a>
            <a href="#">助力砍一刀</a>
        </div>

        <!--购物车模块-->
        <div class="shopcar">
            我的购物车
            <i class="count">888</i>
        </div>
    </header>
    <div id="header"></div>
        <!-- 头部 end -->
    	<div style="text-align:center;red:yellow;font-weight:bold;height:150px;padding-top:100px;padding-bottom:200px;font-size:30px;">
    		<h4>恭喜，注册成功！请前往您的邮箱激活账号，激活后才能登录。</h4>
    	</div>
        <!--引入尾部-->
    	<div id="footer"></div>
    <!--底部模块-->
    <footer class="footer">
        <div class="w">
            <div class="mod_service">
                <ul>
                    <li>
                        <h5></h5>
                        <div class="service_txt">
                            <h4>正品保证</h4>
                            <p>诚信夕夕，绝无假货</p>
                        </div>
                    </li>
                    <li>
                        <h5></h5>
                        <div class="service_txt">
                            <h4>正品保证</h4>
                            <p>诚信夕夕，绝无假货</p>
                        </div>
                    </li>
                    <li>
                        <h5></h5>
                        <div class="service_txt">
                            <h4>正品保证</h4>
                            <p>诚信夕夕，绝无假货</p>
                        </div>
                    </li>
                    <li>
                        <h5></h5>
                        <div class="service_txt">
                            <h4>正品保证</h4>
                            <p>诚信夕夕，绝无假货</p>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="mod_help">
                <dl>
                    <dt>服务指南</dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大型家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl>
                    <dt>服务指南</dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大型家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl>
                    <dt>服务指南</dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大型家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl>
                    <dt>服务指南</dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大型家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl>
                    <dt>服务指南</dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大型家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl>
                    <dt>帮助中心</dt>
                    <dd>
                        <img src="images/wx_cz.jpg" alt="">
                        拼夕夕客户端
                    </dd>
                </dl>
            </div>
            <div class="mod_copyright">
                <div class="links">
                    <a href="#">入驻多多国际</a>|
                    <a href="#">校园招聘</a>|
                    <a href="#">关于我们</a>|
                    <a href="#">帮助中心</a>|
                    <a href="#">下载App</a>|
                    <a href="#">消费者保障</a>|
                    <a href="#">维权投诉指引</a>|
                    <a href="#">廉正举报</a>|
                    <a href="#">服务协议</a>|
                    <a href="#">隐私政策</a>|
                    <a href="#">征求意见</a>|
                    <a href="#">Investor Relations</a>|

                </div>
                <div class="copyright">
                    Copyright 2015-2020 pinduoduo.com 版权所有(增值电信业务经营许可证：沪B2-20170215)<br>
                    互联网药品信息服务资格证书：（沪）-经营性-2019-0052
                </div>
            </div>
        </div>
    </footer>
    </body>
</html>