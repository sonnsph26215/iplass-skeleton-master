package tutorial.entity;

import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.entity.GenericEntity;

public class ProductCategory extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "tutorial.product.ProductCategory";

	/** parentCategory */
	public static final String PARENT_CATEGORY = "parentCategory";

	public ProductCategory() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * parentCategoryを返します。
	 * 
	 * @return parentCategory
	 */
	public Entity getParentCategory() {
		return getValue(PARENT_CATEGORY);
	}

	/**
	 * parentCategoryを設定します。
	 * 
	 * @param parentCategory parentCategory
	 */
	public void setParentCategory(Entity parentCategory) {
		setValue(PARENT_CATEGORY, parentCategory);
	}
	
}
