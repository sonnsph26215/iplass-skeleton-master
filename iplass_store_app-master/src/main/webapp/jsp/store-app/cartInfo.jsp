<%@page import="org.iplass.mtp.web.template.TemplateUtil"%>
<%@page import="storeApp.product.dto.ShowCart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="storeApp.product.util.URLHelper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>
<!DOCTYPE html>
<html>
<%
	request.setAttribute("staticContentPath", TemplateUtil.getStaticContentPath());
%>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${m:esc(staticContentPath)}/styles/cart.css">
</head>

<body>
    <header>
        <div class="header-page">
            <div class="container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <img src="./assets/image/Top banner_Thu cu.svg" alt="">
                    </div>
                    <div class="swiper-slide">
                        <img src="./assets/image/Top banner_Giao hang.svg" alt="">
                    </div>
                    <div class="swiper-slide">
                        <img src="./assets/image/Top banner_Chinh hang.svg" alt="">
                    </div>
                </div>
            </div>
        </div>

        <div class="menu-page">
            <div class="container menu-container">
                <div class="row menu-items">
                    <div class="col-2 logo">
                        <img src="./assets/image/logo-cps.webp" alt="Logo">
                    </div>
                    <div class="col-5">
                        <div class="input-group">
                            <span class="input-group-text" id="basic-addon1"><i
                                    class="fa-solid fa-magnifying-glass"></i></span> <input type="text"
                                class="form-control" aria-label="Username" aria-describedby="basic-addon1">
                        </div>
                    </div>
                    <div class="col-5 menu-select">
                        <div class="menu-right">
                            <div class="menu-option login-box">
                                <h6>
                                    <i class="fa-solid fa-bag-shopping"></i>
                                </h6>
                                <h6>Giỏ hàng</h6>
                            </div>
                            <div class="menu-option cart-box">
                                <h6>
                                    <i class="fa-regular fa-circle-user"></i>
                                </h6>
                                <h6>Đăng nhập</h6>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class="container main-content">
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
                                                    <input class="form-check-input" type="checkbox"> <label
                                                        class="form-check-label sct-all"> Chọn
                                                        tất cả </label>
                                                </div>
                                            </th>
                                            <th scope="col"></th>
                                            <th scope="col">
                                                <p class="delete-all-prd">Xoá sản phẩm đã chọn
                                                </p>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
<% for (ShowCart c : cartList) { %>
                                            <tr>
                                                <th scope="row"><input class="form-check-input check-box-item"
                                                        type="checkbox" id="gridCheck">
                                                    <div class="image-prd">
                                                        <img src="<%= URLHelper.getProductImageResource(c.getProduct()) %>" alt="">
                                                    </div>
                                                </th>
                                                <td>
                                                    <h6>
                                                        <%=c.getProduct().getName()%>
                                                    </h6>
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
                        <a class="pay-btn" href="<%=URLHelper.payment()%>">Thanh toán</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="footer-page">
        <div class="footer-page-end">
            <div class="container">
                <div class="row">
                    <div class="col-3">
                        <p class="footer-text-4">Back to School là gì - Điện thoại -
                            Điện thoại iPhone</p>
                        <p class="footer-text-4">Điện thoại iPhone 15 – Điện thoại
                            iPhone 15 Pro Max</p>
                    </div>
                    <div class="col-3">
                        <p class="footer-text-4">Điện thoại Vivo – Điện thoại OPPO –
                            Điện thoại Xiaomi</p>
                        <p class="footer-text-4">Điện thoại Samsung Galaxy – Samsung
                            Galaxy A</p>
                    </div>
                    <div class="col-3">
                        <p class="footer-text-4">Laptop – Laptop Acer – Laptop Dell –
                            Laptop HP</p>
                        <p class="footer-text-4">Tivi – Tivi Samsung – Tivi Sony –
                            Tivi LG – Tivi TCL</p>
                    </div>
                    <div class="col-3">
                        <p class="footer-text-4">Nhà thông minh – Máy hút bụi gia đình
                            – Cân điện tử</p>
                        <p class="footer-text-4">Đồ gia dụng – Nồi chiên không dầu giá
                            rẻ – Nồi cơm điện</p>
                    </div>
                    <p class="footer-text-5">Công ty TNHH Thương Mại Tổng Hợp HTV-
                        GPĐKKD: 0108075931 cấp tại Sở KH & ĐT TP. Hà Nội. Địa chỉ văn
                        phòng: 543 Nguyễn Trãi, phường Thanh Xuân Nam. quận Thanh Xuân,
                        Thành phố Hà Nội, Việt Nam. Điện thoại: 024.7303.0119.</p>
                </div>
            </div>
        </div>
    </div>
    <p>${m:esc(orderProducts)}</p>

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
</body>

</html>