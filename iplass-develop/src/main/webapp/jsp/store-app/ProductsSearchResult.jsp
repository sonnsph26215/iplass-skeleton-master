<%@page import="org.iplass.mtp.entity.Entity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="storeApp.product.util.URLHelper"%>
<%@ page import="storeApp.product.entity.Product"%>
<%@ page import="storeApp.product.entity.Brand"%>
<%@ page import="storeApp.product.entity.CategoryProduct"%>
<%@ page import="storeApp.product.dto.ProductCategoryDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>
<%@ page import="org.iplass.mtp.web.template.TemplateUtil"%>

<!DOCTYPE html>
<html>
<%
	request.setAttribute("staticContentPath", TemplateUtil.getStaticContentPath());
	List<Product> productList = (List<Product>) request.getAttribute("productList"); 
%>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet" href="${m:esc(staticContentPath)}/styles/productSearch.css?cv=<%=TemplateUtil.getAPIVersion()%>">
</head>
<body>
    <main>
      <div class="container">
        <!-- Filter and Sort Section -->
        <div class="mb-3">
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-outline-secondary">
              IPHONE 15 SERIES
            </button>
            <button type="button" class="btn btn-outline-secondary">
              IPHONE 14 SERIES
            </button>
            <button type="button" class="btn btn-outline-secondary">
              IPHONE 13 SERIES
            </button>
            <button type="button" class="btn btn-outline-secondary">
              IPHONE 12 SERIES
            </button>
            <button type="button" class="btn btn-outline-secondary">
              IPHONE 11 SERIES
            </button>
          </div>
        </div>
        <div class="mb-3">
            <h3>Chọn theo tiêu Chí</h3>
            <ul class="nav">
                <li class="nav-item">
                <button type="button" class="nav-link">
                    <i class="fa-solid fa-filter"></i>
                  Bộ lọc
                </button>
                </li>
                <li class="nav-item">
                <button type="button" class=" nav-link">
                    <i class="fa-solid fa-truck"></i>
                  Sẵn hàng
                </button>
            </li>
            <li class="nav-item">
                <button type="button" class=" nav-link"><i class="fa-solid fa-money-bill"></i> Giá</button>
            </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="storageDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Bộ nhớ trong
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="storageDropdown">
                        <li><a class="dropdown-item" href="#">Trên 512GB</a></li>
                        <li><a class="dropdown-item" href="#">128GB và 256GB</a></li>
                        <li><a class="dropdown-item" href="#">32GB và 64GB</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="ramDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dung lượng RAM
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="ramDropdown">
                        <li><a class="dropdown-item" href="#">4GB-6GB</a></li>
                        <li><a class="dropdown-item" href="#">8GB-12GB</a></li>
                        <li><a class="dropdown-item" href="#">Dưới 4GB</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="screenSizeDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Kích thước màn hình
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="screenSizeDropdown">
                        <li><a class="dropdown-item" href="#">Trên 6 inch</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="usageDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Nhu cầu sử dụng
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="usageDropdown">
                        <li><a class="dropdown-item" href="#">Dung lượng lớn</a></li>
                        <li><a class="dropdown-item" href="#">Cấu hình cao</a></li>
                        <li><a class="dropdown-item" href="#">Chơi game</a></li>
                        <li><a class="dropdown-item" href="#">Pin trâu</a></li>
                        <li><a class="dropdown-item" href="#">Chụp ảnh đẹp</a></li>
                        <li><a class="dropdown-item" href="#">Live Stream</a></li>
                        <li><a class="dropdown-item" href="#">Nhỏ gọn, dễ cầm nắm</a></li>
                        <li><a class="dropdown-item" href="#">Mỏng nhẹ</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="screenTypeDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Kiểu màn hình
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="screenTypeDropdown">
                        <li><a class="dropdown-item" href="#">Dynamic island</a></li>
                        <li><a class="dropdown-item" href="#">Tai thỏ</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="cameraFeaturesDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Tính năng camera
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="cameraFeaturesDropdown">
                        <li><a class="dropdown-item" href="#">Chụp Macro</a></li>
                        <li><a class="dropdown-item" href="#">Chụp xóa phông</a></li>
                        <li><a class="dropdown-item" href="#">Chụp góc rộng</a></li>
                        <li><a class="dropdown-item" href="#">Quay video 4k</a></li>
                        <li><a class="dropdown-item" href="#">Chống rung</a></li>
                        <li><a class="dropdown-item" href="#">Chụp zoom xa</a></li>
                        <li><a class="dropdown-item" href="#">Quay video 8k</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="refreshRateDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Tần số quét
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="refreshRateDropdown">
                        <li><a class="dropdown-item" href="#">60Hz</a></li>
                        <li><a class="dropdown-item" href="#">120Hz</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="specialFeaturesDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Tính năng đặc biệt
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="specialFeaturesDropdown">
                        <li><a class="dropdown-item" href="#">Hỗ trợ 5G</a></li>
                        <li><a class="dropdown-item" href="#">Sạc không dây</a></li>
                        <li><a class="dropdown-item" href="#">Nhận diện khuôn mặt</a></li>
                        <li><a class="dropdown-item" href="#">Kháng nước, kháng bụi</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="mb-3">
            <h3>Sắp xếp theo</h3>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-outline-secondary">
                <i class="fa-solid fa-arrow-down-wide-short"></i> Giá Cao - Thấp
            </button>
            <button type="button" class="btn btn-outline-secondary">
                <i class="fa-solid fa-arrow-down-short-wide"></i> Giá Thấp - Cao
            </button>
            <button type="button" class="btn btn-outline-secondary">
                <i class="fa-solid fa-percent"></i> Khuyến Mãi Hot
            </button>
            <button type="button" class="btn btn-outline-secondary">
                <i class="fa-solid fa-eye"></i> Xem nhiều
            </button>
          </div>
        </div>

        <!-- Product Cards Section -->
        <div class="row">
          <!-- Product Card Example -->
          <% for (Product p : productList) { %>
          <div class="col-md-3">
            <div class="product-card">
              <img src="<%= URLHelper.getProductImageResource(p, "productImage") %>"" alt="iPhone 13 128GB" />
              <span class="badge badge-danger">Giảm 28%</span>
              <span class="badge badge-primary">Trả góp 0%</span>
              <a style="text-decoration: none; color: #212529;" href="<%= URLHelper.getProductDetailPath(p.getOid()) %>"><h5><%= p.getName() %></h5></a>
              <p class="price">
                <%= p.getPrice() %> <span class="old-price"><%= p.getOldPrice() %></span>
              </p>
              <p class="features">6.1 inches | 4 GB | 128 GB</p>
              <div class="smem-price">Smember giảm thêm đến&nbsp;
                <span>137.000đ</span>
              </div>
              <p class="note">
                Không phí chuyển đổi khi trả góp 0% qua thẻ tín dụng kỳ hạn
                3-6 tháng
              </p>
              <p>
                <i class="fas fa-star"></i> <i class="fas fa-star"></i>
                <i class="fas fa-star"></i> <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i> (102)
              </p>
            </div>
          </div>
          <% } %>
        </div>
      </div>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/264642374c.js" crossorigin="anonymous"></script>

    </body>
</html>