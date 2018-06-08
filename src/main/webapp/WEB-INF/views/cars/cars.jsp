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

    <h1>All cars</h1>

    <spring:url value="/cars" var="carsUrl" />
    <form:form action="${carsUrl}" method="get" modelAttribute="car" class="navbar-form navbar-right" role="search">
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

        <c:forEach var="car" items="${cars}">
            <tr>
                <td>
                    ${car.id}
                </td>
                <td>${car.carBrand}</td>
                <td>${car.carModel}</td>
                <td>${car.numberOfSeats}</td>
                <td>${car.color}</td>
                <td>${car.pricePerDay}</td>
                <td>${car.note}</td>

                <td>
                    <spring:url value="/cars/${car.id}" var="carUrl" />
                    <spring:url value="/cars/delete/${car.id}" var="deleteUrl" />
                    <spring:url value="/cars/edit/${car.id}" var="updateUrl" />

                    <button class="btn btn-info" onclick="location.href='${carUrl}'">View</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

	<div class="form-group">
	    <spring:url value="/cars/new" var="urlAddcar" />
		<div class="col-sm-10">
			<button class="btn btn-primary" onclick="location.href='${urlAddcar}'">Add new car</button>
		</div>
	</div>

</div>
