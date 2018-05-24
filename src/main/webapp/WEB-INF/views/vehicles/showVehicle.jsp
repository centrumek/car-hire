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

	<h1>Vehicle Details</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${vehicle.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Car brand</label>
		<div class="col-sm-10">${vehicle.carBrand}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Car model</label>
		<div class="col-sm-10">${vehicle.carModel}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Number of seats</label>
		<div class="col-sm-10">${vehicle.numberOfSeats}</div>
	</div>

	<div class="row">
        <label class="col-sm-2">Price per day</label>
        <div class="col-sm-10">${vehicle.pricePerDay}</div>
    </div>

	<div class="row">
        <label class="col-sm-2">Note</label>
        <div class="col-sm-10">${vehicle.note}</div>
    </div>

</div>