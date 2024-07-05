package storeApp.product.entity;

import java.sql.Date;
import org.iplass.mtp.entity.GenericEntity;
import org.iplass.mtp.entity.SelectValue;
import storeApp.product.entity.Product;

/**
 * Order Entity。
 */
public class OrderProduct extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.OrderProduct";

	/** Mã order */
	public static final String ORDER_CODE = "orderCode";
	/** Gia sản phẩm order */
	public static final String ORDER_PRICE = "orderPrice";
	/** Ngày đặt */
	public static final String ORDER_DATE = "orderDate";
	/** Trạng thái order */
	public static final String ORDER_STATUS = "orderStatus";
	/** Số lượng sản phẩm trong order */
	public static final String QUANTITY = "quantity";
	/** productCode */
	public static final String PRODUCT_CODE = "productCode";
	/** Order Total Price */
	public static final String ORDER_TOTAL_PRICE = "orderTotalPrice";

	public OrderProduct() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Mã orderを返します。
	 * 
	 * @return Mã order
	 */
	public String getOrderCode() {
		return getValue(ORDER_CODE);
	}

	/**
	 * Mã orderを設定します。
	 * 
	 * @param orderCode Mã order
	 */
	public void setOrderCode(String orderCode) {
		setValue(ORDER_CODE, orderCode);
	}

	/**
	 * Gia sản phẩm orderを返します。
	 * 
	 * @return Gia sản phẩm order
	 */
	public Long getOrderPrice() {
		return getValue(ORDER_PRICE);
	}

	/**
	 * Gia sản phẩm orderを設定します。
	 * 
	 * @param orderPrice Gia sản phẩm order
	 */
	public void setOrderPrice(Long orderPrice) {
		setValue(ORDER_PRICE, orderPrice);
	}

	/**
	 * Ngày đặtを返します。
	 * 
	 * @return Ngày đặt
	 */
	public Date getOrderDate() {
		return getValue(ORDER_DATE);
	}

	/**
	 * Ngày đặtを設定します。
	 * 
	 * @param orderDate Ngày đặt
	 */
	public void setOrderDate(Date orderDate) {
		setValue(ORDER_DATE, orderDate);
	}

	/**
	 * Trạng thái orderを返します。
	 * 
	 * @return Trạng thái order
	 */
	public SelectValue getOrderStatus() {
		return getValue(ORDER_STATUS);
	}

	/**
	 * Trạng thái orderを設定します。
	 * 
	 * @param orderStatus Trạng thái order
	 */
	public void setOrderStatus(SelectValue orderStatus) {
		setValue(ORDER_STATUS, orderStatus);
	}

	/**
	 * Số lượng sản phẩm trong orderを返します。
	 * 
	 * @return Số lượng sản phẩm trong order
	 */
	public Long getQuantity() {
		return getValue(QUANTITY);
	}

	/**
	 * Số lượng sản phẩm trong orderを設定します。
	 * 
	 * @param quantity Số lượng sản phẩm trong order
	 */
	public void setQuantity(Long quantity) {
		setValue(QUANTITY, quantity);
	}

	/**
	 * productCodeを返します。
	 * 
	 * @return productCode
	 */
	public Product getProductCode() {
		return getValue(PRODUCT_CODE);
	}

	/**
	 * productCodeを設定します。
	 * 
	 * @param productCode productCode
	 */
	public void setProductCode(Product productCode) {
		setValue(PRODUCT_CODE, productCode);
	}

	/**
	 * Order Total Priceを返します。
	 * 
	 * @return Order Total Price
	 */
	public Long getOrderTotalPrice() {
		return getValue(ORDER_TOTAL_PRICE);
	}

	/**
	 * Order Total Priceを設定します。
	 * 
	 * @param orderTotalPrice Order Total Price
	 */
	public void setOrderTotalPrice(Long orderTotalPrice) {
		setValue(ORDER_TOTAL_PRICE, orderTotalPrice);
	}

}
