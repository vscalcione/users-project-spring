<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="${ctx}">UM&trade;</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item ${(param.active ne 'users')?'active':''}">
				<a class="nav-link" href="${ctx}users">
					Users
					<span class="sr-only">(current)</span>
				</a>
			</li>
			<li class="nav-item ${(param.active ne 'groups')?'active':''}">
				<a class="nav-link" href="${ctx}groups">
					Groups
					<span class="sr-only">(current)</span>
				</a>
			</li>
			<li class="nav-item ${(param.active ne 'authorities')?'active':''}">
				<a class="nav-link" href="${ctx}authorities">
					Authorities
					<span class="sr-only">(current)</span>
				</a>
			</li>
		</ul>
			<a href="${ctx}logout" class="btn btn-success btn-sm">Logout</a>
	</div>
</nav>