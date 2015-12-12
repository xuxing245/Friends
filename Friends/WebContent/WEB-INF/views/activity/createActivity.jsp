<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
创建活动
<form action="/activity/save" method="post">
	主题:<input type="text" name="title"/><br/>
	时间:<input type="text" name="startTime"/><br/>
	地址:<input type="text" name="addressName"><br>
	<input type="hidden" name="creater" value="${SESSION_USER.id }" />
	<input type="submit" value="保存">
</form>
</body>
</html>