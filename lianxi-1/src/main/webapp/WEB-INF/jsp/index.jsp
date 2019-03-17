<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://mytag.com/core" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.3.0/dist/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		var zhi = '${logins}';
		if(zhi.length>0){
			alert(zhi);
		}
	})
</script>

</head>
<body>
	<center>
	<form action="tbuser.action?method=login" method="post">
		<table border="1px" width="50%">
			<tr>
				<td>登录名：</td>
				<td><input name="username"></td>
				<td><mytag:helloWorld/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
				<td></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="提交"></td>
				
			</tr>
		</table>
		</form>
	</center>


</body>
</html>