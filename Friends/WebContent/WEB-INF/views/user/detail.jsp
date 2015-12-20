<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<h3>个人中心</h3>
<a href="/">首页</a><br><br>

昵称:${SESSION_USER.nickName }
<br>
性别:
<c:choose>
	<c:when test="${SESSION_USER.gender == 0 }">
	女
	</c:when>
	<c:when test="${SESSION_USER.gender == 1}">
	男
	</c:when>
	<c:otherwise>
	
	</c:otherwise>
</c:choose>
<br>
年龄:${SESSION_USER.age }
<br>
地址:${SESSION_USER.addressName }
<br>
爱好:${SESSION_USER.hobbies }
<br>
简介:${SESSION_USER.description }
<br>
<a href="/user/update">编辑</a>
</body>
</html>