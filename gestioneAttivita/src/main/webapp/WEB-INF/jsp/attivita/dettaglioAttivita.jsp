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

<label>ID:</label> ${attivita.idAttivita}<br>
<label>Attivit&agrave;:</label> ${attivita.nomeAttivita}<br>
<label>Data inizio:</label> <fmt:formatDate value="${attivita.dataInizio}" pattern="dd/MM/yyyy"/><br>
<label>Data fine:</label> <fmt:formatDate value="${attivita.dataFine}" pattern="dd/MM/yyyy"/><br>

</div>
</body>
</html>