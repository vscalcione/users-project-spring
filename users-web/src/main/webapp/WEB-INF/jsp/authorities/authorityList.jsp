<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authority list</title>
</head>
<body>
<c:url value="/authorities/new" var="newAuthorityUrl" />
<a href="${newAuthorityUrl}">Crea nuova Authority</a>
<table>
	<tr>
		<th>Authority</th> <th>Description</th>
		<th></th>
	</tr>

	<c:forEach items="${authorityList}" var="authority">
		<c:url value="/authorities/${authority.authority}" var="authorityDetailUrl" />
		<c:url value="/authorities/${authority.authority}/edit" var="authorityEditUrl" />
		<c:url value="/authorities/${authority.authority}/delete" var="authorityDeleteUrl" />
		<tr>
			<td>
				<a href="${authorityDetailUrl}">
					${authority.authority}
				</a>
			</td>
			<td>${authority.description }</td>
			<td>
				<a href="${authorityEditUrl}">Modifica</a> |
				<a href="${authorityDeleteUrl}" onclick="return confirm('Vuoi eliminare?');">Elimina</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>