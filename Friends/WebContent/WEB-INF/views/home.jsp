<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>
home page
<br/> 
<c:if test="${bindSuccess }">
	<h3>绑定成功</h3>
</c:if>

<c:if test="${loginSuccess }">
	<h3>登录成功</h3>
</c:if>

<c:if test="${registerSuccess }">
	<h3>登录成功</h3>
</c:if>

用户名:${SESSION_USER.name }
	<a href="/login/logout">注销</a>
<br/>
<a href="/friend/list">朋友列表</a>
<a href="/activity/list">活动列表</a>
<a href="#">消息列表</a>
<a href="#">个人中心</a>
</body>
</html>