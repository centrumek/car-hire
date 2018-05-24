<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">

	<c:choose>
		<c:when test="${vehicle['new']}">
			<h1>Add Vehicle</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit Vehicle</h1>
		</c:otherwise>
	</c:choose>
	<br />

<spring:url value="/vehicles" var="vehiclesUrl" />
<form:form action="${vehiclesUrl}" method="post" modelAttribute="vehicle"  class="form-horizontal">
	<form:hidden path="id" />

	<div class="form-group">
		<form:label path="carBrand" cssClass="col-sm-2">
			Car brand
		</form:label>
		<div class="col-sm-6">
			<form:input path="carBrand" cssClass="form-control" />
		</div>
		<div class="col-sm-4">
			<span class="label label-danger"><form:errors path="carBrand" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="carModel" cssClass="col-sm-2">
			Car model
		</form:label>
		<div class="col-sm-6">
			<form:input path="carModel"  cssClass="form-control" />
		</div>
		<div class="col-sm-4">
			<!-- ovde da ispise gresku kod validacije -->
			<span class="label label-danger"><form:errors path="carModel" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="numberOfSeats" cssClass="col-sm-2">
			Number of seats
		</form:label>
		<div class="col-sm-6">
			<form:input path="numberOfSeats"  cssClass="form-control" />
		</div>
		<div class="col-sm-4">
			<!-- ovde da ispise gresku kod validacije -->
			<span class="label label-danger"><form:errors path="numberOfSeats" /></span>
		</div>
	</div>

	<div class="form-group">
		<form:label path="color" cssClass="col-sm-2">
			Color
		</form:label>
		<div class="col-sm-6">
			<form:input path="color"  cssClass="form-control" />
		</div>
		<div class="col-sm-4">
			<!-- ovde da ispise gresku kod validacije -->
			<span class="label label-danger"><form:errors path="color" /></span>
		</div>
	</div>

    <div class="form-group">
        <form:label path="pricePerDay" cssClass="col-sm-2">
            Price/Day
        </form:label>
        <div class="col-sm-6">
            <form:input path="pricePerDay"  cssClass="form-control" />
        </div>
        <div class="col-sm-4">
            <!-- ovde da ispise gresku kod validacije -->
            <span class="label label-danger"><form:errors path="pricePerDay" /></span>
        </div>
    </div>

    <div class="form-group">
        <form:label path="note" cssClass="col-sm-2">
            Note/Description
        </form:label>
        <div class="col-sm-6">
            <form:textarea path="note" rows="5" class="form-control" id="note" />
        </div>
        <div class="col-sm-4">
            <!-- ovde da ispise gresku kod validacije -->
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
