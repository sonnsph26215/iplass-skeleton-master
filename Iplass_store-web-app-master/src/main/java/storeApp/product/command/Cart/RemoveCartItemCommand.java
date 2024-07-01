package storeApp.product.command.Cart;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;

import storeApp.product.dto.CartBean;

@ActionMapping(
		name = "store-app/cart/remove", 
		displayName = "removeCart", 
		privilaged = true,
		synchronizeOnSession = true,
		result = @Result(
				type = Type.REDIRECT, 
				value = RemoveCartItemCommand.RESULT_REDIRECT_URL))
@CommandClass(
		name = "store-app/cart/remove", 
		displayName = "removeCart")
public class RemoveCartItemCommand implements Command { 
	
	private final String PARAM_DELETE_ID = "deleteId";
	public static final String RESULT_REDIRECT_URL="redirectURL";
	private final String CART_BEAN_SESSION_KEY = "cart-bean";

	@Override
	public String execute(RequestContext request) {
		String deleteId = request.getParam(PARAM_DELETE_ID);
		
		CartBean cartBean = (CartBean) request.getSession().getAttribute(CART_BEAN_SESSION_KEY);
		if (cartBean != null && cartBean.getCartSize() > 0) {
			cartBean.removeCartItem(deleteId);
			request.setAttribute(RESULT_REDIRECT_URL, "info");
		}
		return Constants.CMD_EXEC_SUCCESS;
	}
}
