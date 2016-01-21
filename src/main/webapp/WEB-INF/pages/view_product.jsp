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

	function split(val) {
		return val.split(/,\s*/);
	}
	function extractLast(term) {
		return split(term).pop();
	}

	$(document).ready(function() {

		$("#ceos").autocomplete({
			source : '${pageContext.request.contextPath}/searchList'
		});

		$("#companies").autocomplete({
			source : function(request, response) {
				$.getJSON("${pageContext.request.contextPath}/searchList", {
					term : extractLast(request.term)
				}, response);
			},
			search : function() {
				var term = extractLast(this.value);
				if (term.length < 1) {
					return false;
				}
			},
			focus : function() {
				return false;
			},
			select : function(event, ui) {
				var terms = split(this.value);
				terms.pop();
				terms.push(ui.item.value);
				terms.push("");
				this.value = terms.join(", ");
				return false;
			}
		});

	});
</script>
</head>
<body>
	<h:body>
		<form:form action="/home" method="post">
			<div>
				<label for="automplete-3">Search: </label> <input id="automplete-3">
			</div>
			<h3 align="center">View Product Details</h3>
			<table align="center">
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
		</form:form>
	</h:body>
</body>
</html>