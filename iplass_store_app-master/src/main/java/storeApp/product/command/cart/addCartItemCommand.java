package storeApp.product.command.cart;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.webapi.RestJson;
import org.iplass.mtp.command.annotation.webapi.WebApi;
import org.iplass.mtp.webapi.definition.MethodType;
import org.iplass.mtp.webapi.definition.RequestType;

import storeApp.product.dao.EntityDaoHelper;
import storeApp.product.dto.CartBean;
import storeApp.product.entity.Product;

@WebApi(
		name = "store-app/cart/add", 
		displayName = "addCart", 
		accepts = RequestType.REST_JSON, 
		methods = MethodType.POST, 
		privileged = true,  
		synchronizeOnSession = true,
		restJson = @RestJson(parameterName = "param"), 
		results = addCartItemCommand.RESULT_TOTAL_AMOUNT)
@CommandClass(
		name = "store-app/cart/add", 
		displayName = "addCart")
public class addCartItemCommand implements Command {

	private final String PARAM_PRODUCT_ID = "productId";
	public final static String RESULT_TOTAL_AMOUNT = "totalAmount";
	private final String CART_BEAN_SESSION_KEY = "cart-bean";
	
	public String execute(RequestContext request) {
		String productId = request.getParam(PARAM_PRODUCT_ID);
		
		CartBean cartBean = (CartBean) request.getSession().getAttribute(CART_BEAN_SESSION_KEY);
		if (cartBean == null) {
			cartBean = new CartBean();
			request.getSession().setAttribute(CART_BEAN_SESSION_KEY, cartBean);
		} 
		Product product = EntityDaoHelper.load(Product.DEFINITION_NAME, productId);

		Long price = product.getPrice();
		cartBean.addCartItem(productId, price);
		request.setAttribute(RESULT_TOTAL_AMOUNT, cartBean.getTotalAmount());

		return Constants.CMD_EXEC_SUCCESS;
	}
}
