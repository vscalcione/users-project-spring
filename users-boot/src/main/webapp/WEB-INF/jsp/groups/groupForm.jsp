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
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

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

</div>
</body>
</html>