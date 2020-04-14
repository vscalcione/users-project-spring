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


<table class="table">
	<tr>
		<th>Authority</th> <th>Description</th>
		<th>
			<a href="${ctx}authorities/new" class="btn btn-success btn-sm">
				Crea nuova Authority
			</a>
		</th>
	</tr>

	<c:forEach items="${authorityList}" var="authority">
		<tr>
			<td>
				<a href="${ctx}authorities/${authority.authority}" class="btn btn-primary btn-sm">
					${authority.authority}
				</a>
			</td>
			<td>${authority.description}</td>
			<td>
				<a href="${ctx}authorities/${authority.authority}/edit" class="btn btn-warning btn-sm">Modifica</a>
				<a href="${ctx}authorities/${authority.authority}/delete" class="btn btn-danger btn-sm" onclick="return confirm('Vuoi eliminare?');">Elimina</a>
			</td>
		</tr>
	</c:forEach>
</table>

</div>
</body>
</html>