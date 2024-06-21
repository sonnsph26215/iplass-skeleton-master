package tutorial.entity;

import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.entity.GenericEntity;

public class Product extends GenericEntity{

	private static final long serialVersionUID = 1L;

	public static final String DEFINITION_NAME = "tutorial.product.Product";

	public static final String PRICE = "price";
	public static final String PRODUCT_CATEGORY = "productCategory";
	public static final String IMAGE = "image";
	public static final String NOTE = "note";

	public Product() {
		setDefinitionName(DEFINITION_NAME);
	}

	public Long getPrice() {
		return getValue(PRICE);
	}

	public void setPrice(Long price) {
		setValue(PRICE, price);
	}

	public ProductCategory getProductCategory() {
		return getValue(PRODUCT_CATEGORY);
	}

	public void setProductCategory(ProductCategory productCategory) {
		setValue(PRODUCT_CATEGORY, productCategory);
	}

	public BinaryReference getImage() {
		return getValue(IMAGE);
	}

	public void setImage(BinaryReference image) {
		setValue(IMAGE, image);
	}
	
	public String getNote() {
		return getValue(NOTE);
	}

	public void setNote(String note) {
		setValue(NOTE, note);
	}

}
