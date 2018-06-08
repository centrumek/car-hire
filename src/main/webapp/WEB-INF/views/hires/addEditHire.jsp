<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<c:choose>
		<c:when test="${hireForm['new']}">
			<h1>Add Hire</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit Hire</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/customers/{customerId}/hires" var="hiresUrl" >
		<spring:param name="customerId" value="${customer.id}" />
	</spring:url>

	<form:form action="${hiresUrl}" method="post" modelAttribute="hire"  class="form-horizontal" name="hireForm">
		<form:hidden path="id" />

		<div class="form-group">
			<form:label path="customer" class="col-sm-2">Customer</form:label>
			<form:label path="customer" class="col-sm-6">${hire.customer.firstName}  ${hire.customer.lastName}</form:label>
		</div>

		<div class="form-group">
			<form:label path="hireDate" class="col-sm-2">Hire date</form:label>
			<div class="col-sm-6">
				<form:input path="hireDate" type="date" class="form-control" />
			</div>
			<div class="col-sm-4">
				<span class="label label-danger"><form:errors path="hireDate" /></span>
			</div>
		</div>

		<div class="form-group">
			<form:label path="returnDate" class="col-sm-2">Return date</form:label>
			<div class="col-sm-6">
				<form:input path="returnDate" type="date" class="form-control" />
			</div>
			<div class="col-sm-4">
				<span class="label label-danger"><form:errors path="returnDate" /></span>
			</div>
		</div>

		<div class="form-group">
			<form:label path="car" class="col-sm-2">Car</form:label>
			<div class="col-sm-6">
				<form:select path="car" class="form-control">
					<form:option value="-1" label="--- Select ---" />
					<form:options items="${cars}" itemValue="id" itemLabel="carModel" />
				</form:select>
				<form:errors path="car" class="control-label" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="note" class="col-sm-2">Note/Description</form:label>
			<div class="col-sm-6">
				<form:textarea path="note" rows="5" class="form-control" id="note" />
			</div>
			<div class="col-sm-4">
				<span class="label label-danger"><form:errors path="note" /></span>
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