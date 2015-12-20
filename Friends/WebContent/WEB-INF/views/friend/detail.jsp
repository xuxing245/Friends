<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<h3>好友信息</h3>
<a href="/">首页</a><br><br>

昵称:${friend.nickName }
<br>
性别:
<c:choose>
	<c:when test="${friend.gender == 0 }">
	女
	</c:when>
	<c:when test="${friend.gender == 1}">
	男
	</c:when>
	<c:otherwise>
	
	</c:otherwise>
</c:choose>
<br>
年龄:${friend.age }
<br>
地址:${friend.addressName }
<br>
爱好:${friend.hobbies }
<br>
简介:${friend.description }
<br>

<a href="#">发送消息</a>
</body>
</html>