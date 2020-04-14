<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User ${user.userName}</title>
</head>
<body>

<c:url value="/users" var="backUrl" />
<a href="${backUrl}">Indietro</a> <br>
<hr>
<c:choose>
	<c:when test="${not empty user.userId}">
		<c:url value="/users/${user.userId}/edit" var="saveUrl" />
	</c:when>
	<c:otherwise>
		<c:url value="/users/new" var="saveUrl" />
	</c:otherwise>
</c:choose>

<form action="${saveUrl}" method="post">
	<c:if test="${not empty user.userId}">
		<label>User id:</label> ${user.userId}<br>
		<input type="hidden" name="userId" value="${user.userId}">
	</c:if>
	<label>Username:</label>
		<input type="text" name="userName" value="${user.userName}"> <br>
	<label>Password:</label>
		<input type="password" name="password" value="${user.password}"> <br>
	<label>Enabled:</label>
		<input type="checkbox" name="enabled" ${user.enabled?'checked':''} value="true"> <br>

	<input type="reset" value="Cancella"> <input type="submit" value="Salva">
</form>

<c:if test="${not empty user.userId}">
	<hr>
	<c:if test="${not empty userAuthorities}">
		<table>
			<tr>
				<th>Authority</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${userAuthorities}" var="userAuthority">
				<tr>
					<td>${userAuthority.authority}</td>
					<td>${userAuthority.description}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:url value="/users/${user.userId}/addAuthority" var="addAuthorityUrl" />
	<form action="${addAuthorityUrl}" method="post">
		<input type="hidden" name="userName" value="${user.userName}">
 		<select name="authority">
			<option>---</option>
			<c:forEach items="${authorities}" var="authority">
				<option value="${authority.authority}">${authority.description}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Aggiungi">
	</form>
</c:if>
</body>
</html>