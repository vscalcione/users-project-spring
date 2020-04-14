<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
	<jsp:param name="active" value="groups" />
</jsp:include>

<div class="container">

<c:url value="/groups" var="backUrl" />
<a href="${backUrl}">Indietro</a> <br>
<hr>
<label>Group Name:</label> ${group.groupName}<br>
<label>Description:</label> ${group.description}<br>

</div>
</body>
</html>