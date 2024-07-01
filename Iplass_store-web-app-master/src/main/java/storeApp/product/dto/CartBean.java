package storeApp.product.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartBean implements Serializable {

	private List<CartItem> cartItems = new ArrayList<CartItem>();
	private long totalPrice = 0;
	
	public int getCartSize() {
		return this.cartItems.size();
	}
	
	public void addCartItem(String productId, long price) {
		for (CartItem item : this.cartItems) {
			
			if (item.getProductId().equals(productId)) {
				item.setQuantity(item.getQuantity() + 1);
				totalPrice += price;
				return;
			}
		}
		this.cartItems.add(new CartItem(productId, price));
		totalPrice += price;
	}
	
	public void removeCartItem(String productId) {
		for (int index = 0; index < this.cartItems.size(); index++) {
			CartItem item = this.cartItems.get(index);
			if (item.getProductId().equals(productId)) {
				this.cartItems.remove(index);
				totalPrice = totalPrice - item.getPrice() * item.getQuantity();
				return;
			}
		}
	}
	
	public void updateCartItem(String productId, Integer quantity) {
		for (int index = 0; index < this.cartItems.size(); index++) {
			CartItem item = this.cartItems.get(index);
			if (item.getProductId().equals(productId)) {
				item.setQuantity(quantity);
				totalPrice = totalPrice + (quantity - item.getQuantity()) * item.getQuantity();
				return;
			}
		}
	}
	
	public List<String> getProductIds() {
		List<String> productIds = this.cartItems.stream()
				.map(item -> item.getProductId())
				.collect(Collectors.toList());
		return productIds;
	}
	
	public long getTotalAmount() {
		long totalAmount = 0;
		for (CartItem item : this.cartItems) {
			totalAmount = totalAmount + item.getQuantity();
		}
		return totalAmount;
	}
	
	public CartBean(List<CartItem> cartItems, long totalPrice) {
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
	}

	public CartBean() {
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
