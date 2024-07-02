package storeApp.product.dto;

import java.io.Serializable;
import java.util.List;

import storeApp.product.entity.Brand;
import storeApp.product.entity.Product;

public class ProductCategoryDTO implements Serializable {
	
	private String oidCategory;
	private String nameCategory;
	private List<Product> products;
	private List<Brand> brands;
	

	public ProductCategoryDTO(String oidCategory, String nameCategory, List<Product> products, List<Brand> brands) {
		this.oidCategory = oidCategory;
		this.nameCategory = nameCategory;
		this.products = products;
		this.brands = brands;
	}


	public List<Brand> getBrands() {
		return brands;
	}


	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}


	public ProductCategoryDTO() {
	}

	public String getOidCategory() {
		return oidCategory;
	}

	public void setOidCategory(String oidCategory) {
		this.oidCategory = oidCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
