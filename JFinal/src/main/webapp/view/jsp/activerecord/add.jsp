<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common/base.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
</head>
<body>
	<form method="post"
		<c:if test="${null != bean }"> action="user/update"</c:if>
		<c:if test="${null == bean }"> action="user/addUser"</c:if> >
		<input type="hidden" name="user.id" value="${bean.id }" />
		<label>用户名user.username:</label><input type="text" name="user.username" value="${bean.username }"/> <br />
		<label>邮箱user.email:</label><input type="text" name="user.email" value="${bean.email }"/> <br />
		<input type="submit" value="提交" />
	</form>
</body>
</html>