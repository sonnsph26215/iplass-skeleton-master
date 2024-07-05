<%@page import="org.iplass.mtp.web.template.TemplateUtil"%>
<%@page import="storeApp.product.dto.ShowCart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="storeApp.product.util.URLHelper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>

<%
request.setAttribute("staticContentPath", TemplateUtil.getStaticContentPath());
%>

<link rel="stylesheet" href="${m:esc(staticContentPath)}/styles/cart.css?cv=<%=TemplateUtil.getAPIVersion()%>">

    <div class="container main-content-cart">
        <div class="back-page-block">
            <div class="back-btn">
                <i class="fa-solid fa-arrow-left"></i>
            </div>
            <p>Giỏ hàng của bạn</p>
        </div>
        <div class="row cart-page-container">
            <div class="col-md-8 col-12">
                <div class="table-list-prd-container">
                    <% List<ShowCart> cartList = (List<ShowCart>) request.getAttribute("resultcart");
                        if (cartList == null || cartList.size() == 0) { %>
                                                  <p>Cart trống</p>
                      <% } else { %>
                    <table class="table table-list-prd">
                        <thead>
                            <tr>
                                <th scope="col">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox">
                                        <label class="form-check-label sct-all">
                                            Chọn tất cả
                                        </label>
                                    </div>
                                </th>
                                <th scope="col"></th>
                                <th scope="col">
                                    <p class="delete-all-prd">Xoá sản phẩm đã chọn</p>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (ShowCart c : cartList) { %>
                            <tr>
                                <th scope="row">
                                    <input class="form-check-input check-box-item" type="checkbox" id="gridCheck">
                                    <div class="image-prd">
                                        <img src="<%= URLHelper.getProductImageResource(c.getProduct(), "productImage" ) %>" alt="">
                                    </div>
                                </th>
                                <td>
                                    <%=c.getProduct().getName()%>
                                    <div class="prd-price">
                                        <span class="product-price-show">
                                            <%=c.getProduct().getPrice()%>
                                        </span> <span class="product-price-through">
                                            <%=c.getProduct().getOldPrice()%>
                                        </span>
                                    </div>

                                </td>
                                <td>
                                    <div class="delete-item-block">
                                        <a class="text-dark"
                                            href="<%=URLHelper.getDeleteCartInfoPath(c.getProduct().getOid())%>"
                                            role="button"> <i class="fa-solid fa-trash-can"></i>
                                        </a>
                                        <div class="quantity-block">
                                            <button class="change-quantity-btn" onclick="changeQuantity(this, -1)">-</button>
                                            <input type="text" class="value-quantity"
                                                value="<%=c.getQuantity()%>"
                                                onchange="updateProductItem('<%=c.getProduct().getOid()%>', this.value);">
                                            <button class="change-quantity-btn" onclick="changeQuantity(this, 1)">+</button>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                           <% } %>
                        </tbody>
                    </table>
                    <% } %>
                </div>
            </div>
            <div class="col-md-4 col-8">
                <div class="payment-detail-container">
                    <h4>Thanh toán</h4>
                    <div class="subtotal">
                        <div class="total-row">
                            <span>Subtotal:</span> <span>${totalprice}đ</span>
                        </div>
                        <div class="total-row">
                            <span>Discount:</span> <span>0đ</span>
                        </div>
                        <div class="total-row">
                            <span>Delivery:</span> <span>0đ</span>
                        </div>
                    </div>
                    <div class="total">
                        <div class="total-row">
                            <span>Total:</span> <span>${totalprice}đ</span>
                        </div>
                    </div>
                    <div class="payment-btn">
                        <a class="pay-btn" href="<%= URLHelper.payment()%>">Thanh toán</a>
                    </div>
                </div>
            </div>
        </div>
        </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <script src="https://cdn-script.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript">
        function updateProductItem(productId, quantity) {
            var param = JSON.stringify({
                productId: productId,
                quantity: quantity
            });
            console.log(param);
            $
                .ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: `${m: tcPath()}/api/store-app/cart/edit`,
						dataType : "json",
						data : param,
						success : function(commandResult) {
							if (commandResult.exceptionType != null) {
								alert(`${ m: rs('iplass-wtp-messages', 'samples.ec01.product.detail.jsError') }`
										+ commandResult.exceptionType
										+ "\\n"
										+ commandResult.exceptionMessage);
								return;
							}
							if (commandResult.status === "SUCCESS") {
								location.reload();
							}
						},
						error : function(jqXHR, textStatus, errorThrown) {
							alert("An error occurred: " + textStatus + " - "
									+ errorThrown);
						}
					});
		}
        
        function changeQuantity(button, change) {
            const input = button.parentNode.querySelector('.value-quantity');
            // Lấy giá trị hiện tại của ô input và tăng/giảm nó
            let newValue = parseInt(input.value) + change;
            // Kiểm tra để đảm bảo giá trị không nhỏ hơn 1
            if (newValue < 1) newValue = 1;
            // Cập nhật giá trị mới cho ô input
            input.value = newValue;
            // Kích hoạt sự kiện onchange
            input.dispatchEvent(new Event('change'));
        }
    </script>
    
        <script type="text/javascript">
     function updateLink() { // Giá trị cố định cho brandId (có thể thay đổi theo logic của bạn)
     	var urlParams = new URLSearchParams(window.location.search);
         var brandId = urlParams.get('brandId');
         var searchInput = document.getElementById("searchInput").value;
         var url;
         if (!brandId) {
             url = '<%= URLHelper.getProductsByBrand(null , "' + searchInput + '") %>';
         }else {
         	 url = '<%= URLHelper.getProductsByBrand("' + brandId + '", "' + searchInput + '") %>';
         }
         window.location.href = url; // Chuyển hướng đến URL được xây dựng
     }
 </script>
