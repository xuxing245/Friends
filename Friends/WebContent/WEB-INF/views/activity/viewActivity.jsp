<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<h3>活动信息</h3><br>
<a href="/activity/list">列表</a>
<br/>
<br/>
主题:${activity.title }
时间:${activity.startTime }
地址:${activity.addressName }

<c:choose>
	<c:when test="${SESSION_USER.id eq activity.creater }">
		<a href="/activity/cancel?id=${activity.id }">取消活动</a>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${joined }">
				<a href="/activity/quit?id=${activity.id }">退出</a>
			</c:when>
			<c:otherwise>
				<a href="/activity/join?id=${activity.id }">参加</a>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
</body>
</html>