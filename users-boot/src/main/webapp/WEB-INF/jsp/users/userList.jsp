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

<script type="text/javascript">
	function loadUsers() {
		$.get('/users-web/api/users', function(result) {
			var message = '';
			result.forEach(function(dto) {
				message += dto.userId+' '+dto.userName + '<br>';
			});
			$('#risultato').html(message);
// 			setTimeout(loadUsers, 1000);
		});
	}

	function checkCount() {
		$.get('/users-web/api/users/count', function(result) {
			$('#count').text(result);
// 			setTimeout(checkCount, 1000);
		});
	}



	$(function() {
		loadUsers();
		checkCount();
	});



</script>

<c:url value="/users/new" var="newUserUrl" />
<a href="${newUserUrl}">Crea nuovo utente</a>
<table class="table">
	<tr>
		<th>User id</th> <th>Username</th> <th>password</th> <th>Enabled</th>
		<th></th>
	</tr>

	<c:forEach items="${userList}" var="user">
		<c:url value="/users/${user.userId}" var="userDetailUrl" />
		<c:url value="/users/${user.userId}/edit" var="userEditUrl" />
		<c:url value="/users/${user.userId}/delete" var="userDeleteUrl" />
		<tr>
			<td>
				<a href="${userDetailUrl}">
					${user.userId}
				</a>
			</td>
			<td>${user.userName }</td>
			<td>${user.password }</td>
			<td>${user.enabled }</td>
			<td>
				<a href="${userEditUrl}">Modifica</a> |
				<a href="${userDeleteUrl}" onclick="return confirm('Vuoi eliminare?');">Elimina</a>
			</td>
		</tr>
	</c:forEach>
</table>

	<div id="risultato">
	</div>
	<div id="count">
	</div>
</div>
</body>
</html>