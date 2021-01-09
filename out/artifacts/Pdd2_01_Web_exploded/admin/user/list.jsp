<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>admin</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="../../css/layout.css" type="text/css" media="screen" />
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="../../css/ie.css" type="text/css" media="screen" />
    <![endif]-->
    <!--引入图标-->
    <link rel="shortcut icon" href="../../favicon.ico"/>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="../../js/jquery-1.9.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="../../js/hideshow.js" type="text/javascript"></script>
    <script src="../../js/jquery.tablesorter.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="../../js/jquery.equalHeight.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
                $(".tablesorter").tablesorter();
            }
        );
        $(document).ready(function () {
            //When page loads...
            $(".tab_content").hide(); //Hide all content
            $("ul.tabs li:first").addClass("active").show(); //Activate first tab
            $(".tab_content:first").show(); //Show first tab content

            //On Click Event
            $("ul.tabs li").click(function () {

                $("ul.tabs li").removeClass("active"); //Remove any "active" class
                $(this).addClass("active"); //Add "active" class to selected tab
                $(".tab_content").hide(); //Hide all tab content

                var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
                $(activeTab).fadeIn(); //Fade in the active ID content
                return false;
            });

        });
    </script>
    <script type="text/javascript">
        $(function () {
            $('.column').equalHeight();
        });
    </script>
    <script>
        function deleteUser(id) {
            //用户安全提示
            if (confirm("宁真的要把我删了吗QWQ？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/delUserServlet?id=" + id;
            }
        }
    </script>
</head>
<body>

<header id="header">
    <hgroup>
        <h1 class="site_title" style="text-align: center"><a href="../home.jsp">管理项</a></h1>
        <h2 class="section_title">仪表盘</h2>
        <div class="btn_view_site"><a href="../../index.jsp">查看官网</a></div>
    </hgroup>
</header> <!-- end of header bar -->

<aside id="sidebar" class="column">
    <form class="quick_search">
        <input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
    </form>
    <hr/>
    <h3>分类管理</h3>
    <ul class="toggle">
        <li class="icn_categories"><a href="${pageContext.request.contextPath}/adminCategoryServlet">分类列表</a></li>
        <li class="icn_new_article"><a href="../category/add.jsp">添加分类</a></li>
    </ul>
    <h3>用户管理</h3>
    <ul class="toggle">
        <li class="icn_view_users"><a href="${pageContext.request.contextPath}/findAllUserServlet">用户列表</a></li>
        <li class="icn_add_user"><a href="${pageContext.request.contextPath}/addUserServlet">新增用户</a></li>
        <li class="icn_profile"><a href="#">我的信息</a></li>
    </ul>
    <h3>商品管理</h3>
    <ul class="toggle">
        <li class="icn_folder"><a href="${pageContext.request.contextPath}/findAllServlet">商品列表</a></li>
        <li class="icn_new_article"><a href="${pageContext.request.contextPath}/addPUIServlet">添加商品</a></li>
    </ul>
    <h3>订单管理</h3>
    <ul class="toggle">
        <li class="icn_categories"><a href="${pageContext.request.contextPath}/findAllOrdServlet">订单列表</a></li>
        <li class="icn_photo"><a href="${pageContext.request.contextPath}/findAllOrdServlet?state=0">未付款订单</a></li>
        <li class="icn_photo"><a href="${pageContext.request.contextPath}/findAllOrdServlet?state=1">已付款订单</a></li>
        <li class="icn_photo"><a href="${pageContext.request.contextPath}/findAllOrdServlet?state=2">已发货订单</a></li>
        <li class="icn_photo"><a href="${pageContext.request.contextPath}/findAllOrdServlet?state=3">已完成订单</a></li>
    </ul>

    <footer>
        <hr />
        <p><strong>Copyright &copy; 2021 PPL Secondary development</strong></p>
    </footer>
</aside><!-- end of sidebar -->

<section id="main" class="column">

    <h4 class="alert_info">欢迎使用查询所有商品功能。</h4>
    <article class="module width_full">
        <header><h3>用户列表</h3></header>
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByNameServlet" method="post" style="float: right">
            <div class="form-group" >
                <label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
                <div class="input-group">
                    <div class="input-group-addon">用户名</div>
                    <input type="text" class="form-control" id="exampleInputAmount" value="${condition.name[0]}" placeholder="支持模糊搜索" name="name">
                </div>
            </div>
            <button type="submit" class="btn btn-primary" >查询</button>
        </form>
        <form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
            <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
                <TBODY>
                <tr>
                    <td class="ta_01" align="center" bgColor="#f5fafe">
                        <table cellspacing="0" cellpadding="1" rules="all"
                               bordercolor="gray" border="1" id="DataGrid1"
                               style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                            <tr
                                    style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

                                <td align="center" width="5%">
                                    序号
                                </td>
                                <td align="center" width="10%">
                                    用户名
                                </td>
                                <td align="center" width="10%">
                                    密码
                                </td>
                                <td align="center" width="15%">
                                    邮箱
                                </td>
                                <td align="center" width="10%">
                                    激活状态
                                </td>
                                <td width="7%" align="center">
                                    编辑
                                </td>
                                <td width="7%" align="center">
                                    删除
                                </td>
                            </tr>
                            <c:forEach items="${sessionScope.list }" var="p" varStatus="vs">
                                <tr onmouseover="this.style.backgroundColor = 'white'"
                                    onmouseout="this.style.backgroundColor = '#F5FAFE';">
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="5%">
                                            ${vs.count}
                                    </td>
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">
                                            ${p.username}
                                    </td>
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">
                                            ${p.password}
                                    </td>
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">
                                            ${p.email}
                                    </td>
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">
                                            ${p.status}
                                    </td>
                                    <td align="center" style="HEIGHT: 22px">
                                        <a href="${ pageContext.request.contextPath }/findUserServlet?id=${p.id}">
                                            <img src="../../images/icn_edit.png" border="0" style="CURSOR: hand">
                                        </a>
                                    </td>

                                    <td align="center" style="HEIGHT: 22px">
                                        <a href="javascript:deleteUser(${p.id});">
                                            <img src="../../images/icn_trash.png" width="16" height="16" border="0" style="CURSOR: hand">
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>

                </TBODY>
            </table>
        </form>

    </article><!-- end of styles article -->
    <div class="spacer"></div>
</section>


</body>

</html>