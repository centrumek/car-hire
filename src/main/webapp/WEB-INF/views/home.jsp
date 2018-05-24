<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="container text-center">

	<security:authorize access="isAuthenticated()">
		<c:if test="${param.error == null}">
			<div class="alert alert-success">
				You have been succesfully logged in
			</div>
		</c:if>
	</security:authorize>

	<div class="row">
		<div class="col-md-12">
			<h1>Welcome to Rent-a-car</h1>
			<!--<form:form action="/login" method="GET">
				<p>Please login to use application</p>
				<button type="submit" class="btn btn-primary">
					Login
				</button>
			</form:form>-->
		</div>
	</div>
	<br>
</div>

