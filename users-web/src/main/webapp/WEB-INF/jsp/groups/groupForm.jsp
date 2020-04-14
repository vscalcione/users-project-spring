<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Group ${group.groupName}</title>
</head>
<body>

<c:url value="/groups" var="backUrl" />
<a href="${backUrl}">Indietro</a> <br>
<hr>
<c:choose>
	<c:when test="${not empty group.groupName}">
		<c:url value="/groups/${group.groupName}/edit" var="saveUrl" />
	</c:when>
	<c:otherwise>
		<c:url value="/groups/new" var="saveUrl" />
	</c:otherwise>
</c:choose>

<form action="${saveUrl}" method="post">
	<label>Group Name:</label>
<%--
	<c:choose>
		<c:when test="${not empty group.groupName}">
			${group.groupName}
			<input type="hidden" name="groupName" value="${group.groupName}">
		</c:when>
		<c:otherwise>
			<input type="text" name="groupName" value="${group.groupName}">
		</c:otherwise>
	</c:choose>
 --%>
	<input type="text" name="groupName" value="${group.groupName}">
	<br>

	<label>Description:</label>
	<input type="text" name="description" value="${group.description}"> <br>

	<input type="reset" value="Cancella"> <input type="submit" value="Salva">
</form>
</body>
</html>