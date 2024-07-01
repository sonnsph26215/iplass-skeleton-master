package storeApp.product.dto;

import java.io.Serializable;

public class CartItem implements Serializable {
	
	private String productId;
	private Integer quantity;
	private long price;
	
	public CartItem(String productId, Integer quantity, long price) {
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public CartItem(String productId, long price) {
		this.productId = productId;
		this.quantity = 1;
		this.price = price;
	}

	public CartItem() {
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
}
