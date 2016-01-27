<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<!-- <link rel="stylesheet" href="../css/home.css"> -->
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
	margin-left: 700px;
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
	<jsp:include page="index.jsp"></jsp:include>
	<div align="center">
		<form:form action="register" method="post" commandName="userForm">
			<div class="generic-container" align="center">
				<div class="panel panel-default">
					<div class="panel-heading" align="center">
						<span class="lead">Sign Up</span>
					</div>
					<table class="table table-hover">
						<tr>
							<td>First Name:</td>
							<td><form:input path="user.firstname" /></td>
							<td><form:errors path="user.firstname" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Last Name:</td>
							<td><form:input path="user.lastname" /></td>
							<td><form:errors path="user.lastname" cssClass="error" /></td>
						</tr>
						<tr>
							<td>User Name:</td>
							<td><form:input path="user.username" /></td>
							<td><form:errors path="user.username" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><form:password path="user.password" /></td>
							<td><form:errors path="user.password" cssClass="error" />
								<form:hidden path="user.enabled" /></td>
						</tr>
						<tr>
							<td>Address Line 1:</td>
							<td><form:input path="address.addressLine1" /></td>
							<td><form:errors path="address.addressLine1"
									cssClass="error" /></td>
						</tr>
						<tr>
							<td>Address Line 2:</td>
							<td><form:input path="address.addressLine2" /></td>
							<td><form:errors path="address.addressLine2"
									cssClass="error" /></td>
						</tr>
						<tr>
							<td>City:</td>
							<td><form:input path="address.city" /></td>
							<td><form:errors path="address.city" cssClass="error" /></td>
						</tr>
						<tr>
							<td>State:</td>
							<td><form:input path="address.stateCode" /></td>
							<td><form:errors path="address.stateCode" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Zip Code:</td>
							<td><form:input path="address.zipCode"
									onkeypress='return (event.charCode >= 48 && event.charCode <= 57)' /></td>
							<td><form:errors path="address.zipCode" cssClass="error" />
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								name="action" value="Sign Up" /></td>
							<td><a href="<c:url value='/login' />">Back to Login
									Page</a></td>
						</tr>
					</table>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>