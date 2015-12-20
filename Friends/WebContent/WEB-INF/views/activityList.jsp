<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<a href="/activity/create">创建活动</a>

<h3>活动列表</h3>
<a href="/">首页</a><br><br>

<c:forEach var="act" items="${activityList }">
<a href="/activity/detail?id=${act.id }">${act.title}</a> 参与人数:${act.userNumber==null?0:act.userNumber }
<br/>
</c:forEach>
</body>
</html>