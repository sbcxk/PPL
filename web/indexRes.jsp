<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
</head>
<body>
    <%--<% //response.sendRedirect(request.getContextPath()+"list.jsp");
        request.getRequestDispatcher("/index").forward(request,response);
    %>--%>
<jsp:forward page="/indexServlet"></jsp:forward>
</body>
</html>
