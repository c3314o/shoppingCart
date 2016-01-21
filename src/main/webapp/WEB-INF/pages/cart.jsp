<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory Page</title>

<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
	
</script>
<style>
table {
	border-collapse: collapse;
}

table, td, th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h:body>
		<form:form action="cart" method="post" commandName="cartForm">
			<h3 align="center">Cart Details</h3>
			<table align="center">
				<tbody>
					<c:forEach var="listValue" items="${listOfProducts}"
						varStatus="status">
						<tr>
							<td>${listValue.productName}</td>
							<td>${listValue.price}</td>
							<td><a
								href="<c:url value='/remove/${listValue.inventoryId}' />">Remove
									from Cart</a></td>
						</tr>
						<tr></tr>
					</c:forEach>
				</tbody>
			</table>
			<table align="center">
				<tr>
					<td colspan="2"><a href="<c:url value='/purchase' />">Purchase</a></td>
					<td colspan="2"><a href="<c:url value='/home' />">Continue
							Shopping</a></td>
				</tr>
			</table>
		</form:form>
	</h:body>
</body>
</html>