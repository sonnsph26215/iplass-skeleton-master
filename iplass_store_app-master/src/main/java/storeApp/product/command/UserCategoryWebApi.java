package storeApp.product.command;

import java.util.ArrayList;
import java.util.List;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.webapi.WebApi;
import org.iplass.mtp.entity.GenericEntity;
import org.iplass.mtp.entity.query.condition.predicate.Equals;
import org.iplass.mtp.webapi.definition.MethodType;
import org.iplass.mtp.webapi.definition.RequestType;

import storeApp.product.dao.EntityDaoHelper;
import storeApp.product.dto.ProductCategoryDTO;
import storeApp.product.entity.CategoryProduct;
import storeApp.product.entity.Product;

@WebApi(name = "store-app/HomePageWebApi", 
accepts = RequestType.REST_FORM, 
methods = MethodType.GET, 
privileged = true, 
checkXRequestedWithHeader = false, 
responseType = "application/json", 
results = UserCategoryWebApi.RESULT_DEFAULT_RESULT)
@CommandClass(name = "store-app/HomePageWebApi", displayName = "Display category list (json)")

public class UserCategoryWebApi implements Command {
	public static final String RESULT_DEFAULT_RESULT = "defaultResult";
	private final String PRODUCT_CATEGORY_OID = Product.CATEGORY + ".oid";

	@Override
	public String execute(RequestContext request) {
		// TODO Auto-generated method stub
		String[] cateProperties = new String[] { CategoryProduct.OID, CategoryProduct.NAME,
				CategoryProduct.CATEGORY_CODE };

		List<CategoryProduct> categoryList = EntityDaoHelper.searchDistinctEntity(CategoryProduct.DEFINITION_NAME, null,
				cateProperties);

		List<ProductCategoryDTO> productCategoryDTOList = new ArrayList<ProductCategoryDTO>();

		String[] productProperties = new String[] { Product.OID, Product.NAME, Product.PRICE };

		int totalCategoryCount = EntityDaoHelper.countDistinct(CategoryProduct.DEFINITION_NAME, null);

		for (int i = 0; i < totalCategoryCount; i++) {

			 Equals equals = new Equals(PRODUCT_CATEGORY_OID, categoryList.get(i).getOid()); 

			List<Product> productList = EntityDaoHelper.searchDistinctEntity(Product.DEFINITION_NAME, equals, productProperties);
			if (productList.size() > 0) {

				ProductCategoryDTO categoryDTO = new ProductCategoryDTO();

				categoryDTO.setOidCategory(categoryList.get(i).getOid());
				categoryDTO.setNameCategory(categoryList.get(i).getName());

				categoryDTO.setProducts(productList);
				productCategoryDTOList.add(categoryDTO);
			}
		}

		// Đặt danh sách đã lọc vào request attribute
		request.setAttribute(RESULT_DEFAULT_RESULT, productCategoryDTOList);

		return Constants.CMD_EXEC_SUCCESS;
	}

}
