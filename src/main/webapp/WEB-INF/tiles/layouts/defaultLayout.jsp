<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML>

<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap -->
	<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
</head>

<body>
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>

        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>

        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
              <script src = "https://code.jquery.com/jquery.js"></script>

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src = "/resources/js/bootstrap.min.js"></script>
</body>
</html>