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
<a href="${ctx}dipendente">Indietro</a> <br>
<table class="table">
	<tr>
		<th></th>
		<th>Attivit&agrave;</th>
		<th>Data inizio</th>
		<th>Data fine</th>
		<th></th>
	</tr>

	<c:forEach items="${listaAttivitaDipendente}" var="attivita">
		<tr>
			<td>
			</td>
			<td>${attivita.nomeAttivita}</td>
			<td>
				<fmt:formatDate value="${attivita.dataInizio}" pattern="dd/MM/yyyy"/>
			</td>
			<td>
				<fmt:formatDate value="${attivita.dataFine}" pattern="dd/MM/yyyy"/>
			</td>
			<td>
				<a href="${ctx}dipendente/${dipendente.idMatricola}/rimuoviAttivita?idAttivita=${attivita.idAttivita}">Rimuovi attivita</a>
			</td>
		</tr>
	</c:forEach>
</table>

<form action="${ctx}dipendente/${dipendente.idMatricola}/assegnaAttivita" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<select name="idAttivita">
		<option>---</option>
		<c:forEach items="${listaAttivita}" var="attivita">
			<option value="${attivita.idAttivita}">${attivita.nomeAttivita }</option>
		</c:forEach>
	</select>
	<input type="submit" value="Assegna">
</form>
</div>
</body>
</html>