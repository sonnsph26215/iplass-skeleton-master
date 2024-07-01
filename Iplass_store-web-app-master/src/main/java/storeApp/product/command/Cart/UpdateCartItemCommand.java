package storeApp.product.command.Cart;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;
import org.iplass.mtp.command.annotation.webapi.RestJson;
import org.iplass.mtp.command.annotation.webapi.WebApi;
import org.iplass.mtp.command.beanmapper.MappingException;
import org.iplass.mtp.entity.query.condition.predicate.In;
import org.iplass.mtp.webapi.definition.MethodType;
import org.iplass.mtp.webapi.definition.RequestType;

import storeApp.product.dao.EntityDaoHelper;
import storeApp.product.dto.CartBean;
import storeApp.product.dto.CartItem;
import storeApp.product.entity.Product;

@WebApi(
		name = "store-app/cart/edit", 
		displayName = "editCart", 
		accepts = RequestType.REST_JSON, 
		methods = MethodType.POST, 
		privileged = true,  
		synchronizeOnSession = true,
		restJson = @RestJson(parameterName = "param"), 
		results = UpdateCartItemCommand.RESULT_PAGE)
@CommandClass(
		name = "store-app/cart/edit", 
		displayName = "editCart")
public class UpdateCartItemCommand implements Command {

	private final String CART_BEAN_SESSION_KEY = "cart-bean";
	private final String PARAM_PRODUCT_ID = "productId";
	private final String PARAM_PRODUCT_QUANTITY = "quantity";
	public final static String RESULT_PAGE = "result";

	@Override
	public String execute(RequestContext request) {
		String productId = request.getParam(PARAM_PRODUCT_ID);
		String quantity = request.getParam(PARAM_PRODUCT_QUANTITY);
		
		CartBean cartBean = (CartBean) request.getSession().getAttribute(CART_BEAN_SESSION_KEY);
		
		cartBean.updateCartItem(productId, Integer.parseInt(quantity));
		
//		CartBean cartBean = new CartBean();
//
//		Object[] productIds = cartBean.getProductIds().toArray();
//		In in = new In(Product.OID, productIds);
//		String[] properties = new String[] { Product.OID, Product.PRICE };
//		List<Product> products = EntityDaoHelper.searchDistinctEntity(Product.DEFINITION_NAME, in, properties);
//
//		Map<String, Long> prices = products.stream().collect(Collectors.toMap(Product::getOid, Product::getPrice));
//
//		cartBean.recaculate(prices);
//
//		request.getSession().setAttribute(CART_BEAN_SESSION_KEY, cartBean);
//
		request.setAttribute(RESULT_PAGE, "SUCCESS");

		return Constants.CMD_EXEC_SUCCESS;
	}
}
