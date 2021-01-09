<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>admin</title>
	<!--- CSS --->
	<link rel="stylesheet" href=".././css/style.css" type="text/css" />
	<!--- Javascript libraries (jQuery and Selectivizr) used for the custom checkbox --->
	<!--[if (gte IE 6)&(lte IE 8)]>
		<script type="text/javascript" src=".././js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src=".././js/selectivizr.js"></script>
		<noscript><link rel="stylesheet" href=".././css/fallback.css" /></noscript>
	<![endif]-->

	</head>

	<body>
	<div id="container">
		<form action="${pageContext.request.contextPath}/adminLoginServlet" method="post">
			<div class="login">LOGIN</div>
			<div class="username-text">Adminname:</div>
			<div class="password-text">Password:</div>
			<div class="username-field">
				<input type="text" name="adminname" id="Adminname" placeholder="请输入账号" />
			</div>
			<div class="password-field">
				<input type="password" name="adminpassword" id="adminpassword" placeholder="请输入密码" />
			</div>
			<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">Remember me</label>
			<div class="forgot-usr-pwd"> <a href="#"></a>  <a href="#"></a></div>
			<input type="submit" name="submit" value="GO" />
		</form>
	</div>
	<div style="text-align: center">
		<strong>${admin_msg}</strong>
	</div>
	<div id="footer">
		Copyright © 2021 PPL Secondary development <a href="${pageContext.request.contextPath}/index.jsp" target="_blank" title="拼夕夕">拼夕夕</a>
	</div>
	</body>
</html>
