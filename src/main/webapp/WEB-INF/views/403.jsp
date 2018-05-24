<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<div class="container text-center">
    <div class="alert-danger">
          <h3>You do not have permission to access this page!</h3>
          <br>
    </div>
    <br>

    <form:form action="/logout" method="post">
          <input type="submit" value="Sign in as different user" />
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form:form> 
    <br>
</div>