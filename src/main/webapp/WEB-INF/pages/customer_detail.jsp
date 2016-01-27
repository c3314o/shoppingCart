<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}

.msg {
	color: #31708f;
	font-weight: bold;
}

.generic-container {
	position: fixed;
	width: 45%;
	margin-left: 500px;
	margin-top: 100px;
	margin-bottom: 20px;
	padding: 20px;
	background-color: #EAE7E7;
	border: 1px solid #ddd;
	border-radius: 4px;
	box-shadow: 0 0 30px black;
	margin-bottom: 20px;
	margin-left: 200px;
}
}
</style>
</head>
<body>
	<div align="center">
		<div class="generic-container" align="center">
			<div class="panel panel-default">
				<div class="panel-heading" align="center">
					<span class="lead">Profile Details</span>
				</div>
				<table class="table table-hover">
					<tr>
						<td>First Name:</td>
						<td>${userForm.user.firstname}</td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td>${userForm.user.lastname}</td>
					</tr>
					<tr>
						<td>User Name:</td>
						<td>${userForm.user.username}</td>
					</tr>

					<tr>
						<td>Address Line 1:</td>
						<td>${userForm.address.addressLine1}</td>
					</tr>
					<tr>
						<td>Address Line 2:</td>
						<td>${userForm.address.addressLine2}</td>
					</tr>
					<tr>
						<td>City:</td>
						<td>${userForm.address.city}</td>
					</tr>
					<tr>
						<td>State:</td>
						<td>${userForm.address.stateCode}</td>
					</tr>
					<tr>
						<td>Zip Code:</td>
						<td>${userForm.address.zipCode}</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="container">
								Thank you for registering!!! <a href="<c:url value='/login' />">Click
									to Log In</a>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>