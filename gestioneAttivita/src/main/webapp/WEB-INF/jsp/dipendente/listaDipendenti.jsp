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
<a href="${ctx}dipendente/new">Crea nuovo dipendente</a>
<table class="table">
	<tr>
		<th>Matricola</th>
		<th>Cognome</th>
		<th>Nome</th>
		<th></th>
	</tr>

	<c:forEach items="${listaDipendenti}" var="dipendente">
		<tr>
			<td>
				<a href="${ctx}dipendente/${dipendente.idMatricola}">
					${dipendente.idMatricola}
				</a>
			</td>
			<td>${dipendente.cognome}</td>
			<td>${dipendente.nome}</td>
			<td>
				<a href="${ctx}dipendente/${dipendente.idMatricola}/edit">Modifica</a> |
				<a href="${ctx}dipendente/${dipendente.idMatricola}/delete" onclick="return confirm('Vuoi eliminare?');">Elimina</a> |
				<a href="${ctx}dipendente/${dipendente.idMatricola}/assegnaAttivita">Assegna attivit&agrave;</a>
			</td>
		</tr>
	</c:forEach>
</table>

</div>
</body>
</html>