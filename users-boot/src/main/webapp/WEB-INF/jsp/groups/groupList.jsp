<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
	<jsp:param name="active" value="groups" />
</jsp:include>

<div class="container">
<c:url value="/groups/new" var="newGroupUrl" />
<a href="${newGroupUrl}">Crea nuovo gruppo</a>
<table class="table">
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

</div>
</body>
</html>