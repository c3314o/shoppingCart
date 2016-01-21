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
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}

.msg {
	color: #31708f;
	font-weight: bold;
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

		function saveSuccess() {
			alert("Form has been submitted");
		}
	</script>
	<div align="center">
		<form:form action="saveProduct" method="post"
			commandName="productForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Add New Product</h2></td>
				</tr>
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
					<td><form:errors path="price" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:hidden path="status" /></td>
				</tr>
				<tr>
					<td><form:hidden path="isActive" /></td>
				</tr>
				<tr>
					<td><form:hidden path="isInCart" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="action" value="Save Product" />
				</tr>
				<%-- 	<tr>
					<c:if test="${not empty message}">
						<div class="msg">${message}</div>
					</c:if>
				</tr> --%>
			</table>
		</form:form>

		<form:form action="viewProduct" method="get">
			<table align="center">
				<tr>
					<td colspan="2"><a href="<c:url value='/viewProduct' />">View
							All Products</a></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>