<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

<spring:url value="/customers" var="customersUrl" />
<form:form action="${customersUrl}" method="post" modelAttribute="customer"  class="form-horizontal">
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
		<form:label path="phone" cssClass="col-sm-2">Phone</form:label>
		<div class="col-sm-6">
			<form:input path="phone"  cssClass="form-control" />
			<span class="label label-danger"><form:errors path="phone" /></span>
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
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">
				Save
			</button>
		</div>
	</div>
</form:form>

</div>
