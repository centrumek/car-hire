<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>All Vehicles</h1>

    <spring:url value="/vehicles" var="vehiclesUrl" />
    <form:form action="${vehiclesUrl}" method="get" modelAttribute="vehicle" class="navbar-form navbar-right" role="search">
      <div class="form-group">
        <input type="text" name="carModel" value="${carModel}" class="form-control" placeholder="Search by car model"/>
      </div>
      <button type="submit" class="btn btn-default">Search</button>
    </form:form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>#ID</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Number of seats</th>
                <th>Color</th>
                <th>Price/Day</th>
                <th>Note</th>
            </tr>
        </thead>

        <c:forEach var="vehicle" items="${vehicles}">
            <tr>
                <td>
                    ${vehicle.id}
                </td>
                <td>${vehicle.carBrand}</td>
                <td>${vehicle.carModel}</td>
                <td>${vehicle.numberOfSeats}</td>
                <td>${vehicle.color}</td>
                <td>${vehicle.pricePerDay}</td>
                <td>${vehicle.note}</td>

                <td>
                    <spring:url value="/vehicles/${vehicle.id}" var="vehicleUrl" />
                    <spring:url value="/vehicles/delete/${vehicle.id}" var="deleteUrl" />
                    <spring:url value="/vehicles/edit/${vehicle.id}" var="updateUrl" />

                    <button class="btn btn-info" onclick="location.href='${vehicleUrl}'">View</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

	<div class="form-group">
	    <spring:url value="/vehicles/new" var="urlAddVehicle" />
		<div class="col-sm-10">
			<button class="btn btn-primary" onclick="location.href='${urlAddVehicle}'">Add new vehicle</button>
		</div>
	</div>

</div>
