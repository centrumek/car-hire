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

    <h1>Hire Details</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">ID</label>
        <div class="col-sm-10">${hire.id}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Hire date</label>
        <div class="col-sm-10">${hire.hireDate}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Customer</label>
        <div class="col-sm-10">${hire.customer.lastName} ${hire.customer.firstName}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Car</label>
        <div class="col-sm-10">${hire.car.carBrand} ${hire.car.carModel}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Return Date</label>
        <div class="col-sm-10">${hire.returnDate}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Note</label>
        <div class="col-sm-10">${hire.note}</div>
    </div>

</div>