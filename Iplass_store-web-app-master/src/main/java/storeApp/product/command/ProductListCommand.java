package storeApp.product.command;

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
import storeApp.product.dto.Pagination;
import storeApp.product.entity.CategoryProduct;
import storeApp.product.entity.Product;

@ActionMapping(
	    name = "store-app/ProductListCommand", 
	    displayName = "ProductListCommand", 
	    privileged = true, 
		result = @Result(type=Type.JSP,
		value = "/jsp/store-app/ProductsPage.jsp",
		templateName="store-app/ProductsPage"),
	    command=@CommandConfig(commandClass=ProductListCommand.class))
@CommandClass(
		name = "store-app/ProductListCommand", 
		displayName = "ProductListCommand")
public class ProductListCommand implements Command{
	
	private final String PARAM_CATEGORY_ID = "idCategory";
	private final String PARAM_PAGE_INDEX = "page";
	private final String PRODUCT_CATEGORY_OID = Product.ID_CATEGORY + ".oid";
	private final Integer PRODUCT_LIMIT = 2;

	@Override
	  public String execute(RequestContext request) {
		
		String categoryId = request.getParam(PARAM_CATEGORY_ID);
		int pageIndex = 0;
		try {
			pageIndex = request.getParamAsInt(PARAM_PAGE_INDEX);
		} catch (RuntimeException e) {
		}
		
		Equals equals = null;
		equals = new Equals(PRODUCT_CATEGORY_OID, categoryId);

		int offset = pageIndex * PRODUCT_LIMIT;
		Limit limit = new Limit(PRODUCT_LIMIT, offset);
		String[] properties = new String[] { Product.OID, Product.NAME, Product.PRICE };
		List<Product> productList = EntityDaoHelper.searchDistinctEntity(Product.DEFINITION_NAME, equals, limit,
				properties);
		if (productList.size() > 0) {
			request.setAttribute("productList", productList);
		}
		int totalCount = EntityDaoHelper.countDistinct(Product.DEFINITION_NAME, equals);
		int totalPage = (int) Math.ceil((double) totalCount / PRODUCT_LIMIT);
		if (totalCount > 0) {
//			Pagination pagination = new Pagination(pageIndex, totalCount);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("totalPage", totalPage);
		}

		return Constants.CMD_EXEC_SUCCESS;
	  }
}
