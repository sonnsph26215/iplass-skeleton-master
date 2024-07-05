<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ page import="storeApp.product.util.URLHelper"%>
<%@ page import="storeApp.product.entity.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Products</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
crossorigin="anonymous">
</head>
<body>

<div class="border-top mb-3"></div>

<div class="row mt-4">
<c:forEach var="p" items="${productList}">
	<div class="col-12 col-md-4">
		<div class="card border-info-subtle">
			<div class="card-body pt-md-1 text-center">
				<div>
					<a href="${URLHelper.getProductDetailPath(p.oid)}">
					${m:esc(p.name)}</a>
					<p>Category name: <span>${m:esc(p.idCategory.name)}</span> </p>
				</div>
				<div class="all-price">
					${m:esc(p.price)}
				</div>
				
			</div>
		</div>
	</div>
	
</c:forEach>

<p>page: <span>${m:esc(pageIndex)}</span>  </p>
<p>total page: <span>${m:esc(totalPage)}</span> </p>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>