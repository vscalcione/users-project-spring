<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GRoup list</title>
</head>
<body>
<c:url value="/groups/new" var="newGroupUrl" />
<a href="${newGroupUrl}">Crea nuovo gruppo</a>
<table>
	<tr>
		<th>Group Name</th> <th>Description</th>
		<th></th>
	</tr>

	<c:forEach items="${groupList}" var="group">
		<c:url value="/groups/${group.groupName}" var="groupDetailUrl" />
		<c:url value="/groups/${group.groupName}/edit" var="groupEditUrl" />
		<c:url value="/groups/${group.groupName}/delete" var="groupDeleteUrl" />
		<tr>
			<td>
				<a href="${groupDetailUrl}">
					${group.groupName}
				</a>
			</td>
			<td>${group.description }</td>
			<td>
				<a href="${groupEditUrl}">Modifica</a> |
				<a href="${groupDeleteUrl}" onclick="return confirm('Vuoi eliminare?');">Elimina</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>