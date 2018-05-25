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

	<h1>car Details</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${car.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Car brand</label>
		<div class="col-sm-10">${car.carBrand}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Car model</label>
		<div class="col-sm-10">${car.carModel}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Number of seats</label>
		<div class="col-sm-10">${car.numberOfSeats}</div>
	</div>

	<div class="row">
        <label class="col-sm-2">Price per day</label>
        <div class="col-sm-10">${car.pricePerDay}</div>
    </div>

	<div class="row">
        <label class="col-sm-2">Note</label>
        <div class="col-sm-10">${car.note}</div>
    </div>

</div>