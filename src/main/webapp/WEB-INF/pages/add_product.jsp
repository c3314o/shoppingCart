<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Inventory</title>
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
	/* overflow: auto */
}
}
</style>
</head>
<body>
	<script type="text/javascript">
		/* $(document).ready(function() {
			$('#category').bind('change', function() {
				var elements = $('div.container').children().hide(); // hide all the elements
				var value = $(this).val();

				if (value.length) { // if somethings' selected
					elements.filter('.' + value).show(); // show the ones we want
				}
			}).trigger('change');
		}); */

		/* 	function saveSuccess() {
				alert("Form has been submitted");
			} */
	</script>
	<jsp:include page="index.jsp"></jsp:include>
	<form:form action="saveProduct" method="post" commandName="productForm">
		<div class="generic-container" align="center">
			<div class="panel panel-default">
				<div class="panel-heading" align="center">
					<span class="lead">Add New Product</span>
				</div>
				<table class="table table-hover">
					<tr>
						<td>Product Name:</td>
						<td><form:input path="productName" /></td>
						<td><form:errors path="productName" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Category:</td>
						<td><form:select path="category" title="category"
								id="category">
								<form:option value="">--Select--</form:option>
								<form:options items="${listOfCategories}" />
							</form:select></td>
						<td><form:errors path="category" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Brand:</td>
						<td><form:select path="brand" title="brand">
								<form:option value="">--Select--</form:option>
								<form:options items="${listOfBrands}" />
							</form:select></td>
						<td><form:errors path="brand" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Color:</td>
						<td><form:select path="color" title="color">
								<form:option value="">--Select--</form:option>
								<form:options items="${listOfColors}" />
							</form:select></td>
						<td><form:errors path="color" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Model Number:</td>
						<td><form:input path="modelNumber" /></td>
						<td><form:errors path="modelNumber" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Price:</td>
						<td>Rs.<form:input path="price"
								onkeypress='return (event.charCode = 46 || event.charCode >= 48) && event.charCode <= 57' /></td>
						<td><form:errors path="price" cssClass="error" /> <form:hidden
								path="status" /> <form:hidden path="isActive" /> <form:hidden
								path="isInCart" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="action" value="Save Product" />
						<td><a href="<c:url value='/viewProduct' />">View All
								Products</a></td>
						<td><a href="<c:url value='/saveProduct' />">Clear </a></td>

					</tr>
					<%-- 	<tr>
					<c:if test="${not empty message}">
						<div class="msg">${message}</div>
					</c:if>
				</tr> --%>
				</table>
			</div>
		</div>
	</form:form>
</body>
</html>