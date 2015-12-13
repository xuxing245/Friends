<%@include file="common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<a href="/activity/create">创建活动</a>

<h3>活动列表</h3>
<c:forEach var="act" items="${activityList }">
<a href="/activity/detail?id=${act.id }">${act.title}</a>
<br/>
</c:forEach>
</body>
</html>