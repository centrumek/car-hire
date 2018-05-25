<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

	<h1>Customer Details</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${customer.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">First name</label>
		<div class="col-sm-10">${customer.firstName}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Last name</label>
		<div class="col-sm-10">${customer.lastName}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Phone</label>
		<div class="col-sm-10">${customer.phone}</div>
	</div>

    <div class="row">
        <label class="col-sm-2">Email</label>
        <div class="col-sm-10">${customer.email}</div>
    </div>

    <hr>

    <spring:url value="/customers/edit/${customer.id}" var="updateCustomerUrl" />
    <button class="btn btn-primary" onclick="location.href='${updateCustomerUrl}'">Edit customer</button>

    <spring:url value="/customers/{customerId}/hires/new" var="urlAddHire">
        <spring:param name="customerId" value="${customer.id}"/>
    </spring:url>

    <button class="btn btn-primary" onclick="location.href='${urlAddHire}' + getHireAndReturnDate()">Add new hire</button>

    <input type="date" id="hireDate"/>
    <input type="date" id="returnDate"/>

    <script type="text/javascript">
        function getHireAndReturnDate() {
            var hireDate = document.getElementById("hireDate").value;
            var returnDate = document.getElementById("returnDate").value;
            return "?hireDate="+hireDate+"&returnDate="+returnDate;
        }
    </script>

    <br/>
    <h2>Hires</h2>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>Hire Date</th>
                <th>Vehicle</th>
                <th>Return Date</th>
                <th>Price</th>
                <th>Total</th>
                <th>Note</th>
            </tr>
        </thead>

        <c:forEach var="hire" items="${customer.hires}">
            <tr>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${hire.hireDate}" /></td>
                <td>${hire.vehicle.carBrand} ${hire.vehicle.carModel}</td>
                <td>${hire.returnDate}</td>
                <td>${hire.vehicle.pricePerDay}</td>
                <%--<td>${(hire.returnDate - hire.hireDate) * hire.vehicle.pricePerDay}</td>--%>
                <td>${hire.note}</td>
                <td>
                    <spring:url value="/customers/${customer.id}/hires/${hire.id}" var="hireUrl"/>
                    <spring:url value="/customers/${customer.id}/hires/edit/${hire.id}" var="updateUrl" />
                    <spring:url value="/customers/${customer.id}/hires/delete/${hire.id}" var="deleteUrl" />

                    <button class="btn btn-info" onclick="location.href='${hireUrl}'">View</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
