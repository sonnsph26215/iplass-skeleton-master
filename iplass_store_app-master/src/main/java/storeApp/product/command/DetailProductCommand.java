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

import storeApp.product.dao.EntityDaoHelper;
import storeApp.product.entity.CategoryProduct;
import storeApp.product.entity.Product;
import storeApp.product.entity.ReviewProduct;

@ActionMapping(name = "store-app/product-detail", 
displayName = "product detail", 
privileged = true, 
result = @Result(type = Type.JSP, value = "/jsp/store-app/ProductsDetailPage.jsp", 
templateName = "store-app/DetailProductsPage"), 
command = @CommandConfig(commandClass = DetailProductCommand.class))
@CommandClass(name = "store-app/product-detail", displayName = "product-detail")
public class DetailProductCommand implements Command {

	private final String PARAM_PRODUCT_ID = "id";
	@SuppressWarnings("unused")
	private final String PRODUCT_CATEGORY_OID = Product.CODE_PRODUCT + "." + CategoryProduct.OID;
	private final int RESULT_LIMIT = 15;

	@Override
	public String execute(RequestContext request) {
		String productId = request.getParam(PARAM_PRODUCT_ID);
		// 対象カテゴリの商品一覧の検索
		Product product = EntityDaoHelper.load(Product.DEFINITION_NAME, productId);
		if (product == null) {
			return Constants.CMD_EXEC_SUCCESS;
		}
		request.setAttribute("productInfo", product);
		
		Limit limit = new Limit(RESULT_LIMIT);
		String[] propertis = new String[] { Product.OID, Product.NAME, Product.PRICE};
		List<Product> productList = EntityDaoHelper.searchDistinctEntity(Product.DEFINITION_NAME, null, limit, propertis);
		if (productList.size() > 0) {
			request.setAttribute("productList", productList);
		}
//		review
		Limit limitrv = new Limit(5);
		String[] propertisRV = new String[] { ReviewProduct.NAME_REVIEW, ReviewProduct.VOTE_REVIEW, ReviewProduct.COMMENT_REVIEW, ReviewProduct.START_DATE_REVIEW};
		List<ReviewProduct> reviewProducts = EntityDaoHelper.searchDistinctEntity(ReviewProduct.DEFINITION_NAME, null, limitrv, propertisRV);
		request.setAttribute("review", reviewProducts);
		
		return Constants.CMD_EXEC_SUCCESS;
	}
	
}
