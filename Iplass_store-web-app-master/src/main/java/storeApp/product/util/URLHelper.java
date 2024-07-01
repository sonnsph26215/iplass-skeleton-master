package storeApp.product.util;

import org.iplass.mtp.web.template.TemplateUtil;

public class URLHelper {
	
	private final static String PACKAGE_URL_ROOT = "/store-app/";
	private final static String PRODUCT_DETAIL_URL_PATH = PACKAGE_URL_ROOT + "product-detail?id=%s";
	private final static String CATEGORY_PAGE_URL_PATH = PACKAGE_URL_ROOT + "ProductListCommand?idCategory=%s&page=%s";
	private final static String DELETE_CART_INFO_URL_PATH = PACKAGE_URL_ROOT + "cart/remove?deleteId=%s";

	public static String getProductDetailPath(String productId) {
		return TemplateUtil.getTenantContextPath() + String.format(PRODUCT_DETAIL_URL_PATH, productId);
	}
	
	public static String getProductByCategoryPath(String categoryId, String page) {
		return TemplateUtil.getTenantContextPath() + String.format(CATEGORY_PAGE_URL_PATH, categoryId, page);
	}
	
	public static String getDeleteCartInfoPath(String deleteId) {
		return TemplateUtil.getTenantContextPath() + String.format(DELETE_CART_INFO_URL_PATH, deleteId);
	}
	
}
