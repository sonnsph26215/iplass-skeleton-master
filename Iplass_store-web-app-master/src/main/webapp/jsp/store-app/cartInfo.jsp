<%@page import="storeApp.product.dto.ShowCart"%>
<%@page import="org.iplass.mtp.entity.Entity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="storeApp.product.util.URLHelper"%>
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="border-top mb-3"></div>
	<div class="row mt-4">
		
		 <% List<ShowCart> cartList = (List<ShowCart>) request.getAttribute("resultcart"); 
  if( cartList == null || cartList.size() == 0) {
  %>
  <p>Cart trống</p>
  <% } else { %>
		
		<table class="table" style="margin-left: 1rem;">
  <thead>
    <tr>
      <th scope="col">name</th>
      <th scope="col">price</th>
      <th scope="col">quantity</th>
      <th scope="col">total price</th>
      <th scope="col">action</th>
    </tr>
  </thead>
  <tbody>
 
  <% for (ShowCart c : cartList) { %>
     <tr>
      <th><%= c.getProduct().getName() %></th>
      <td><%= c.getProduct().getPrice() %></td>
      <td>
      <input type="text" value="<%= c.getQuantity() %>" 
       onchange="updateProductItem('<%= c.getProduct().getOid() %>', this.value);"></td>
      <td><%= c.getTotalPrice() %></td>
      <td>
      <a class="text-dark" href="<%= URLHelper.getDeleteCartInfoPath(c.getProduct().getOid()) %>" role="button">
         <i class="fa-solid fa-trash-can"></i>
      </a>
      </td>
    </tr>
  <% } 
  }%>
    
  </tbody>
</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="https://cdn-script.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
<script type="text/javascript">
function updateProductItem(productId, quantity) {
    var param = JSON.stringify({ productId: productId, quantity: quantity });
    console.log(param);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: `${m:tcPath()}/api/store-app/cart/edit`,
        dataType: "json",
        data: param,
        success: function(commandResult) {
            if (commandResult.exceptionType != null) {
            	alert(`${m:rs('iplass-wtp-messages', 'samples.ec01.product.detail.jsError')}`
	                      + commandResult.exceptionType + "\\n" + commandResult.exceptionMessage);
                return;
            }
            if (commandResult.status === "SUCCESS") {
                location.reload();
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert("An error occurred: " + textStatus + " - " + errorThrown);
        }
    });
}
</script>
</body>
</html>