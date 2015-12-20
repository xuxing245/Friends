<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<h3>玩伴列表</h3>
<a href="/">首页</a><br><br>
<c:forEach var="f" items="${list }">
	${f.name } - <a href="/friend/detail?id=${f.id }">详情</a><br/>
</c:forEach>
</body>
</html>