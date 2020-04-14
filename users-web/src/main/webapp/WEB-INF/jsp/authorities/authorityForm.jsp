<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authority ${authority.authority}</title>
</head>
<body>

<c:url value="/authorities" var="backUrl" />
<a href="${backUrl}">Indietro</a> <br>
<hr>
<c:choose>
	<c:when test="${not empty authority.authority}">
		<c:url value="/authorities/${authority.authority}/edit" var="saveUrl" />
	</c:when>
	<c:otherwise>
		<c:url value="/authorities/new" var="saveUrl" />
	</c:otherwise>
</c:choose>

<form action="${saveUrl}" method="post">
	<label>Authority:</label>
<%--
 	<c:choose>
		<c:when test="${not empty authority.authority}">
			${authority.authority}
			<input type="hidden" name="authority" value="${authority.authority}">
		</c:when>
		<c:otherwise>
			<input type="text" name="authority">
		</c:otherwise>
	</c:choose>
 --%>
	<input type="text" name="authority" value="${authority.authority}">
	<br>

	<label>Description:</label>
	<input type="text" name="description" value="${authority.description}"> <br>

	<input type="reset" value="Cancella"> <input type="submit" value="Salva">
</form>
</body>
</html>