<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
<title>Insert title here</title>
</head>
<body>
<a>创建活动</a>

<h3>活动列表</h3>
<c:forEach var="act" items="${activityList }">
<a href="#">${act.title}</a>
</c:forEach>
</body>
</html>