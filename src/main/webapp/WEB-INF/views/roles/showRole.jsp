<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Role Details</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${role.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Role</label>
		<div class="col-sm-10">${role.name}</div>
	</div>

	<br>
	<div class="well well-sm">
		<a href="<c:url value='/admin/roles' />">Go to roles list</a>
	</div>

</div>