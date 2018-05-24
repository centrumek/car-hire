<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Rental Details</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">ID</label>
        <div class="col-sm-10">${rental.id}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Rental date</label>
        <div class="col-sm-10">${rental.rentalDate}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Customer</label>
        <div class="col-sm-10">${rental.customer.lastName} ${rental.customer.firstName}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Vehicle</label>
        <div class="col-sm-10">${rental.vehicle.carBrand} ${rental.vehicle.carModel}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Days</label>
        <div class="col-sm-10">${rental.days}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Note</label>
        <div class="col-sm-10">${rental.note}</div>
    </div>

</div>