<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common/base.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入页</title>
</head>
<body>
	<form method="post" action="validator/test">
		${token }
		<label>是否已婚：</label><input type="text" name="isMarried" /> <br />
		<label>姓名：</label><input type="text" name="name" /> <br />
		<input type="submit" value="提交" />
	</form>
</body>
</html>