<%@include file="../common/head.jsp" %>>
<title>Insert title here</title>
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