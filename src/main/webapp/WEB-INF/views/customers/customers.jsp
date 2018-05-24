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

    <h1>Customers</h1>

    <spring:url value="/customers" var="customersUrl" />
    <form:form action="${customersUrl}" method="get" modelAttribute="customer" class="navbar-form navbar-right" role="search">
      <div class="form-group">
        <input type="text" name="lastName" class="form-control" placeholder="Search by last name"/>
        <input type="text" name="firstName" class="form-control" placeholder="Search by first name"/>
      </div>
      <button type="submit" class="btn btn-default">Search</button>
    </form:form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>#ID</th>
                <th>LastName</th>
                <th>FirstName</th>
                <th>Phone</th>
                <th>Email</th>
            </tr>
        </thead>

        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>
                    ${customer.id}
                </td>
                <td>${customer.lastName}</td>
                <td>${customer.firstName}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>

                <td>
                    <spring:url value="/customers/${customer.id}" var="customerUrl" />
                    <spring:url value="/customers/delete/${customer.id}" var="deleteUrl" />
                    <spring:url value="/customers/edit/${customer.id}" var="updateUrl" />

                    <button class="btn btn-info" onclick="location.href='${customerUrl}'">View</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

	<div class="form-group">
	    <spring:url value="/customers/new" var="urlAddCustomer" />
		<div class="col-sm-10">
			<button class="btn btn-primary" onclick="location.href='${urlAddCustomer}'">Add new customer</button>
		</div>
	</div>

</div>