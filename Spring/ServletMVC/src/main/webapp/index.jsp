<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<h1>메인 화면</h1>
	<ul>
	
		<li><a href="<%= root %>/board/list.do">list (게시글목록)</a></li>
	</ul>
</body>
</html>