<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<c:choose>
		<c:when test="${rentalForm['new']}">
			<h1>Add Rental</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit Rental</h1>
		</c:otherwise>
	</c:choose>
	<br />

<spring:url value="/customers/{customerId}/rentals" var="rentalsUrl" >
    <spring:param name="customerId" value="${customer.id}" />
</spring:url>
<!-- if omit form action it will go back to the same url (controller) but post method  -->
<form:form action="${rentalsUrl}" method="post" modelAttribute="rental"  class="form-horizontal" >
	<form:hidden path="id" />

    <!--This is for Cross-Site Request Forgery (CSRF) -->
    <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

    <div class="form-group">
        <form:label path="customer" class="col-sm-2">Customer</form:label>
        <form:label path="customer" class="col-sm-6">${rental.customer.firstName}  ${rental.customer.lastName}</form:label>
    </div>

	<div class="form-group">
		<form:label path="rentalDate" class="col-sm-2">Rental date</form:label>
		<div class="col-sm-6">
			<form:input path="rentalDate" class="form-control" />
		</div>
		<div class="col-sm-4">
			<span class="label label-danger"><form:errors path="rentalDate" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="days" class="col-sm-2">Days rented</form:label>
		<div class="col-sm-6">
			<form:input path="days"  class="form-control" />
		</div>
		<div class="col-sm-4">
			<span class="label label-danger"><form:errors path="days" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="vehicle" class="col-sm-2">Vehicle</form:label>
		<div class="col-sm-6">
			<form:select path="vehicle" class="form-control">
				<form:option value="-1" label="--- Select ---" />
				<form:options items="${vehicles}" itemValue="id" itemLabel="carModel" />
			</form:select>
			<form:errors path="vehicle" class="control-label" />
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
