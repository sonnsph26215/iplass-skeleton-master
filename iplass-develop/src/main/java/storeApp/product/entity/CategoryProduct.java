package storeApp.product.entity;

import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.GenericEntity;
import storeApp.product.entity.Brand;

/**
 * Category Entity。
 */
public class CategoryProduct extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.CategoryProduct";

	/** Mã danh mục */
	public static final String CATEGORY_CODE = "categoryCode";
	/** Category Image */
	public static final String CATEGORY_IMAGE = "categoryImage";
	/** Brand */
	public static final String BRAND = "brand";

	public CategoryProduct() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Mã danh mụcを返します。
	 * 
	 * @return Mã danh mục
	 */
	public String getCategoryCode() {
		return getValue(CATEGORY_CODE);
	}

	/**
	 * Mã danh mụcを設定します。
	 * 
	 * @param categoryCode Mã danh mục
	 */
	public void setCategoryCode(String categoryCode) {
		setValue(CATEGORY_CODE, categoryCode);
	}

	/**
	 * Category Imageを返します。
	 * 
	 * @return Category Image
	 */
	public BinaryReference getCategoryImage() {
		return getValue(CATEGORY_IMAGE);
	}

	/**
	 * Category Imageを設定します。
	 * 
	 * @param categoryImage Category Image
	 */
	public void setCategoryImage(BinaryReference categoryImage) {
		setValue(CATEGORY_IMAGE, categoryImage);
	}

	/**
	 * Brandを返します。
	 * 
	 * @return Brand
	 */
	public Brand[] getBrand() {
		Object value = getValue(BRAND);
		if (value instanceof Brand) {
			return new Brand[]{(Brand)value};	//for search
		} else {
			return (Brand[])value;	//for load
		}
	}

	/**
	 * Brandを設定します。
	 * 
	 * @param brand Brand
	 */
	public void setBrand(Brand[] brand) {
		setValue(BRAND, brand);
	}

}
