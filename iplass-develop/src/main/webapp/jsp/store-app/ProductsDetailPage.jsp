<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ page import="storeApp.product.util.URLHelper"%>
<%@ page import="storeApp.product.entity.Product"%>
<%@ page import="storeApp.product.entity.ProductImage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://iplass.org/tags/mtp"%>
<%@ page import="org.iplass.mtp.web.template.TemplateUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
	request.setAttribute("staticContentPath", TemplateUtil.getStaticContentPath());
	List<Product> productList = (List<Product>) request.getAttribute("productList"); 
%>
<link rel="stylesheet" href="${m:esc(staticContentPath)}/styles/productDetail.css?cv=<%=TemplateUtil.getAPIVersion()%>">

    <main>
        <div class="container mb-5 main-content">
            <h5>${m:esc(productInfo.getName())}<i class="fas fa-star"></i> <i class="fas fa-star"></i>
                <i class="fas fa-star"></i> <i class="fas fa-star"></i>
                <i class="fas fa-star"></i></h5>
                <hr>
            <div class="row product-details">
                <div class="col-md-7">
                    <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
							<%
                            List<ProductImage> imageList = (List<ProductImage>) request.getAttribute("imageList");
                                if (imageList == null || imageList.isEmpty()) {
                            %>
                                <div class="carousel-item active">
                                    <img src="<%= TemplateUtil.getStaticContentPath() + "/images/defaultImageForProduct.png" %>" class="d-block w-100 product-image-slide" alt="Default Product Image">
                                </div>
                            <%
                                } else {
                                    for (ProductImage i : imageList) {
                            %>
                                <div class="carousel-item <%= imageList.indexOf(i) == 0 ? "active" : "" %>">
                                    <img src="<%= URLHelper.getProductImageResource(i, "productImageRef") %>" class="d-block w-100 product-image-slide" alt="Product Image <%= imageList.indexOf(i) + 1 %>">
                                </div>
                            <%
                                    }
                                }
                            %>
