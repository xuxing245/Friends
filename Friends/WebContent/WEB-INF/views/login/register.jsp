<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<form action="/login/register" method="post">
	用户名:
	<input type="text" name="username" value=""/>
	<br/>
	密码:
	<input type="password" name="password" value="" />
	<br/>
	<input type="submit" name="submit" value="注册" />
</form>
</body>
</html>