<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>つぶやき</title>
</head>
<body>
<h1>つぶやき</h1>
<p>
<c:out value="${loginUser.name}" />さんログイン中
<a href="/example/Logout">ログアウト</a>
</p>

<p><a href="/example/Main">更新</a></p>
<form action="/example/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>

<c:if test="${not empty errorMsg}">
	<p>${errorMsg}</p>
</c:if>
<c:forEach var="mutter" items="${mutterList}">
	<p><c:out value="${mutter.userName}" />:
		<c:out value="${mutter.text}" /></p>
</c:forEach>
</body>
</html>