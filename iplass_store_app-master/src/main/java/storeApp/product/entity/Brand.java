package storeApp.product.entity;

import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.GenericEntity;
import storeApp.product.entity.CategoryProduct;

/**
 * Brand Entity。
 */
public class Brand extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.Brand";

	/** Brand Image */
	public static final String BRAND_IMAGE = "brandImage";
	/** Category */
	public static final String CATEGORY = "category";

	public Brand() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Brand Imageを返します。
	 * 
	 * @return Brand Image
	 */
	public BinaryReference getBrandImage() {
		return getValue(BRAND_IMAGE);
	}

	/**
	 * Brand Imageを設定します。
	 * 
	 * @param brandImage Brand Image
	 */
	public void setBrandImage(BinaryReference brandImage) {
		setValue(BRAND_IMAGE, brandImage);
	}

	/**
	 * Categoryを返します。
	 * 
	 * @return Category
	 */
	public CategoryProduct[] getCategory() {
		Object value = getValue(CATEGORY);
		if (value instanceof CategoryProduct) {
			return new CategoryProduct[]{(CategoryProduct)value};	//for search
		} else {
			return (CategoryProduct[])value;	//for load
		}
	}

	/**
	 * Categoryを設定します。
	 * 
	 * @param category Category
	 */
	public void setCategory(CategoryProduct[] category) {
		setValue(CATEGORY, category);
	}

}
