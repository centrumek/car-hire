<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

<spring:url value="/admin/users" var="usersUrl" />
<form:form action="${usersUrl}" method="post" modelAttribute="user"  class="form-horizontal">
	<form:hidden path="id" />

	<div class="form-group">
		<form:label path="firstName" cssClass="col-sm-2">First Name</form:label>
		<div class="col-sm-6">
			<form:input path="firstName" cssClass="form-control" />
			<!-- da ispise gresku kod validacije -->
			<span class="label label-danger"><form:errors path="firstName" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="lastName" cssClass="col-sm-2">Last Name</form:label>
		<div class="col-sm-6">
			<form:input path="lastName"  cssClass="form-control" />
			<span class="label label-danger"><form:errors path="lastName" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="username" cssClass="col-sm-2">Username</form:label>
		<div class="col-sm-6">
			<form:input path="username"  cssClass="form-control" />
			<span class="label label-danger"><form:errors path="username" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="password" cssClass="col-sm-2">Password</form:label>
		<div class="col-sm-6">
			<form:input type="password" path="password" cssClass="form-control" />
			<span class="label label-danger"><form:errors path="password" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="email" cssClass="col-sm-2">Email</form:label>
		<div class="col-sm-6">
			<form:input path="email"  cssClass="form-control" />
			<span class="label label-danger"><form:errors path="email" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="roles" cssClass="col-sm-2">Role</form:label>
		<div class="col-sm-6">
			<form:select path="roles" items="${roles}" multiple="true" itemValue="id" itemLabel="name"/>
			<span class="label label-danger"><form:errors path="enabled" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="enabled" cssClass="col-sm-2">Enabled</form:label>
		<div class="col-sm-6" align="left">
			<form:checkbox path="enabled"  cssClass="form-control" />
			<span class="label label-danger"><form:errors path="enabled" /></span>
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
