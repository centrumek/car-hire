<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate value="${now}" type="date" pattern="dd/MM/yyyy" var="fmtNow" />

<spring:url value="/" var="urlHome" />
<spring:url value="/rentals?rentalDate=${fmtNow}" var="urlRentals" />
<spring:url value="/customers" var="urlCustomers" />
<spring:url value="/vehicles" var="urlVehicles" />
<spring:url value="/admin/users" var="urlUsers" />
<spring:url value="/admin/roles" var="urlRoles" />


<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Rent-a-car</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${urlHome}">Home</a></li>
				<li><a href="${urlCustomers}">Customers</a></li>
				<li><a href="${urlRentals}">Rentals</a></li>
				<li><a href="${urlVehicles}">Vehicles</a></li>
				<security:authorize access="hasRole('ADMIN')">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" >Administration <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${urlUsers}">Users</a></li>
							<li><a href="${urlRoles}">Roles</a></li>
						</ul>
					</li>
				</security:authorize>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li><a href="<c:url value='/login' />">
						<span class="glyphicon glyphicon-log-in"></span> Log In
					</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						   role="button" aria-haspopup="true" aria-expanded="false">
							<span class="glyphicon glyphicon-user"></span>
								<security:authentication property="principal.name" />
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<c:url var="logoutUrl" value="/logout" />
								<form:form	id="logoutForm" action="${logoutUrl}"></form:form>
								<a href="#" onclick="document.getElementById('logoutForm').submit()">
									<span class="glyphicon glyphicon-log-out"></span> Logout
								</a>
							</li>
							<security:authentication property="principal.id" var="userid" />
							<li><a href="/password/edit/${userid}">Change password</a></li>
							<li><a href="/password">User details</a></li>
						</ul>
					</li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>
