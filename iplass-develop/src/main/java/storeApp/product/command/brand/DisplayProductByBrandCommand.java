package storeApp.product.command.brand;

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
import org.iplass.mtp.entity.query.condition.expr.And;
import org.iplass.mtp.entity.query.condition.expr.Or;
import org.iplass.mtp.entity.query.condition.predicate.Contains;
import org.iplass.mtp.entity.query.condition.predicate.Equals;
import org.iplass.mtp.entity.query.condition.predicate.Like;
import org.iplass.mtp.entity.query.condition.predicate.Like.MatchPattern;

import storeApp.product.dao.EntityDaoHelper;
import storeApp.product.entity.Product;

@ActionMapping(name = "store-app/product-by-brand", displayName = "product-by-brand", privileged = true, result = @Result(type = Type.JSP, value = "/jsp/store-app/ProductsByBrand.jsp", templateName = "store-app/productByBrand"), command = @CommandConfig(commandClass = DisplayProductByBrandCommand.class))
@CommandClass(name = "store-app/product-by-brand", displayName = "product by brand command")
public class DisplayProductByBrandCommand implements Command {

	private final String BRAND_ID = "brandId";
	private final String SEARCH_PARAM = "searchInput";
	private final String PRODUCT_BRAND_ID = Product.BRAND + ".oid";
	private final String PRODUCT_BRAND_NAME = Product.BRAND + ".name";
	private final String PRODUCT_CATEGORY_NAME = Product.CATEGORY + ".name";
	private final String PRODUCT_NAME = Product.NAME;
	private final int RESULT_LIMIT = 20;

	@Override
	public String execute(RequestContext request) {
		String brandId = request.getParam(BRAND_ID);
        String searchParam = request.getParam(SEARCH_PARAM);
        Limit limit = new Limit(RESULT_LIMIT);
        
        Equals brandCondition = null;
        Or searchCondition = null;
        And combinedCondition = null;

        if (brandId != null && !brandId.isEmpty()) {
            brandCondition = new Equals(PRODUCT_BRAND_ID, brandId);
        }

        if (searchParam != null && !searchParam.isEmpty()) {
            Like searchProductName = new Like(PRODUCT_NAME, searchParam, MatchPattern.PARTIAL);
            Like searchCategoryName = new Like(PRODUCT_CATEGORY_NAME, searchParam, MatchPattern.PARTIAL);
            Like searchBrandName = new Like(PRODUCT_BRAND_NAME, searchParam, MatchPattern.PARTIAL);
            searchCondition = new Or(searchProductName, searchCategoryName, searchBrandName);
        }

        if (brandCondition != null && searchCondition != null) {
            combinedCondition = new And(brandCondition, searchCondition);
        } else if (brandCondition != null) {
            combinedCondition = new And(brandCondition);
        } else if (searchCondition != null) {
            combinedCondition = new And(searchCondition);
        }

		String[] propertis = new String[] { Product.OID, Product.NAME, Product.PRICE, Product.PRODUCT_IMAGE };
		List<Product> productList = EntityDaoHelper.searchDistinctEntity(Product.DEFINITION_NAME, combinedCondition, limit,
				propertis);

		request.setAttribute("productList", productList);

		return Constants.CMD_EXEC_SUCCESS;
	}

}