<%--                             <c:forEach var="image" items="${imageList}" varStatus="status">
                                <div class="carousel-item ${status.first ? 'active' : ''}">
                                    <img src="${fn:escapeXml(URLHelper.getProductImageResource(image, 'productImageRef'))}" class="d-block w-100 product-image-slide" alt="Product Image">
                                </div>
					        </c:forEach> --%>
                        </div>
                        <a class="carousel-control-prev" data-bs-target="#productCarousel" role="button" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" data-bs-target="#productCarousel" role="button" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                    <div class="product-info">
                        <div class="mb-2"><i class="fa-solid fa-mobile-screen"></i>
                            Máy mới 100% , chính hãng Apple Việt Nam.
                            CellphoneS hiện là đại lý bán lẻ uỷ quyền iPhone chính hãng VN/A của Apple Việt Nam
                        </div>
                        <div class="mb-2">
                            <i class="fa-solid fa-box-open"></i>
                            Hộp, Sách hướng dẫn, Cây lấy sim, Cáp Type C
                        </div>
                        <div class="mb-2">
                            <i class="fa-regular fa-clock"></i>
                            1 ĐỔI 1 trong 30 ngày nếu có lỗi phần cứng nhà sản xuất. Bảo hành 12 tháng tại trung tâm bảo hành chính hãng Apple: CareS.vn
                        </div>
                        <div class="mb-2">
                            <i class="fa-solid fa-percent"></i>
                            Giá sản phẩm đã bao gồm VAT
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="row price-section">
                        <a href="#" class="col-3 select-GB">
                            <h5>1TB</h5>
                            <small class="text-muted">42,990,000₫</small>
                        </a>
                        <a href="#" class="col-3 select-GB">
                            <h5>512GB</h5>
                            <small class="text-muted">36,290,000₫</small>
                        </a>
                        <a href="#" class="col-3 select-GB active">
                            <h5>256GB</h5>
                            <small class="text-muted">29,490,000₫</small>
                        </a>
                    </div>
                    <div class="box-content">
                    <h5>Chọn màu để xem giá</h5>
                    <ul class="list-variants">
                        <li class="item-variant">
                            <a href="#" style="display: flex;">
                            <img style="height: 50px; width: 50px;" src="https://cdn2.cellphones.com.vn/insecure/rs:fill:50:50/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone15-pro-max-titan-den.jpg">
                            <div style="display: flex;" class="flex-column">
                                <strong>Titan đen</strong>
                                <span>29,690,000₫</span>
                            </div>
                            </a>
                        </li>
                        <li class="item-variant">
                            <a href="#" style="display: flex;">
                            <img style="height: 50px; width: 50px;" src="https://cdn2.cellphones.com.vn/insecure/rs:fill:50:50/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone15-pro-max-titan-nau.jpg">
                            <div style="display: flex;" class="flex-column">
                                <strong>Titan tự nhiên</strong>
                                <span>29,690,000₫</span>
                            </div>
                            </a>
                        </li>
                        <li class="item-variant active">
                            <a href="#" style="display: flex;">
                            <img style="height: 50px; width: 50px;" src="https://cdn2.cellphones.com.vn/insecure/rs:fill:50:50/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone15-pro-max-titan-xanh.jpg">
                            <div style="display: flex;" class="flex-column">
                                <strong>Titan xanh</strong>
                                <span>29,490,000₫</span>
                            </div>
                            </a>
                        </li>
                        <li class="item-variant">
                            <a href="#" style="display: flex;">
                            <img style="height: 50px; width: 50px;" src="https://cdn2.cellphones.com.vn/insecure/rs:fill:50:50/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone15-pro-max-titan-trang.jpg">
                            <div style="display: flex;" class="flex-column">
                                <strong>Tintan trắng</strong>
                                <span>29,690,000₫</span>
                            </div>
                            </a>
                        </li>
                    </ul>
                    </div>
                    <div>
                        <div class="flex-column total-price">
                            <p class="price">${m:esc(productInfo.getPrice())}</p>
                            <small><span class="old-price"><del>${m:esc(productInfo.getOldPrice())}</del></span></small>
                        </div>
                    </div>
                    <div style="width: 100%;" class="btn-group">
                        <button style="width: 70%;" class="btn btn-danger btn-block">MUA NGAY</button>
                        <!-- <div class="page-wrapper"> -->
                        <button onclick="inputCartInfo('${productInfo.oid}')" style="width: 30%;" class="btn btn-light" id="addtocart">
                        <i class="fa-solid fa-cart-plus"></i> 
                        <br>Thêm vào giỏ
                        </button>
                        <!-- </div> -->
                    </div>
                </div>
            </div>
            <div class="container mt-3 p-0">
                <h4>Sản phẩm tương tự</h4>
            <div class="product-slider">
                <div class="product-list">
                	<% for (Product p : productList) { %>
                    <div class="product-card-slide">
                    	<a href="<%= URLHelper.getProductDetailPath(p.getOid()) %>">
	                        <div class="discount">Giảm 6%</div>
	                        <div class="installment">Trả góp 0%</div>
	                        <img src="<%= URLHelper.getProductImageResource(p, "productImage") %>" alt="Product 1">
	                        <div style="min-height: 15%;"><h5><%= p.getName() %></h5></div>
	                        <div class="price"><%= p.getPrice() %> <span class="old-price"><%= p.getOldPrice() %></span></div>
	                        <div class="rating"><i class="fas fa-star"></i> <i class="fas fa-star"></i>
	                            <i class="fas fa-star"></i> <i class="fas fa-star"></i>
	                            <i class="fas fa-star"></i></div>
	                        <div class="favorite">Yêu thích ♥</div>
                         </a>
                    </div>
                    <% } %>
                </div>
                <div class="slider-nav">
                    <button id="prevBtn">&lt;</button>
                    <button id="nextBtn">&gt;</button>
                </div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-7">
                <div class="info-special">
                    <div class="content-special">
                        <h4 style="text-align: center; color: crimson;">Đặc điểm nổi bật</h4>
                        <ul>
                            <li>Thiết kế khung viền từ titan chuẩn hàng không vũ trụ - Cực nhẹ, bền cùng viền cạnh mỏng cầm nắm thoải mái</li>
                            <li>Hiệu năng Pro chiến game thả ga - Chip A17 Pro mang lại hiệu năng đồ họa vô cùng sống động và chân thực</li>
                            <li>Thoả sức sáng tạo và quay phim chuyên nghiệp - Cụm 3 camera sau đến 48MP và nhiều chế độ tiên tiến</li>
                            <li>Nút tác vụ mới giúp nhanh chóng kích hoạt tính năng yêu thích của bạn</li>
                        </ul>
                    </div>
                    <blockquote>
                        <p style="font-size: 14px;">iPhone 15 Pro Max sở hữu màn hình Super Retina XDR OLED 6.7 inches với độ phân giải 2796 x 1290 pixels, cung cấp trải nghiệm hình ảnh sắc nét, chân thực. So với các phiên bản tiền nhiệm, thế hệ iPhone 15 bản Pro Max đảm bảo mang tới hiệu năng mạnh mẽ với sự hỗ trợ của chipset Apple A17 Pro, cùng bộ nhớ ấn tượng. Đặc biệt hơn, điện thoại iPhone 15 ProMax mới này còn được đánh giá cao với camera sau 48MP và camera trước 12MP, hỗ trợ chụp ảnh với độ rõ nét cực đỉnh.</p>
                    </blockquote>
                </div>
            </div>
            <div class="col-md-5">
                <div class="tech-info">
                    <h4>Thông số kỹ thuật</h4>
                    <div class="tech-content">
                        <ul class="p-1">
                            <li class="row">
                                <p class="col-6">Kích thước màn hình</p>
                                <div class="col-6">6.7 inches</div>
                            </li>
                            <li class="row">
                                <p class="col-6">Công nghệ màn hình</p>
                                <div class="col-6">Super Retina XDR OLED</div>
                            </li>
                            <li class="row">
                                <p class="col-6">Camera sau</p>
                                <div class="col-6">Camera chính: 48MP, 24 mm, ƒ/1.78
                                    Camera góc siêu rộng: 12 MP, 13 mm, ƒ/2.2
                                    Camera Tele: 12 MP</div>
                            </li>
                            <li class="row">
                                <p class="col-6">Camera trước</p>
                                <div class="col-6">12MP, ƒ/1.9</div>
                            </li>
                            <li class="row">
                                <p class="col-6">Chipset</p>
                                <div class="col-6">Apple A17 Pro 6 nhân</div>
                            </li>
                            <li class="row">
                                <p class="col-6">Dung lượng RAM</p>
                                <div class="col-6">8 GB</div>
                            </li>
                            <li class="row">
                                <p class="col-6">Bộ nhớ trong</p>
                                <div class="col-6">256 GB</div>
                            </li>
                            <li class="row">
                                <p class="col-6">Pin</p>
                                <div class="col-6">4422 mAh</div>
                            </li>
                            <li class="row">
                                <p class="col-6">Hệ điều hành</p>
                                <div class="col-6">iOS 17</div>
                            </li>
                            <li class="row">
                                <p class="col-6">Độ phân giải màn hình</p>
                                <div class="col-6">2796 x 1290-pixel</div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="feedback-container mt-3">
            <div style="border-bottom:1px solid rgb(230, 230, 230) ;">
                <h6>Đánh giá & nhận xét iPhone 15 Pro Max 256GB | Chính hãng VN/A</h6>
                <div class="row mb-2">
                    <div style="text-align: center; border-right: 1px solid rgb(230, 230, 230);" class="col-4 mt-3">
                        <h4>4.9/5</h4>
                        <p class="mb-1"><i class="fas fa-star"></i> <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i> <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i></p>
                        <a href="#">49 đánh giá</a>
                    </div>
                    <div class="col-8">
                        <div style="display: flex; align-items: center;">
                        <span>5 <i class="fas fa-star"></i></span>
                        <div class="progress mb-2 mt-2" role="progressbar" aria-label="Danger example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="height: 8px; width: 80%; margin-left: 10px;">
                            <div class="progress-bar bg-danger" style="width: 90%"></div>
                          </div>
                        </div>
                        <div style="display: flex; align-items: center;">
                            <span>4 <i class="fas fa-star"></i></span>
                            <div class="progress mb-2 mt-2" role="progressbar" aria-label="Danger example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="height: 8px; width: 80%; margin-left: 10px;">
                                <div class="progress-bar bg-danger" style="width: 10%"></div>
                            </div>
                        </div>
                        <div style="display: flex; align-items: center;">
                            <span>3 <i class="fas fa-star"></i></span>
                            <div class="progress mb-2 mt-2" role="progressbar" aria-label="Danger example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="height: 8px; width: 80%; margin-left: 10px;">
                                <div class="progress-bar bg-danger" style="width: 0%"></div>
                            </div>
                        </div>
                        <div style="display: flex; align-items: center;">
                            <span>2 <i class="fas fa-star"></i></span>
                            <div class="progress mb-2 mt-2" role="progressbar" aria-label="Danger example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="height: 8px; width: 80%; margin-left: 10px;">
                                <div class="progress-bar bg-danger" style="width: 0%"></div>
                            </div>
                        </div>
                        <div style="display: flex; align-items: center;">
                            <span>1 <i class="fas fa-star"></i></span>
                            <div class="progress mb-2 mt-2" role="progressbar" aria-label="Danger example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="height: 8px; width: 80%; margin-left: 10px;">
                                <div class="progress-bar bg-danger" style="width: 0%"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="feedback">
                <div>Bạn đánh giá sao về sản phẩm này?</div>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Đánh giá ngay
                </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                        <h3 class="modal-title fs-5" id="exampleModalLabel">Đánh giá & nhận xét</h3>
                        <button type="button" class="btn btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div style="border-bottom:1px solid rgb(230, 230, 230) ;">
                                <div class="d-flex" style="align-items: center;">
                                    <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:100:100/q:90/plain/https://cellphones.com.vn/media/wysiwyg/cps-ant.png" alt="img-modal">
                                    <h4>${m:esc(productInfo.getName())}</h4>
                                </div>
                                <div class="mt-5 mb-5">
                                    <h5>Đánh giá chung</h5>
                                    <input type="range" class="form-range mt-3" min="1" max="5" id="customRange2">
                                </div>
                            </div>
                            <div class="mt-3">
                            <input class="form-control mb-3"  placeholder="Họ Và Tên" id="name-user">
                            <input value="${productInfo.getOid()}" id="productid" style="display: none;">
                            <textarea class="form-control textarea" id="comment"
                            placeholder="Xin mời chia sẻ một số cảm nhận về sản phẩm (nhập tối thiểu 15 kí tự)"></textarea>
                                <!-- <div>
                                    <input id="image" type="file" style="display: none;">
                                    <label for="image" class="btn-add">
                                        <i class="fa-solid fa-file-image"></i>
                                        <p>Thêm hình ảnh</p>
                                    </label>
                                </div> -->
                            </div>
                        </div>
                        <div class="modal-footer">
                        <button type="button" class="btn btn-danger" onclick="addComment();">Gửi đánh giá</button>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
            <div class="mt-3">
                <div class="box-review-title"><h4>Nhận xét của khách hàng</h4></div>
                
                <div class="box-review mt-4">
                
                <c:forEach var="item" items="${ review }">
                <div class="box-review-item mt-3">
                        <div class="review-item-title d-flex">
                            <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:100:100/q:90/plain/https://cellphones.com.vn/media/wysiwyg/cps-ant.png" alt="avt" style="width: 32px; height: 32px; border-radius: 50%;">
                            <h6 style="margin-left: 10px;">${m:esc(item.nameReview)}</h6>
                        </div>
                        <div class="review-item-content">
                            <div class="d-flex" style="height: 30px; margin-left: 35px;">
                                <span style="border-right:1px solid rgb(230, 230, 230);">
                                    <i class="fas fa-star"></i> 
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i> 
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                 </span>
                                    <!-- <div style="border: 1px solid rgb(230, 230, 230); margin-left: 15px;">Hiệu năng mạnh mẽ</div>
                                    <div style="border: 1px solid rgb(230, 230, 230); margin-left: 15px;">Thời lượng pin cực khủng</div> -->
                            </div>
                            <div class="mt-2" style="margin-left: 35px;">
                            <p>${m:esc(item.commentReview)}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                    
                </div>
            </div>
        </div>
        </div>
    </main>

    <script src="https://kit.fontawesome.com/264642374c.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    
    <script type="text/javascript">
	    async function inputCartInfo(productId) {

		    var param = JSON.stringify({ productId: productId });
		    console.log(param);
		    $.ajax({
		        type: "POST",
		        contentType: "application/json",
		        url: `${m:tcPath()}/api/store-app/cart/add`,
		        dataType: "json",
		        data: param,
		        success: function(commandResult) {
		            if (commandResult.exceptionType != null) {
		                alert(`${m:rs('iplass-wtp-messages', 'samples.ec01.product.detail.jsError')}`
		                      + commandResult.exceptionType + "\\n" + commandResult.exceptionMessage);
		                return;
		            }
		            if(commandResult.status == "SUCCESS"){
						var totalAmount = commandResult.totalAmount;
						console.log(totalAmount);
		    		}
		        }
		    });
		}
	
	</script>
	 <script>
    function addComment() {
        // Lấy giá trị từ các ô input
        const name = document.getElementById('name-user').value;
        const comment = document.getElementById('comment').value;
        const rating = document.getElementById('customRange2').value;
        const productid = document.getElementById('productid').value;
        
        var param = JSON.stringify({ name: name, comment: comment, vote: rating, productId: productid });
	    $.ajax({
	        type: "POST",
	        contentType: "application/json",
	        url: `${m:tcPath()}/api/store-app/review/add`,
	        dataType: "json",
	        data: param,
	        success: function(commandResult) {
	            if (commandResult.exceptionType != null) {
	                alert(`${m:rs('iplass-wtp-messages', 'samples.ec01.product.detail.jsError')}`
	                      + commandResult.exceptionType + "\\n" + commandResult.exceptionMessage);
	                return;
	            }
	            if(commandResult.status == "SUCCESS"){
					console.log("SUCCESS");
					location.reload();
	    		}
	        }
	    });
        }
    
        const slider = document.querySelector('.product-slider');
          const productList = document.querySelector('.product-list');
          const prevBtn = document.getElementById('prevBtn');
          const nextBtn = document.getElementById('nextBtn');
  
          let currentIndex = 0;
          const productCard = document.querySelector('.product-card-slide');
          const productWidth = productCard.offsetWidth + 15; // 15px margin
          const visibleItems = Math.floor(slider.offsetWidth / productWidth);
          const totalItems = document.querySelectorAll('.product-card-slide').length;
  
          function updateButtonVisibility() {
              prevBtn.style.visibility = currentIndex === 0 ? 'hidden' : 'visible';
              nextBtn.style.visibility = currentIndex >= totalItems - visibleItems ? 'hidden' : 'visible';
          }
  
          prevBtn.addEventListener('click', () => {
              if (currentIndex > 0) {
                  currentIndex--;
                  productList.style.transform = `translateX(-${productWidth * currentIndex}px)`;
              }
              updateButtonVisibility();
          });
  
          nextBtn.addEventListener('click', () => {
              if (currentIndex < totalItems - visibleItems) {
                  currentIndex++;
              } else {
                  currentIndex = totalItems - visibleItems;
              }
              productList.style.transform = `translateX(-${productWidth * currentIndex}px)`;
              updateButtonVisibility();
          });
  
          // Initial button visibility
          updateButtonVisibility();
  
          // Handle window resize
          window.addEventListener('resize', () => {
              const newVisibleItems = Math.floor(slider.offsetWidth / productWidth);
              if (newVisibleItems !== visibleItems) {
                  if (currentIndex > totalItems - newVisibleItems) {
                      currentIndex = totalItems - newVisibleItems;
                  }
                  productList.style.transform = `translateX(-${productWidth * currentIndex}px)`;
                  updateButtonVisibility();
              }
          });



          let counter = 0;
		const counterElement = document.getElementById("js-shopping-bag-counter");
		
		async function addToCart(index) {
		  const dot = createCartDot();
		  const parent = this.window.event.target.closest("button");
		
		  parent.append(dot);
		
		  const moveTransition = document.startViewTransition(() =>
		    moveDotToTarget(dot)
		  );
		
		  await moveTransition.finished;
		
		  dot.remove();
		  dot.style.viewTransitionName = "none";
		
		  counterElement.style.viewTransitionName = "cart-counter";
		
		  if (!document.startViewTransition) {
		    incrementCounter();
		    return;
		  }
		
		  const counterTransition = document.startViewTransition(() =>
		    incrementCounter(counterElement)
		  );
		  await counterTransition.finished;
		  counterElement.style.viewTransitionName = "none";
		}
		
		function moveDotToTarget(dot) {
		  const target = document.getElementById("js-shopping-bag-target");
		  target.append(dot);
		}
		
		function incrementCounter() {
		  counter += 1;
		  counterElement.innerText = counter;
		}
		
		function createCartDot() {
		  const dot = document.createElement("div");
		  dot.classList.add("product__dot");
		  dot.style.viewTransitionName = "cart-dot";
		
		  return dot;
		}
		
   	</script>
