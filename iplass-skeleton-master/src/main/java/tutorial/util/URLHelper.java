package tutorial.util;

import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.web.template.TemplateUtil;


public class URLHelper {

	private final static String PACKAGE_URL_ROOT = "/tutorial/";
	private final static String PRODUCT_DETAIL_URL_PATH = PACKAGE_URL_ROOT + "product/detail?productId=%s";
	private final static String PRODUCT_LIST_URL_PATH = PACKAGE_URL_ROOT + "product/list";
	private final static String BINARY_RESOUCE_URL_PATH = PACKAGE_URL_ROOT + "resource/bin?id=%d&type=%s";
	public static final String BIN_TYPE_PRODUCT_IMG = "image";
	
	public static String getProductImageResource(Entity product, String propertyName) {
		BinaryReference br = product.getValue(propertyName);
		return TemplateUtil.getTenantContextPath() + getBinaryResoucePath(br.getLobId(), BIN_TYPE_PRODUCT_IMG);
	}
	
	private static String getBinaryResoucePath(long lobId, String type) {
		return String.format(BINARY_RESOUCE_URL_PATH, lobId, type);
	}
	
	public static String getProductDetailPath(String productId) {
		return TemplateUtil.getTenantContextPath() + String.format(PRODUCT_DETAIL_URL_PATH, productId);
	}
	
	public static String getProductListPath() {
		return TemplateUtil.getTenantContextPath() + String.format(PRODUCT_LIST_URL_PATH);
	}
	
}
