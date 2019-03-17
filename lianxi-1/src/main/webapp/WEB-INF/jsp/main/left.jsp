<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<c:if test="${zlj.userroles eq '01' }">
	<a href="" >用户信息</a><br/>
	<a href="" >班级信息</a><br/>
	</c:if>
	<c:if test="${zlj.userroles eq '02' }">
	<a href="" >用户信息</a><br/>
	<a href="" >班级信息</a><br/>
	<a href="" >学生信息</a><br/>
		
	</c:if>
	<c:if test="${zlj.userroles eq '03' }">
	<a href="" >用户信息</a><br/>
	<a href="" >班级信息</a><br/>
	<a href="" >成绩信息</a><br/>
		
	</c:if>
	<c:if test="${zlj.userroles eq '04' }">
	<a href="" >用户信息</a><br/>
	<a href="" >班级信息</a><br/>
	<a href="" >学生信息</a><br/>
	<a href="" >课程信息</a><br/>
	<a href="" >成绩信息</a><br/>
		
	</c:if> --%>
		
	<c:if test="${zlj.userroles eq '04'}">
	<a target="qqqq" href="tbuser.action?method=queryAllUser" >用户信息</a><br/>
	<a target="qqqq" href="" >班级信息</a><br/>
	<a target="qqqq"  href="" >学生信息</a><br/>
	<a target="qqqq" href="" >课程信息</a><br/>
	<a target="qqqq" href="" >成绩信息</a><br/>
	</c:if>
	<c:if test="${zlj.userroles eq '03'}">
	<a target="qqqq" href="" >班级信息</a><br/>
	<a target="qqqq" href="" >学生信息</a><br/>
	<a target="qqqq" href="" >课程信息</a><br/>
	<a target="qqqq" href="" >成绩信息</a><br/>
	</c:if>
	<c:if test="${zlj.userroles eq '02'}">
	<a target="qqqq" href="" >学生信息</a><br/>
	<a target="qqqq" href="" >课程信息</a><br/>
	<a target="qqqq" href="" >成绩信息</a><br/>
	</c:if>
	<c:if test="${zlj.userroles eq '01'}">
	<a target="qqqq"  href="" >学生信息</a><br/>
	<a target="qqqq" href="" >成绩信息</a><br/>
	</c:if>
	
	<a href="" >退出系统</a><br/>
</body>
</html>