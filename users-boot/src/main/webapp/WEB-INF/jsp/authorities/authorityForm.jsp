<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
	<jsp:param name="active" value="authorities" />
</jsp:include>

<div class="container">

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
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<label>Authority:</label>

	<input type="text" name="authority" value="${authority.authority}">
	<br>

	<label>Description:</label>
	<input type="text" name="description" value="${authority.description}"> <br>

	<input type="reset" value="Cancella"> <input type="submit" value="Salva">
</form>

</div>
</body>
</html>