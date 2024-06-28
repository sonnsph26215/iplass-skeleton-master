<%@page import="org.iplass.mtp.entity.Entity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="storeApp.product.util.URLHelper"%>
<%@ page import="storeApp.product.entity.Product"%>
<%@ page import="storeApp.product.entity.CategoryProduct"%>
<%@ page import="storeApp.product.dto.ProductCategoryDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Products</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="border-top mb-3"></div>
	<div class="row mt-4">
		<p>
			totalCategoryCount: <span>${m:esc(totalCategoryCount)}</span>
		</p>
<% List<ProductCategoryDTO> productList = (List<ProductCategoryDTO>) request.getAttribute("productList"); %>
		<% for (ProductCategoryDTO p : productList) { %>
		<h5><%=p.getNameCategory()%></h5>

		<% for (Product i : p.getProducts()) { %>
		<div class="col-12 col-md-4">
				<div class="card border-info-subtle">
					<div class="card-body pt-md-1 text-center">
						<div>
							<a href="<%= URLHelper.getProductDetailPath(i.getOid()) %>"><%= i.getOid() %></a> 
							<p><%= i.getName() %></p>
						</div>
						<div class="all-price"><%= i.getPrice() %></div>
					</div>
				</div>
			</div>
		<% } %>
			
		<% } %>
		
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>