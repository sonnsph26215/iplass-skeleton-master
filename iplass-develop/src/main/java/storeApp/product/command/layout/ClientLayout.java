package storeApp.product.command.layout;

import java.util.List;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;

import storeApp.product.dto.CartBean;

@ActionMapping(
		name = "store-app/layout/clientlayout", 
		displayName = "clientlayout", 
		privileged = true, 
		parts = true, 
		result = @Result(
		type = Type.JSP, 
		value = "/jsp/store-app/clientlayout.jsp",
		templateName="store-app/clientlayout")
		)
@CommandClass(
		name = "store-app/layout/clientlayout", 
		displayName = "clientlayout")
public class ClientLayout implements Command {

	private final String RESULT_TOTAL_AMOUNT = "totalAmount";
	private final String CART_BEAN_SESSION_KEY = "cart-bean";
	@Override
	public String execute(RequestContext request) {

		CartBean cart = (CartBean) request.getSession().getAttribute(CART_BEAN_SESSION_KEY);
		long totalAmount = 0;
		if (cart != null) {
			totalAmount = cart.getTotalAmount();
		}
		request.setAttribute(RESULT_TOTAL_AMOUNT, totalAmount);

		return Constants.CMD_EXEC_SUCCESS;
	}
}
