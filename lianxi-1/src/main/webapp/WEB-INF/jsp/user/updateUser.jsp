<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="tbuser.action?method=doUpdateUser" method="post">
		<table border="1px" width="90%">
			<tr>
				<td width="40%">用户名<input type="hidden" name="userid" value="${list.userid }"/></td>
				<td width="40%"><input type="text" name="username" value="${list.username }" /></td>
				<td></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" /></td>
				<td></td>
			</tr>
			<tr>
				<td>角色</td>
				<td>
					<select name="userroles" >
						<option value="01" <c:if test="${list.userroles eq '01' }">selected</c:if>>学生</option>
						<option value="02" <c:if test="${list.userroles eq '02' }">selected</c:if>>老师</option>
						<option value="03" <c:if test="${list.userroles eq '03' }">selected</c:if>>校长</option>
						<option value="04" <c:if test="${list.userroles eq '04' }">selected</c:if>>管理员</option>
					</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><input type="text" name="nickname" value="${list.nickname }"/></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="修改用户信息" /></td>
			</tr>
		</table>
	</form>
</center>



</body>
</html>