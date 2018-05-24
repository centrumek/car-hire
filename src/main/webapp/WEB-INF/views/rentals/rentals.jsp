<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

    <h1>Rentals</h1>

    <spring:url value="/rentals" var="rentalsUrl" />
    <form:form action="${rentalsUrl}" method="get" modelAttribute="rental" class="navbar-form navbar-right" role="search">
      <div class="form-group">
          <input type="text" name="rentalDate" value="${rentalDate}" class="form-control" placeholder="Enter date(empy=all)"/>
      </div>
      <button type="submit" class="btn btn-default">Search</button>
    </form:form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>#ID</th>
                <th>Date</th>
                <th>Customer</th>
                <th>Vehicle</th>
                <th>Days rented</th>
                <th>Price</th>
                <th>Note</th>
            </tr>
        </thead>

        <c:forEach var="rental" items="${rentals}">
            <tr>
                <td>
                    ${rental.id}
                </td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${rental.rentalDate}" /></td>
                <td>${rental.customer.lastName}</td>
                <td>${rental.vehicle.carBrand} ${rental.vehicle.carModel}</td>
                <td>${rental.days}</td>
                <td>${rental.days * rental.vehicle.pricePerDay}</td>
                <td>${rental.note}</td>

                <td>
                    <spring:url value="/customers/${rental.customer.id}" var="viewUrl" />
                    <spring:url value="/customers/${rental.customer.id}/rentals/edit/${rental.id}" var="updateUrl" />
                    <spring:url value="/rentals/delete/${rental.id}" var="deleteUrl" />

                    <button class="btn btn-info" onclick="location.href='${viewUrl}'">View</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
