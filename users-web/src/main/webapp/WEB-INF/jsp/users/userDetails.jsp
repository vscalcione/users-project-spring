<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Detail ${user.userName}</title>
</head>
<body>

<c:url value="/users" var="backUrl" />
<a href="${backUrl}">Indietro</a> <br>
<hr>
<label>User id:</label> ${user.userId}<br>
<label>Username:</label> ${user.userName}<br>
<label>Password:</label> ${user.password}<br>
<label>Enabled:</label> ${user.enabled}<br>

<hr>

<dl>
	<dt>User id:</dt>
	<dd>${user.userId }</dd>

	<dt>Username:</dt>
	<dd>${user.userName }</dd>

	<dt>password:</dt>
	<dd>${user.password }</dd>

	<dt>Enabled:</dt>
	<dd>${user.enabled }</dd>
</dl>
</body>
</html>