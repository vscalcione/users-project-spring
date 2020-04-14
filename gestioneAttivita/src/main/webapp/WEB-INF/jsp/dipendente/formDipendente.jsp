<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
	<jsp:param name="active" value="dipendente" />
</jsp:include>

<div class="container">

<a href="${ctx}dipendente">Indietro</a> <br>
<hr>
<c:choose>
	<c:when test="${not empty dipendente.idMatricola}">
		<c:url value="/dipendente/${dipendente.idMatricola}/edit" var="saveUrl" />
	</c:when>
	<c:otherwise>
		<c:url value="/dipendente/new" var="saveUrl" />
	</c:otherwise>
</c:choose>

<form action="${saveUrl}" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<c:if test="${not empty dipendente.idMatricola}">
		<label>Matricola:</label>
		${dipendente.idMatricola}
		<input type="hidden" name="idMatricola" value="${dipendente.idMatricola}">
		<br>
	</c:if>

	<label>Cognome:</label>
	<input type="text" name="cognome" value="${dipendente.cognome}"> <br>
	<label>Nome:</label>
	<input type="text" name="nome" value="${dipendente.nome}"> <br>

	<input type="reset" value="Cancella"> <input type="submit" value="Salva">
</form>

</div>
</body>
</html>