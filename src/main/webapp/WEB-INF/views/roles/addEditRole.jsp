<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">

	<c:choose>
		<c:when test="${role['new']}">
			<h1>Add Role</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit Role</h1>
		</c:otherwise>
	</c:choose>
	<br />

<spring:url value="/admin/roles" var="rolesUrl" />
<form:form action="${rolesUrl}" method="post" modelAttribute="role"  class="form-horizontal">
	<form:hidden path="id" />

	<div class="form-group">
		<form:label path="name" cssClass="col-sm-2">
			Role
		</form:label>
		<div class="col-sm-6">
			<form:input path="name" cssClass="form-control" />
		</div>
		<div class="col-sm-4">
			<span class="label label-danger"><form:errors path="name" /></span>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">
				Save
			</button>
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<button type="cancel" class="btn btn-primary">
				Cancel
			</button>
		</div>
	</div>
</form:form>

</div>
