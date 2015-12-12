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
<a href="/activity/create">创建活动</a>

<h3>活动列表</h3>
<c:forEach var="act" items="${activityList }">
<a href="/activity/detail?id=${act.id }">${act.title}</a>
<br/>
</c:forEach>
</body>
</html>