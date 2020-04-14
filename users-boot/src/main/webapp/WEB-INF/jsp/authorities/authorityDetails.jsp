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
<label>Authority:</label> ${authority.authority}<br>
<label>Description:</label> ${authority.description}<br>

</div>
</body>
</html>