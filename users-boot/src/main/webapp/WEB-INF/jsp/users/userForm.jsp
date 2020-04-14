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
<c:choose>
	<c:when test="${not empty user.userId}">
		<c:url value="/users/${user.userId}/edit" var="saveUrl" />
	</c:when>
	<c:otherwise>
		<c:url value="/users/new" var="saveUrl" />
	</c:otherwise>
</c:choose>

<form action="${saveUrl}" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<c:if test="${not empty user.userId}">
		<label>User id:</label> ${user.userId}<br>
		<input type="hidden" name="userId" value="${user.userId}">
	</c:if>
	<label>Username:</label>
		<input type="text" name="userName" value="${user.userName}"> <br>
	<label>Password:</label>
		<input type="password" name="password" value="${user.password}"> <br>
	<label>Enabled:</label>
		<input type="checkbox" name="enabled" ${user.enabled?'checked':''} value="true"> <br>

	<input type="reset" value="Cancella"> <input type="submit" value="Salva">
</form>

<c:if test="${not empty user.userId}">
	<hr>
	<c:if test="${not empty userAuthorities}">
		<table>
			<tr>
				<th>Authority</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${userAuthorities}" var="userAuthority">
				<tr>
					<td>${userAuthority.authority}</td>
					<td>${userAuthority.description}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:url value="/users/${user.userId}/addAuthority" var="addAuthorityUrl" />
	<form action="${addAuthorityUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="hidden" name="userName" value="${user.userName}">
 		<select name="authority">
			<option>---</option>
			<c:forEach items="${authorities}" var="authority">
				<option value="${authority.authority}">${authority.description}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Aggiungi">
	</form>
</c:if>
</div>
</body>
</html>