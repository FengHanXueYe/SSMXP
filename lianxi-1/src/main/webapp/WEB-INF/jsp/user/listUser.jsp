<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/3.3.0/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		
		
		
	})
	function sel(){
		$("form").attr("action","tbuser.action?method=queryAllUser");
		$("form").submit();
	}
</script>

</head>
<body>
<center>
	<form action="tbuser.action?method=toAddUser" method="post">
		<table align="center" border="1px" width ="90%">
			<tr>
				<td>用户名：</td>
				<td><input type="text"  name="username"/></td>
				<td>角色：</td>
				<td>
					<select name="userroles" >
						<option value="00">--请选择--</option>
						<option value="01">学生</option>
						<option value="02">老师</option>
						<option value="03">校长</option>
						<option value="04">管理员</option>
					</select>
				</td>
				<td><input type="button" value="查询"  onclick="sel()"/></td>
			</tr>
		</table>
		
		<table align="center" border="1px" width ="90%">
			<tr>
				<th width="25%">用户名</th>
				<th width="25%">用户角色</th>
				<th width="25%">昵称</th>
				<th width="25%">操作</th>
			</tr>
			<c:if test="${!empty list }">
				<c:forEach var = "item" items="${list }">
					<tr>
						<td>${item.username }</td>
						<td>
							<c:if test="${item.userroles eq '01'}">学生</c:if>
							<c:if test="${item.userroles eq '02'}">老师</c:if>
							<c:if test="${item.userroles eq '03'}">校长</c:if>
							<c:if test="${item.userroles eq '04'}">管理员</c:if>
						</td>
						<td>${item.nickname }</td>
						<td>
							<a href="tbuser.action?method=doSelectUser&userid=${item.userid }">查看</a>
							<a href="tbuser.action?method=toUpdateUser&userid=${item.userid }">修改</a>
							<a href="tbuser.action?method=doDeleteUser&userid=${item.userid }" onclick="return confirm('确定删除吗？');">删除</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">没有您要找的信息！~</td>
				</tr>
			</c:if>
			<tr>
			<td colspan="4" align="center"><input type="submit" value="新增用户信息"></td>
			</tr>
		</table>
		
	</form>
</center>
</body>
</html>