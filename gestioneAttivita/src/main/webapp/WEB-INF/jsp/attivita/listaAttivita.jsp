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
<a href="${ctx}attivita/new">Crea nuova attivita</a>
<table class="table">
	<tr>
		<th>ID</th>
		<th>Attivit&agrave;</th>
		<th>Data inizio</th>
		<th>Data fine</th>
		<th></th>
	</tr>

	<c:forEach items="${listaAttivita}" var="attivita">
		<tr>
			<td>
				<a href="${ctx}attivita/${attivita.idAttivita}">
					${attivita.idAttivita}
				</a>
			</td>
			<td>${attivita.nomeAttivita}</td>
			<td>
				<fmt:formatDate value="${attivita.dataInizio}" pattern="dd/MM/yyyy"/>
			</td>
			<td>
				<fmt:formatDate value="${attivita.dataFine}" pattern="dd/MM/yyyy"/>
			</td>
			<td>
				<a href="${ctx}attivita/${attivita.idAttivita}/edit">Modifica</a> |
				<a href="${ctx}attivita/${attivita.idAttivita}/delete" onclick="return confirm('Vuoi eliminare?');">Elimina</a> |
				<a href="${ctx}attivita/${attivita.idAttivita}/visualizzaDipendenti">Visualizza Dipendenti</a>
			</td>
		</tr>
	</c:forEach>
</table>

</div>
</body>
</html>