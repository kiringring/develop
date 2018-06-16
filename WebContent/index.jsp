<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <% String errorMsg = (String) request.getAttribute("errorMsg"); %>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>つぶやき</title>
</head>
<body>
<h1>つぶやきページへようこそ</h1>
<form action="/example/Login" method="post">
ユーザ名  : <input type="text" name="name"><br>
パスワード: <input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
<!-- <% if(errorMsg != null ){ %>
<p><%= errorMsg %></p>
<% } %> -->
</body>
</html>