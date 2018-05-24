<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="panel panel-primary">

    <div class="panel-heading">
        <h3 class="panel-title">Please login</h3>
    </div>

    <div class="panel-body">

        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                You have been logged out
            </div>
        </c:if>

        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                Failed to login.
                <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                    Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                </c:if>
            </div>
        </c:if>

        <form:form role="form" >
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" type="text" class="form-control" placeholder="Enter username" />
                <!--<p class="help-block">Enter your username.</p>-->
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" type="password" class="form-control" placeholder="Password" />
            </div>

            <button type="submit" class="btn btn-primary center-block">Login</button>
        </form:form>
    </div>
  </div>
</div>
</div>