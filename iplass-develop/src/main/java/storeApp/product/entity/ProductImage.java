package storeApp.product.entity;

import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.GenericEntity;
import org.iplass.mtp.entity.SelectValue;

/**
 * Product Image Entity。
 */
public class ProductImage extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.ProductImage";

	/** Product Image */
	public static final String PRODUCT_IMAGE = "productImage";
	/** Image Flag */
	public static final String IMAGE_FLAG = "ImageFlag";

	public ProductImage() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Product Imageを返します。
	 * 
	 * @return Product Image
	 */
	public BinaryReference getProductImage() {
		return getValue(PRODUCT_IMAGE);
	}

	/**
	 * Product Imageを設定します。
	 * 
	 * @param productImage Product Image
	 */
	public void setProductImage(BinaryReference productImage) {
		setValue(PRODUCT_IMAGE, productImage);
	}

	/**
	 * Image Flagを返します。
	 * 
	 * @return Image Flag
	 */
	public SelectValue getImageFlag() {
		return getValue(IMAGE_FLAG);
	}

	/**
	 * Image Flagを設定します。
	 * 
	 * @param ImageFlag Image Flag
	 */
	public void setImageFlag(SelectValue ImageFlag) {
		setValue(IMAGE_FLAG, ImageFlag);
	}

}
