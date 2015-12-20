<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp" %>
<title>Insert title here</title>
</head>
<body>

<h3>个人中心</h3>
<a href="/">首页</a><br><br>

<form action="/user/save" method="post">
昵称:
<input type="text" name="nickName" value="${SESSION_USER.nickName }">
<br>
性别:
<input type="radio" name="gender" value="0" ${SESSION_USER.gender==0?"checked":"" }>女
<input type="radio" name="gender" value="1" ${SESSION_USER.gender==1?"checked":"" }>男
<br>
年龄:
<input type="text" name="age" value="${SESSION_USER.age }">
<br>
地址:
<input type="text" name="addressName" value="${SESSION_USER.addressName }">
<br>
爱好:
<input type="text" name="hobbies" value="${SESSION_USER.hobbies }">
<br>
简介:
<input type="text" name="description" value="${SESSION_USER.description }">
<br>
<input type="hidden" name="id" value="${SESSION_USER.id }">
<input type="submit" value="保存"/>
</form>

</body>
</html>