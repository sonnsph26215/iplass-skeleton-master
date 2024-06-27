package storeApp.product.entity;

import java.sql.Timestamp;
import org.iplass.mtp.auth.User;
import org.iplass.mtp.entity.GenericEntity;
import org.iplass.mtp.entity.SelectValue;

public class Payment extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.Payment";

	/** Số tiền phải thanh toán */
	public static final String PAY_TUITION = "payTuition";
	/** Trạng thái thanh toán */
	public static final String PAY_STATUS = "payStatus";
	/** Ngày thanh toán */
	public static final String PAY_DATE = "payDate";
	/** Phương thức thanh toán */
	public static final String PAY_METHOD = "payMethod";
	/** Mã thẻ thanh toán */
	public static final String PAY_NUMBER = "payNumber";
	/** bill */
	public static final String PAY_BILL = "payBill";
	/** CustomerID */
	public static final String CUSTOMER_I_D = "customerID";
	/** OrderID */
	public static final String ORDER_I_D = "orderID";
	/** ProductID */
	public static final String PRODUCT_I_D = "productID";

	public Payment() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Số tiền phải thanh toánを返します。
	 * 
	 * @return Số tiền phải thanh toán
	 */
	public Long getPayTuition() {
		return getValue(PAY_TUITION);
	}

	/**
	 * Số tiền phải thanh toánを設定します。
	 * 
	 * @param payTuition Số tiền phải thanh toán
	 */
	public void setPayTuition(Long payTuition) {
		setValue(PAY_TUITION, payTuition);
	}

	/**
	 * Trạng thái thanh toánを返します。
	 * 
	 * @return Trạng thái thanh toán
	 */
	public SelectValue getPayStatus() {
		return getValue(PAY_STATUS);
	}

	/**
	 * Trạng thái thanh toánを設定します。
	 * 
	 * @param payStatus Trạng thái thanh toán
	 */
	public void setPayStatus(SelectValue payStatus) {
		setValue(PAY_STATUS, payStatus);
	}

	/**
	 * Ngày thanh toánを返します。
	 * 
	 * @return Ngày thanh toán
	 */
	public Timestamp getPayDate() {
		return getValue(PAY_DATE);
	}

	/**
	 * Ngày thanh toánを設定します。
	 * 
	 * @param payDate Ngày thanh toán
	 */
	public void setPayDate(Timestamp payDate) {
		setValue(PAY_DATE, payDate);
	}

	/**
	 * Phương thức thanh toánを返します。
	 * 
	 * @return Phương thức thanh toán
	 */
	public SelectValue getPayMethod() {
		return getValue(PAY_METHOD);
	}

	/**
	 * Phương thức thanh toánを設定します。
	 * 
	 * @param payMethod Phương thức thanh toán
	 */
	public void setPayMethod(SelectValue payMethod) {
		setValue(PAY_METHOD, payMethod);
	}

	/**
	 * Mã thẻ thanh toánを返します。
	 * 
	 * @return Mã thẻ thanh toán
	 */
	public String getPayNumber() {
		return getValue(PAY_NUMBER);
	}

	/**
	 * Mã thẻ thanh toánを設定します。
	 * 
	 * @param payNumber Mã thẻ thanh toán
	 */
	public void setPayNumber(String payNumber) {
		setValue(PAY_NUMBER, payNumber);
	}

	/**
	 * billを返します。
	 * 
	 * @return bill
	 */
	public String getPayBill() {
		return getValue(PAY_BILL);
	}

	/**
	 * billを設定します。
	 * 
	 * @param payBill bill
	 */
	public void setPayBill(String payBill) {
		setValue(PAY_BILL, payBill);
	}

	/**
	 * CustomerIDを返します。
	 * 
	 * @return CustomerID
	 */
	public User getCustomerID() {
		return getValue(CUSTOMER_I_D);
	}

	/**
	 * CustomerIDを設定します。
	 * 
	 * @param customerID CustomerID
	 */
	public void setCustomerID(User customerID) {
		setValue(CUSTOMER_I_D, customerID);
	}

	/**
	 * OrderIDを返します。
	 * 
	 * @return OrderID
	 */
	public OrderProduct getOrderID() {
		return getValue(ORDER_I_D);
	}

	/**
	 * OrderIDを設定します。
	 * 
	 * @param orderID OrderID
	 */
	public void setOrderID(OrderProduct orderID) {
		setValue(ORDER_I_D, orderID);
	}

	/**
	 * ProductIDを返します。
	 * 
	 * @return ProductID
	 */
	public Product getProductID() {
		return getValue(PRODUCT_I_D);
	}

	/**
	 * ProductIDを設定します。
	 * 
	 * @param productID ProductID
	 */
	public void setProductID(Product productID) {
		setValue(PRODUCT_I_D, productID);
	}
	
}
