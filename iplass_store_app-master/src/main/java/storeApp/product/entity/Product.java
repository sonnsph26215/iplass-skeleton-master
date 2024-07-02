package storeApp.product.entity;

import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.GenericEntity;
import storeApp.product.entity.Brand;
import storeApp.product.entity.CategoryProduct;
import storeApp.product.entity.ProductImage;
import storeApp.product.entity.Specifications;

/**
 * Product Entity。
 */
public class Product extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.Product";

	/** Mã sản phẩm */
	public static final String CODE_PRODUCT = "codeProduct";
	/** Tên sản phẩm */
	public static final String PRODUCT_NAME = "productName";
	/** Giá */
	public static final String PRICE = "price";
	/** Số lượng */
	public static final String QUANTITY = "quantity";
	/** Thông tin sản phẩm */
	public static final String INFORM_PRODUCT = "informProduct";
	/** Lượt yêu thích */
	public static final String FAVORITES = "favorites";
	/** Ưu đãi */
	public static final String ENDOW = "endow";
	/** Màu sắc */
	public static final String COLOR = "color";
	/** ProductImage */
	public static final String PRODUCT_IMAGE = "productImage";
	/** Thông số kỹ thuật */
	public static final String SPECIFICATIONS = "specifications";
	/** Product Image */
	public static final String PRODUCT_IMG = "productImg";
	/** Category */
	public static final String CATEGORY = "category";
	/** Brand */
	public static final String BRAND = "brand";
	/** Old Price */
	public static final String OLD_PRICE = "oldPrice";

	public Product() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Mã sản phẩmを返します。
	 * 
	 * @return Mã sản phẩm
	 */
	public String getCodeProduct() {
		return getValue(CODE_PRODUCT);
	}

	/**
	 * Mã sản phẩmを設定します。
	 * 
	 * @param codeProduct Mã sản phẩm
	 */
	public void setCodeProduct(String codeProduct) {
		setValue(CODE_PRODUCT, codeProduct);
	}

	/**
	 * Tên sản phẩmを返します。
	 * 
	 * @return Tên sản phẩm
	 */
	public String getProductName() {
		return getValue(PRODUCT_NAME);
	}

	/**
	 * Tên sản phẩmを設定します。
	 * 
	 * @param productName Tên sản phẩm
	 */
	public void setProductName(String productName) {
		setValue(PRODUCT_NAME, productName);
	}

	/**
	 * Giáを返します。
	 * 
	 * @return Giá
	 */
	public Long getPrice() {
		return getValue(PRICE);
	}

	/**
	 * Giáを設定します。
	 * 
	 * @param price Giá
	 */
	public void setPrice(Long price) {
		setValue(PRICE, price);
	}

	/**
	 * Số lượngを返します。
	 * 
	 * @return Số lượng
	 */
	public Long getQuantity() {
		return getValue(QUANTITY);
	}

	/**
	 * Số lượngを設定します。
	 * 
	 * @param quantity Số lượng
	 */
	public void setQuantity(Long quantity) {
		setValue(QUANTITY, quantity);
	}

	/**
	 * Thông tin sản phẩmを返します。
	 * 
	 * @return Thông tin sản phẩm
	 */
	public String getInformProduct() {
		return getValue(INFORM_PRODUCT);
	}

	/**
	 * Thông tin sản phẩmを設定します。
	 * 
	 * @param informProduct Thông tin sản phẩm
	 */
	public void setInformProduct(String informProduct) {
		setValue(INFORM_PRODUCT, informProduct);
	}

	/**
	 * Lượt yêu thíchを返します。
	 * 
	 * @return Lượt yêu thích
	 */
	public Long getFavorites() {
		return getValue(FAVORITES);
	}

	/**
	 * Lượt yêu thíchを設定します。
	 * 
	 * @param favorites Lượt yêu thích
	 */
	public void setFavorites(Long favorites) {
		setValue(FAVORITES, favorites);
	}

	/**
	 * Ưu đãiを返します。
	 * 
	 * @return Ưu đãi
	 */
	public String getEndow() {
		return getValue(ENDOW);
	}

	/**
	 * Ưu đãiを設定します。
	 * 
	 * @param endow Ưu đãi
	 */
	public void setEndow(String endow) {
		setValue(ENDOW, endow);
	}

	/**
	 * Màu sắcを返します。
	 * 
	 * @return Màu sắc
	 */
	public String getColor() {
		return getValue(COLOR);
	}

	/**
	 * Màu sắcを設定します。
	 * 
	 * @param color Màu sắc
	 */
	public void setColor(String color) {
		setValue(COLOR, color);
	}

	/**
	 * ProductImageを返します。
	 * 
	 * @return ProductImage
	 */
	public BinaryReference getProductImage() {
		return getValue(PRODUCT_IMAGE);
	}

	/**
	 * ProductImageを設定します。
	 * 
	 * @param productImage ProductImage
	 */
	public void setProductImage(BinaryReference productImage) {
		setValue(PRODUCT_IMAGE, productImage);
	}

	/**
	 * Thông số kỹ thuậtを返します。
	 * 
	 * @return Thông số kỹ thuật
	 */
	public Specifications getSpecifications() {
		return getValue(SPECIFICATIONS);
	}

	/**
	 * Thông số kỹ thuậtを設定します。
	 * 
	 * @param specifications Thông số kỹ thuật
	 */
	public void setSpecifications(Specifications specifications) {
		setValue(SPECIFICATIONS, specifications);
	}

	/**
	 * Product Imageを返します。
	 * 
	 * @return Product Image
	 */
	public ProductImage[] getProductImg() {
		Object value = getValue(PRODUCT_IMG);
		if (value instanceof ProductImage) {
			return new ProductImage[]{(ProductImage)value};	//for search
		} else {
			return (ProductImage[])value;	//for load
		}
	}

	/**
	 * Product Imageを設定します。
	 * 
	 * @param productImg Product Image
	 */
	public void setProductImg(ProductImage[] productImg) {
		setValue(PRODUCT_IMG, productImg);
	}

	/**
	 * Categoryを返します。
	 * 
	 * @return Category
	 */
	public CategoryProduct getCategory() {
		return getValue(CATEGORY);
	}

	/**
	 * Categoryを設定します。
	 * 
	 * @param category Category
	 */
	public void setCategory(CategoryProduct category) {
		setValue(CATEGORY, category);
	}

	/**
	 * Brandを返します。
	 * 
	 * @return Brand
	 */
	public Brand getBrand() {
		return getValue(BRAND);
	}

	/**
	 * Brandを設定します。
	 * 
	 * @param brand Brand
	 */
	public void setBrand(Brand brand) {
		setValue(BRAND, brand);
	}

	/**
	 * Old Priceを返します。
	 * 
	 * @return Old Price
	 */
	public Long getOldPrice() {
		return getValue(OLD_PRICE);
	}

	/**
	 * Old Priceを設定します。
	 * 
	 * @param oldPrice Old Price
	 */
	public void setOldPrice(Long oldPrice) {
		setValue(OLD_PRICE, oldPrice);
	}

}
