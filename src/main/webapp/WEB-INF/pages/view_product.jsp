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
<!-- <link rel="stylesheet" href="../css/home.css"> -->
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
	/* $(function() {
		var availableTutorials = [ "ActionScript", "Boostrap", "C", "C++",
				"Ecommerce", "Jquery", "Groovy", "Java", "JavaScript", "Lua",
				"Perl", "Ruby", "Scala", "Swing", "XHTML" ];
		$("#automplete-3").autocomplete({
			minLength : 2,
			delay : 100,
			source : '${pageContext.request.contextPath}/searchList'
		});
	}); */
});
</script>
<style type="text/css">
.generic-container {
	position: fixed;
	width: 80%;
	margin-left: 200px;
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

.search-container {
	position: fixed;
	width: 15%;
	margin-top: 100px;
	margin-left: 1250px;
	margin-bottom: 20px;
	padding: 2px;
	background-color: #EAE7E7 !important;
	border: 1px solid #ddd !important;
	border-radius: 4px;
	box-shadow: 0 0 30px black;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<h:body>
		<form:form action="viewProduct" method="get">
		<!-- 	<div class="search-container">
				<label for="automplete-3">Search: </label> <input id="automplete-3">
			</div> -->
			<div class="generic-container">
				<div class="panel panel-default"
					style="height: 500px; overflow-y: auto;">
					<div class="panel-heading" align="center">
						<span class="lead">View Product Details</span>
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product Name</th>
								<th>Category</th>
								<th>Brand</th>
								<th>Color</th>
								<th>Price</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listValue" items="${listOfProducts}"
								varStatus="status">
								<tr id="listId${status.index}">
									<td>${listValue.productName}</td>
									<td>${listValue.category}</td>
									<td>${listValue.brand}</td>
									<td>${listValue.color}</td>
									<td>${listValue.price}</td>
									<td>${listValue.status}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</form:form>
	</h:body>
</body>
</html>