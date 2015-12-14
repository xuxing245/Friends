<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/head.jsp" %>
</head>
<body>
<form action="/login" method="post">
	用户名:
	<input type="text" name="username" value=""/>
	<br/>
	密码:
	<input type="password" name="password" value="" />
	<br/>
	<input type="submit" name="submit" value="登录" />
</form>
<a href="/login/register/show">注册</a>
</body>
</html>