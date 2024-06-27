package storeApp.product.entity;

import org.iplass.mtp.entity.GenericEntity;

public class CategoryProduct extends GenericEntity{

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.CategoryProduct";

	/** Mã danh mục */
	public static final String CATEGORY_CODE = "categoryCode";
	/** parentCategory */
	public static final String PARENT_CATEGORY = "parentCategory";

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
	 * parentCategoryを返します。
	 * 
	 * @return parentCategory
	 */
	public CategoryProduct getParentCategory() {
		return getValue(PARENT_CATEGORY);
	}

	/**
	 * parentCategoryを設定します。
	 * 
	 * @param parentCategory parentCategory
	 */
	public void setParentCategory(CategoryProduct parentCategory) {
		setValue(PARENT_CATEGORY, parentCategory);
	}
	
}
