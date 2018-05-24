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

    <h1>Users</h1>

    <spring:url value="/admin/users" var="usersUrl" />
    <form:form action="${usersUrl}" method="get" modelAttribute="user" class="navbar-form navbar-right" role="search">
      <div class="form-group">
        <input type="text" name="userName" class="form-control" placeholder="Search by userName"/>
      </div>
      <button type="submit" class="btn btn-default">Search</button>
    </form:form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>#ID</th>
                <th>UserName</th>
                <th>LastName</th>
                <th>FirstName</th>
                <th>Email</th>
                <th>Enabled</th>
            </tr>
        </thead>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                    ${user.id}
                </td>
                <td>${user.username}</td>
                <td>${user.lastName}</td>
                <td>${user.firstName}</td>
                <td>${user.email}</td>
                <td>${user.enabled}</td>

                <td>
                    <spring:url value="/admin/users/${user.id}" var="userUrl" />
                    <spring:url value="/admin/users/delete/${user.id}" var="deleteUrl" />
                    <spring:url value="/admin/users/edit/${user.id}" var="updateUrl" />

                    <button class="btn btn-info" onclick="location.href='${userUrl}'">View</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

	<div class="form-group">
	    <spring:url value="/admin/users/new" var="urlAddUser" />
		<div class="col-sm-10">
			<button class="btn btn-primary" onclick="location.href='${urlAddUser}'">Add new user</button>
		</div>
	</div>

</div>