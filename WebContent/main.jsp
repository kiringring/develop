<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User, model.Mutter,java.util.List" %>
<%
	User loginUser = (User) session.getAttribute("loginUser");
	List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
	String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>つぶやき</title>
</head>
<body>
<h1>つぶやき</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="/example/Logout">ログアウト</a>
</p>
<p><a href="/example/Main">更新</a></p>
<form action="/example/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<% if(errorMsg != null ){ %>
<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter : mutterList){%>
	<p><%= mutter.getUserName() %>:<%= mutter.getText()  %></p>
<% }%>
</body>
</html>