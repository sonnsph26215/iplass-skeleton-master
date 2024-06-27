package storeApp.product.entity;

import org.iplass.mtp.entity.GenericEntity;

public class Product extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.Product";
	/** Mã sản phẩm */
	public static final String CODE_PRODUCT = "codeProduct";
	/** Tên sản phẩm */
	public static final String PRODUCT_NAME = "productName";
	/** Hình ảnh sản phẩm */
	public static final String URL_IMAGE = "urlImage";
	/** Giá */
	public static final String PRICE = "price";
	/** Số lượng */
	public static final String QUANTITY = "quantity";
	/** Thông tin sản phẩm */
	public static final String INFORM_PRODUCT = "informProduct";
	/** Nhà sản xuất */
	public static final String PRODUCER = "producer";
	/** Lượt yêu thích */
	public static final String FAVORITES = "favorites";
	/** Ưu đãi */
	public static final String ENDOW = "endow";
	/** Màu sắc */
	public static final String COLOR = "color";
	/** Thông số kỹ thuật */
	public static final String SPECIFICATIONS = "specifications";
	/** id danh mục sản phẩm */
	public static final String ID_CATEGORY = "idCategory";
	/** Id bảng review đánh giá sản phẩm */
	public static final String ID_REVIEW_PRODUCT = "idReviewProduct";

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
	 * Hình ảnh sản phẩmを返します。
	 * 
	 * @return Hình ảnh sản phẩm
	 */
	public String getUrlImage() {
		return getValue(URL_IMAGE);
	}

	/**
	 * Hình ảnh sản phẩmを設定します。
	 * 
	 * @param urlImage Hình ảnh sản phẩm
	 */
	public void setUrlImage(String urlImage) {
		setValue(URL_IMAGE, urlImage);
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
	 * Nhà sản xuấtを返します。
	 * 
	 * @return Nhà sản xuất
	 */
	public String getProducer() {
		return getValue(PRODUCER);
	}

	/**
	 * Nhà sản xuấtを設定します。
	 * 
	 * @param producer Nhà sản xuất
	 */
	public void setProducer(String producer) {
		setValue(PRODUCER, producer);
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
	 * Thông số kỹ thuậtを返します。
	 * 
	 * @return Thông số kỹ thuật
	 */
	public String getSpecifications() {
		return getValue(SPECIFICATIONS);
	}

	/**
	 * Thông số kỹ thuậtを設定します。
	 * 
	 * @param specifications Thông số kỹ thuật
	 */
	public void setSpecifications(String specifications) {
		setValue(SPECIFICATIONS, specifications);
	}

	/**
	 * id danh mục sản phẩmを返します。
	 * 
	 * @return id danh mục sản phẩm
	 */
	public CategoryProduct getIdCategory() {
		return getValue(ID_CATEGORY);
	}

	/**
	 * id danh mục sản phẩmを設定します。
	 * 
	 * @param idCategory id danh mục sản phẩm
	 */
	public void setIdCategory(CategoryProduct idCategory) {
		setValue(ID_CATEGORY, idCategory);
	}

	/**
	 * Id bảng review đánh giá sản phẩmを返します。
	 * 
	 * @return Id bảng review đánh giá sản phẩm
	 */
	public ReviewProduct[] getIdReviewProduct() {
		Object value = getValue(ID_REVIEW_PRODUCT);
		if (value instanceof ReviewProduct) {
			return new ReviewProduct[]{(ReviewProduct)value};	//for search
		} else {
			return (ReviewProduct[])value;	//for load
		}
	}

	/**
	 * Id bảng review đánh giá sản phẩmを設定します。
	 * 
	 * @param idReviewProduct Id bảng review đánh giá sản phẩm
	 */
	public void setIdReviewProduct(ReviewProduct[] idReviewProduct) {
		setValue(ID_REVIEW_PRODUCT, idReviewProduct);
	}
	
}
