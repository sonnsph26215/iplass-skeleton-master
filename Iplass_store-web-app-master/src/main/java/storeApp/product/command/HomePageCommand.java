package storeApp.product.command;

import java.util.ArrayList;
import java.util.List;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.CommandConfig;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;
import org.iplass.mtp.entity.query.Limit;
import org.iplass.mtp.entity.query.condition.predicate.Equals;

import storeApp.product.dao.EntityDaoHelper;
import storeApp.product.dto.ProductCategoryDTO;
import storeApp.product.entity.CategoryProduct;
import storeApp.product.entity.Product;

@ActionMapping(
	    name = "store-app/homepage", 
	    displayName = "homepage", 
	    privileged = true, 
		result = @Result(type=Type.JSP,
		value = "/jsp/store-app/homepage.jsp",
		templateName="store-app/homepage"),
	    command=@CommandConfig(commandClass=HomePageCommand.class))
@CommandClass(
		name = "store-app/homepage", 
		displayName = "homepage")
public class HomePageCommand implements Command {

	private final String PRODUCT_CATEGORY_OID = Product.ID_CATEGORY + ".oid";
	private final Integer PRODUCT_LIMIT = 10;

	@Override
	  public String execute(RequestContext request) {
		
		int totalCategoryCount = EntityDaoHelper.countDistinct(CategoryProduct.DEFINITION_NAME, null);
		request.setAttribute("totalCategoryCount", totalCategoryCount);
		
		String[] propertiesCategory = new String[] { CategoryProduct.OID, CategoryProduct.NAME};
		List<CategoryProduct> categoryProducts = EntityDaoHelper.searchDistinctEntity(CategoryProduct.DEFINITION_NAME, null, propertiesCategory);
		
		Limit limit = new Limit(PRODUCT_LIMIT);
		String[] properties = new String[] { Product.OID, Product.NAME, Product.PRICE };
		
		List<ProductCategoryDTO> list = new ArrayList<ProductCategoryDTO>();
		
		for(int i = 0; i < totalCategoryCount; i++) {
			Equals equals = new Equals(PRODUCT_CATEGORY_OID, categoryProducts.get(i).getOid());
			
			List<Product> productList = EntityDaoHelper.searchDistinctEntity(Product.DEFINITION_NAME, equals, limit,
					properties);
			if (productList.size() > 0) {
				
				ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
				categoryDTO.setOidCategory(categoryProducts.get(i).getOid());
				categoryDTO.setNameCategory(categoryProducts.get(i).getName());
				categoryDTO.setProducts(productList);
				list.add(categoryDTO);
			}
		}
		
		request.setAttribute("productList", list);
		
		return Constants.CMD_EXEC_SUCCESS;
	  }
	
}
