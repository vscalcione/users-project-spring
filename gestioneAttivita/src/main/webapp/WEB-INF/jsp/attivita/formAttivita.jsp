<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
	<jsp:param name="active" value="attivita" />
</jsp:include>

<div class="container">

<a href="${ctx}attivita">Indietro</a> <br>
<hr>
<c:choose>
	<c:when test="${not empty attivita.idAttivita}">
		<c:url value="/attivita/${attivita.idAttivita}/edit" var="saveUrl" />
	</c:when>
	<c:otherwise>
		<c:url value="/attivita/new" var="saveUrl" />
	</c:otherwise>
</c:choose>

<form action="${saveUrl}" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<c:if test="${not empty attivita.idAttivita}">
		<label>ID:</label>
		${attivita.idAttivita}
		<input type="hidden" name="idAttivita" value="${attivita.idAttivita}">
		<br>
	</c:if>

	<label>Attivit&agrave;:</label>
	<input type="text" name="nomeAttivita" value="${attivita.nomeAttivita}"> <br>

	<label>Data inizio:</label>
	<fmt:formatDate value="${attivita.dataInizio}" pattern="yyyy-MM-dd" var="dataInizioF"/>
	<input type="date" name="dataInizio" value="${dataInizioF}"> <br>

	<label>Data fine:</label>
	<fmt:formatDate value="${attivita.dataFine}" pattern="yyyy-MM-dd" var="dataFineF"/>
	<input type="date" name="dataFine" value="${dataFineF}"> <br>

	<input type="reset" value="Cancella"> <input type="submit" value="Salva">
</form>

</div>
</body>
</html>