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
<h3>活动信息</h3><br>
主题:${activity.title }
时间:${activity.startTime }
地址:${activity.addressName }
创建人:${activity.creater }

<a href="/activity/cancel?id=${activity.id }">取消活动</a>
</body>
</html>