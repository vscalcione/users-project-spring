<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>La mia prima JSP</title>
</head>
<body>
	<h1>Ciao JSP ${who}</h1>

	<p>${helloMessage}</p>

	<c:url value="/calc" var="calcUrl"></c:url>
	<a href="${calcUrl}">Calcolatrice</a> <br>

	<c:url value="/users" var="usersUrl"></c:url>
	<a href="${usersUrl}">Lista utenti</a> <br>
	<c:url value="/groups" var="groupsUrl"></c:url>
	<a href="${groupsUrl}">Lista gruppi</a> <br>
	<c:url value="/authorities" var="authoritiesUrl"></c:url>
	<a href="${authoritiesUrl}">Lista authorities</a> <br>

</body>
</html>