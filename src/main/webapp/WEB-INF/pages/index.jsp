<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Fabulosa Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<form:form >
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Fabulosa</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="<c:url value='/home' />">Home</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Inventory <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/saveProduct' />">Add New
									Product</a></li>
							<li><a href="<c:url value='/viewProduct' />">View All
									Product</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">My Account <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/home' />">Update Profile</a></li>
							<li><a href="#">Order Details</a></li>
						</ul></li>
					<li><a href="<c:url value='/cart' />">Cart</a></li>
				</ul>
			</div>
		</nav>
		<div class="container">
			<h3>Welcome to Fabulosa,</h3>
			<!-- 	<p>The real trouble with reality is that there's no background
				music.</p> -->
		</div>
	</form:form>
</body>
</html>
