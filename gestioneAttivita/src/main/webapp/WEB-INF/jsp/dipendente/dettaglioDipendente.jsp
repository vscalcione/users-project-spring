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

<label>ID:</label> ${dipendente.idMatricola}<br>
<label>Cognome:</label> ${dipendente.cognome}<br>
<label>Nome:</label> ${dipendente.nome}<br>

</div>
</body>
</html>