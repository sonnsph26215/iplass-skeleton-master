package storeApp.product.command.cart;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.webapi.RestJson;
import org.iplass.mtp.command.annotation.webapi.WebApi;
import org.iplass.mtp.webapi.definition.MethodType;
import org.iplass.mtp.webapi.definition.RequestType;

import storeApp.product.dto.CartBean;

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

		request.setAttribute(RESULT_PAGE, "SUCCESS");

		return Constants.CMD_EXEC_SUCCESS;
	}
}
