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

    <h1>All Roles</h1>

    <spring:url value="/roles" var="rolesUrl" />
    <form:form action="${rolesUrl}" method="get" modelAttribute="role" class="navbar-form navbar-right" role="search">
      <div class="form-group">
        <input type="text" name="carModel" value="${carModel}" class="form-control" placeholder="Search by car model"/>
      </div>
      <button type="submit" class="btn btn-default">Search</button>
    </form:form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>#ID</th>
                <th>Role</th>
            </tr>
        </thead>

        <c:forEach var="role" items="${roles}">
            <tr>
                <td>
                    ${role.id}
                </td>
                <td>${role.name}</td>

                <td>
                    <spring:url value="/admin/roles/delete/${role.id}" var="deleteUrl" />
                    <spring:url value="/admin/roles/edit/${role.id}" var="updateUrl" />

                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

	<div class="form-group">
	    <spring:url value="/admin/roles/new" var="urlAddRole" />
		<div class="col-sm-10">
			<button class="btn btn-primary" onclick="location.href='${urlAddRole}'">Add new role</button>
		</div>
	</div>

</div>
