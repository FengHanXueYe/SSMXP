<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset rows="15%,*,5%" frameborder="no">
	<frame src="main.action?method=top"/>
	<frameset cols="15%,*">
		<frame src="main.action?method=left"/>
		<frame name="qqqq" src="main.action?method=right"/>
	</frameset>
	<frame src="main.action?method=bottom"/>
</frameset>

</html>