package storeApp.product.dto;

import java.io.Serializable;

import storeApp.product.entity.Product;

public class ShowCart implements Serializable {

	private Product product;
	private Integer quantity;
	private long totalPrice;
	
	public ShowCart(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = product.getPrice() * quantity;
	}

	public ShowCart() {
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
