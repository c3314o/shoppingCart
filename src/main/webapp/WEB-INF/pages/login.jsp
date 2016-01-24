<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Login Page</title>
<!-- <link rel="stylesheet" href="../css/home.css"> -->
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

.generic-container {
	position: fixed;
	width: 35%;
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
</style>
</head>
<body onload='document.f.j_username.focus();'>

	<jsp:include page="index.jsp"></jsp:include>
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
		<div class="generic-container" align="center">
			<div class="panel panel-default">
				<div class="panel-heading" align="center">
					<span class="lead">Sign In</span>
				</div>
				<table class="table table-hover">
					<tr>
						<td>User:</td>
						<td><input type='text' name='j_username' value=''></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='j_password' /></td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit"
							value="submit" /></td>
						<td colspan='2'><a href="<c:url value='/register' />">Sign
								Up</a></td>
					</tr>
				</table>
				<c:if test="${not empty error}">
					<div class="errorblock">Username or Password is incorrect</div>
				</c:if>
			</div>
		</div>
	</form>
</body>
</html>