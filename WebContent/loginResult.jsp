<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>つぶやき</title>
</head>
<body>
<h1>つぶやきログイン</h1>
<% if(loginUser != null){ %>
	<p>ようこそ<%= loginUser.getName() %>さん</p>
	<a href="/example/Main">つぶやき投稿・閲覧へ</a>
<% } else { %>
	<p>ログインに失敗しました</p>
	<a href="/example/">TOPへ</a>
<% } %>
</body>
</html>