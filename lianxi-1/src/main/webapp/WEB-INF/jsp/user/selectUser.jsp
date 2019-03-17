<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<table border="1px" width="60%">
	<tr>
		<td>用户名</td>
		
		<td><input type="text" value="${su.username }"/></td>
	</tr>
	<tr>
		<td>角色</td>
		<td>
			<c:if test="${su.userroles eq '01'}">学生</c:if>
			<c:if test="${su.userroles eq '02'}">老师</c:if>
			<c:if test="${su.userroles eq '03'}">校长</c:if>
			<c:if test="${su.userroles eq '04'}">管理员</c:if>
		</td>
	</tr>
	<tr>
		<td>昵称</td>
		<td><input type="text" value="${su.nickname }"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="button" value="返回" onclick="window.history.go(-1);"/></td>
		
	</tr>
</table>
</center>

</body>
</html>