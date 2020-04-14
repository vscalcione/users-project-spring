<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
	<jsp:param name="active" value="users" />
</jsp:include>

<div class="container">

<c:url value="/users" var="backUrl" />
<a href="${backUrl}">Indietro</a> <br>
<hr>
<label>User id:</label> ${user.userId}<br>
<label>Username:</label> ${user.userName}<br>
<label>Password:</label> ${user.password}<br>
<label>Enabled:</label> ${user.enabled}<br>

<hr>

<dl>
	<dt>User id:</dt>
	<dd>${user.userId }</dd>

	<dt>Username:</dt>
	<dd>${user.userName }</dd>

	<dt>password:</dt>
	<dd>${user.password }</dd>

	<dt>Enabled:</dt>
	<dd>${user.enabled }</dd>
</dl>
</div>
</body>
</html>