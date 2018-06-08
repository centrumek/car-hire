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

    <h1>Hires</h1>

    <spring:url value="/hires" var="hiresUrl" />
    <form:form action="${hiresUrl}" method="get" modelAttribute="hire" class="navbar-form navbar-right" role="search">
      <div class="form-group">
          <input type="text" name="hireDate" value="${hireDate}" class="form-control" placeholder="Enter date(empy=all)"/>
      </div>
      <button type="submit" class="btn btn-default">Search</button>
    </form:form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>#ID</th>
                <th>Hire Date</th>
                <th>Customer</th>
                <th>Car</th>
                <th>Return Date</th>
                <th>Price</th>
                <th>Note</th>
            </tr>
        </thead>

        <c:forEach var="hire" items="${hires}">
            <tr>
                <td>
                    ${hire.id}
                </td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${hire.hireDate}" /></td>
                <td>${hire.customer.lastName}</td>
                <td>${hire.car.carBrand} ${hire.car.carModel}</td>
                <td>${hire.returnDate}</td>
                <td>${4 * hire.car.pricePerDay}</td>
                <td>${hire.note}</td>

                <td>
                    <spring:url value="/customers/${hire.customer.id}" var="viewUrl" />
                    <spring:url value="/customers/${hire.customer.id}/hires/edit/${hire.id}" var="updateUrl" />
                    <spring:url value="/hires/delete/${hire.id}" var="deleteUrl" />

                    <button class="btn btn-info" onclick="location.href='${viewUrl}'">View</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

