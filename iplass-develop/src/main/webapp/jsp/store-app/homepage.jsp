<%@page import="org.iplass.mtp.web.template.TemplateUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@page import="storeApp.product.util.URLHelper"%>
<%@page import="org.iplass.mtp.entity.Entity"%>
<%@page import="java.util.List"%>
<%@page import="storeApp.product.entity.Product"%>
<%@page import="storeApp.product.entity.Brand"%>
<%@page import="storeApp.product.entity.CategoryProduct"%>
<%@page import="storeApp.product.dto.ProductCategoryDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>

<%
    List<ProductCategoryDTO> productList = (List<ProductCategoryDTO>) request.getAttribute("productList"); 
request.setAttribute("staticContentPath", TemplateUtil.getStaticContentPath());
%>

<link rel="stylesheet" href="${m:esc(staticContentPath)}/styles/homepage.css?cv=<%=TemplateUtil.getAPIVersion()%>">

<div class="container main-content-index">
    <div class="block-top-home">
        <div class="row">
            <div class="col-xl-2 col-md-3">
                <div class="category-product">
                    <ul>
                        <% for (ProductCategoryDTO p1 : productList) { %>
                        <li class="category-item">
                            <a class="nav-link" href="#" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                <i class="fa-solid fa-mobile-screen-button"></i>
                                <%=p1.getNameCategory()%>
                                <i class="fa-solid fa-chevron-right ic-angle-right"></i>
                            </a>
                            <ul class="dropdown-menu">
                                <div class="row">
                                    <div class="col-6 col-md-3">
                                        <h5>Hãng điện thoại</h5>
                                        <ul>
                                            <% for (Brand b1 : p1.getBrands()) { %>
                                            <li>
                                                <a href="<%= URLHelper.getProductsByBrand(b1.getOid(), "") %>"><%=b1.getName()%></a>
                                            </li>
                                            <% } %>
                                        </ul>
                                    </div>
                                </div>
                            </ul>
                        </li>
                        <% } %>
                    </ul>
                </div>
            </div>
            <div class="col-xl-10 col-md-9">
                <div class="row">
                    <div class="col-9">
                        <div class="hot-sale-product">
                            <div id="carouselExampleIndicators" class="carousel slide">
                                <div class="carousel-indicators">
                                    <button type="button" data-bs-target="#carouselExampleIndicators"
                                        data-bs-slide-to="0" class="active btn-select-slide" aria-current="true"
                                        aria-label="Slide 1"></button>
                                    <button type="button" data-bs-target="#carouselExampleIndicators"
                                        data-bs-slide-to="1" class="btn-select-slide" aria-label="Slide 2"></button>
                                    <button type="button" data-bs-target="#carouselExampleIndicators"
                                        data-bs-slide-to="2" class="btn-select-slide" aria-label="Slide 3"></button>
                                    <button type="button" data-bs-target="#carouselExampleIndicators"
                                        data-bs-slide-to="3" class="btn-select-slide" aria-label="Slide 4"></button>
                                </div>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="./assets/image/slide1.webp" class="d-block w-100" alt="...">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="./assets/image/slide2.webp" class="d-block w-100" alt="...">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="./assets/image/slide3.webp" class="d-block w-100" alt="...">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="./assets/image/slide4.webp" class="d-block w-100" alt="...">
                                    </div>
                                </div>
                                <button class="carousel-control-prev" type="button"
                                    data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button"
                                    data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="banner-top-home">
                            <img src="./assets/image/690x300_Rightbanner_Galaxy-M34-5G_04 (2).webp" alt="">
                            <img class="banner-top-home-center"
                                src="./assets/image/b2s-2024-right-banner-laptop.webp" alt="">
                            <img src="./assets/image/b2s-mac-2024-690300.webp" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <% for (ProductCategoryDTO p : productList) { %>
    <div class="hot-phone">
        <div class="row">
            <div class="col-md-5 col-12">
                <h3><%=p.getNameCategory()%></h3>
            </div>
            <div class="col-md-7 col-12 category-tag">
                <% for (Brand b : p.getBrands()) { %>
                <a href="<%= URLHelper.getProductsByBrand(b.getOid(), "") %>"><%=b.getName()%></a>
                <% } %>
            </div>
        </div>
        <div class="list-product">
            <% for (Product i : p.getProducts()) { %>
            <div class="product-item-container">
                <a href="<%= URLHelper.getProductDetailPath(i.getOid()) %>">
                    <div class="product-image">
                        <img src="<%= URLHelper.getProductImageResource(i, "productImage") %>" alt="">
                    </div>
                    <div class="product-name">
                        <h6><%= i.getName() %></h6>
                    </div>
                    <div class="product-price">
                        <span class="product__price--show"><%= i.getPrice() %></span>
                        <span class="product__price--through"><%= i.getOldPrice() %></span>
                    </div>
                    <div class="product-smem-price">
                        Smember giảm thêm đến
                        <span>138.000đ</span>
                    </div>
                    <div class="product-promotions">
                        <span>
                            Không phí chuyển đổi khi trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng
                        </span>
                    </div>
                </a>
                <div class="product-bottom-div">
                    <span class="product-box-rating">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                    </span>
                    <span class="btn-wish-list">
                        Yêu thích <i class="fa-regular fa-heart"></i>
                    </span>
                </div>
                <div class="install-0-tag">
                    Trả góp 0%
                </div>
                <div class="product__price--percent">
                    <p>
                        Giảm 27%
                    </p>
                </div>
            </div>
            <% } %>
        </div>
    </div>
    <% } %>
    <div class="banner-1">
        <h3>Ưu đãi thanh toán</h3>
        <div class="row">
            <div class="col-12 col-md-6 col-lg-3">
                <img src="./assets/image/banner1.webp" alt="">
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <img src="./assets/image/banner2.webp" alt="">
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <img src="./assets/image/banner3.webp" alt="">
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <img src="./assets/image/banner4.webp" alt="">
            </div>
        </div>
    </div>
</div>

