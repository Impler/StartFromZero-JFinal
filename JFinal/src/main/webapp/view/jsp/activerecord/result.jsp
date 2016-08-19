<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../common/base.jsp" %>
<title>结果页</title>
</head>
<body>
<h2>${requestScope.result.msg }</h2>
<a href="user/add">继续添加</a> <a href="user/queryAll">查询全部</a>
</body>
</html>