<%@include file="common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<c:forEach var="f" items="${list }">
	${f.name } - <a href="/friend/detail?id=${f.id }">详情</a><br/>
</c:forEach>
</body>
</html>