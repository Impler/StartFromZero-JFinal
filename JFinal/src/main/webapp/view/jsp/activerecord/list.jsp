<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common/base.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
<style type="text/css">
	table, tr, td, th{
		border: 1px solid;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<c:if test="${result.msg != null }">
		${result.msg }
	</c:if>
	<table>
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>邮箱</th>
			<th>操作</th>
		</tr>
		<c:forEach var="rs" items="${page.list }" varStatus="status">
		<tr>
			<td>${status.index + 1 }</td>
			<td>${rs.username }</td>
			<td>${rs.email }</td>
			<td>
				<a href="javascript:void(0)" onclick="showDetail(${rs.id})">查看详情</a>
				<a href="user/add?id=${rs.id }">修改</a>
				<a href="user/delete?id=${rs.id }">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	总记录:${page.totalRow }
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
		function showDetail(id){
			$.ajax({
				url : "user/detail",
				data: {
					"id": id
				},
				dataType: "json",
				success: function(data){
					var s = "";
					for(var d in data){
						s += d + ":" + data[d] + "  ";
					}
					alert(s);
				}
			});
		}
	</script>
</body>
</html>