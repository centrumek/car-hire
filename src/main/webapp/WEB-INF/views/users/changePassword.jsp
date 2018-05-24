<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="container">

	<h1>Change password</h1>


	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<div class="row">
		<label class="col-sm-2">Username</label>
		<div class="col-sm-10"><security:authentication property="principal.username" /></div>
	</div>

	<div class="row">
		<label class="col-sm-2">Full name</label>
		<div class="col-sm-10"><security:authentication property="principal.name" /></div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10"><security:authentication property="principal.email" /></div>
	</div>

	<spring:url value="/password" var="passwordUrl" />
	<form:form action="${passwordUrl}" method="post" modelAttribute="password"  class="form-horizontal">
		<div class="form-group">
			<form:label path="password" cssClass="col-sm-2">Password</form:label>
			<div class="col-sm-6">
				<form:input type="password" path="password" cssClass="form-control" />
				<span class="label label-danger"><form:errors path="password" /></span>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">
					Save
				</button>
			</div>
		</div>
	</form:form>

</div>
