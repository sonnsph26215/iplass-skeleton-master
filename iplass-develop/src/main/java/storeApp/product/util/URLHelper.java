package storeApp.product.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.web.template.TemplateUtil;

public class URLHelper {
	
	private final static String PACKAGE_URL_ROOT = "/store-app/";
	private final static String PRODUCT_DETAIL_URL_PATH = PACKAGE_URL_ROOT + "product-detail?id=%s";
	private final static String CATEGORY_PAGE_URL_PATH = PACKAGE_URL_ROOT + "ProductListCommand?idCategory=%s&page=%s";
	private final static String BINARY_RESOUCE_URL_PATH = PACKAGE_URL_ROOT + "resource/bin?id=%d&type=%s";
	private final static String PRODUCTS_BY_BRAND_URL_PATH = PACKAGE_URL_ROOT + "product-by-brand";
	private final static String DELETE_CART_INFO_URL_PATH = PACKAGE_URL_ROOT + "cart/remove?deleteId=%s";
	private final static String PAYMENT_URL_PATH = PACKAGE_URL_ROOT + "payment";
	private final static String CART_INFO_URL_PATH = PACKAGE_URL_ROOT + "cart/info";

	public static String getProductDetailPath(String productId) {
		return TemplateUtil.getTenantContextPath() + String.format(PRODUCT_DETAIL_URL_PATH, productId);
	}
	
	public static String getProductByCategoryPath(String categoryId, String page) {
		return TemplateUtil.getTenantContextPath() + String.format(CATEGORY_PAGE_URL_PATH, categoryId, page);
	}
	
	public static String getProductImageResource(Entity product, String type) {
		BinaryReference br = product.getValue("productImage");
	    if (br == null) {
	        return TemplateUtil.getStaticContentPath() + "/images/defaultImageForProduct.png";
	    }
	    return TemplateUtil.getTenantContextPath() + getBinaryResoucePath(br.getLobId(), type);
		
	}
	
	private static String getBinaryResoucePath(long lobId, String type) {
		return String.format(BINARY_RESOUCE_URL_PATH, lobId, type);
	}	
	
	public static String getProductsByBrand(String brandId, String searchInput) {
	    StringBuilder url = new StringBuilder(TemplateUtil.getTenantContextPath() + PRODUCTS_BY_BRAND_URL_PATH + "?");
	    boolean hasParam = false;

	    if (brandId != null && !brandId.isEmpty() && brandId != "") {
	        url.append("brandId=").append(brandId);
	        hasParam = true;
	    }

	    if (searchInput != null && !searchInput.isEmpty() && searchInput != "") {
	        if (hasParam) {
	            url.append("&");
	        }
	        url.append("searchInput=").append(searchInput);
	    }

	    return url.toString();
	}
	
	
	public static String getDeleteCartInfoPath(String deleteId) {
		return TemplateUtil.getTenantContextPath() + String.format(DELETE_CART_INFO_URL_PATH, deleteId);
	}
	
	public static String payment() {
		return TemplateUtil.getTenantContextPath() + PAYMENT_URL_PATH;
	}
	
	public static String cartPage() {
		return TemplateUtil.getTenantContextPath() + CART_INFO_URL_PATH;
	}
}
