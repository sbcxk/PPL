<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/jquery-3.2.1.min.js"></script>
<div class="the_navitems">
    <ul id="head">
        <%--<li><a href="#">服装城</a></li>
        <li><a href="#">电器城</a></li>
        <li><a href="#">生鲜超市</a></li>
        <li><a href="#">医药馆</a></li>
        <li><a href="#">营业厅</a></li>
        <li><a href="#">魅力惠</a></li>
        <li><a href="#">飞猪旅行</a></li>
        <li><a href="#">苏宁易购</a></li>--%>
    </ul>
</div>
<script type="text/javascript">
    $(function () {
        //发送ajax查询所有分类
        $.post("${pageContext.request.contextPath}/categoryServlet",{"method":"doPost"},function(obj) {
            // alert(obj);
            $(obj).each(function () {
                //alert(this.cname);
                $("#head").append("<li><a href='${pageContext.request.contextPath}/categoryPageServlet?method=doPost&cid="+this.cid+"'>"+this.cname+ "</a></li>");
            })
        },"json");
    })
</script>
