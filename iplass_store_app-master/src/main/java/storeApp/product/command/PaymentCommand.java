package storeApp.product.command;

import java.security.SecureRandom;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;
import org.iplass.mtp.entity.SelectValue;

import storeApp.product.dao.EntityDaoHelper;
import storeApp.product.dto.CartBean;
import storeApp.product.dto.CartItem;
import storeApp.product.entity.OrderProduct;
import storeApp.product.entity.Product;

@ActionMapping(
		name = "store-app/payment", 
		displayName = "payment", 
		privileged = true,
		synchronizeOnSession = true,
		result = @Result(
				type = Type.REDIRECT, 
				value = PaymentCommand.RESULT_REDIRECT_URL))
@CommandClass(
		name = "store-app/payment", 
		displayName = "payment")
public class PaymentCommand implements Command{

	public static final String RESULT_REDIRECT_URL="redirectURL";
	private final String CART_BEAN_SESSION_KEY = "cart-bean";
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 5;
    private static final SecureRandom RANDOM = new SecureRandom();

	@Override
	public String execute(RequestContext request) {
		
		CartBean cartBean = (CartBean) request.getSession().getAttribute(CART_BEAN_SESSION_KEY);
		List<CartItem> cartItems = cartBean.getCartItems();
		if (cartBean != null && cartBean.getCartSize() > 0) {
			String ramdom = generateRandomString();
			
			for (CartItem cartItem : cartItems) {
				OrderProduct orderProduct = new OrderProduct();
				orderProduct.setName(ramdom);
				orderProduct.setOrderCode(ramdom);
				orderProduct.setOrderDate(Date.valueOf(LocalDate.now()));
				orderProduct.setOrderTotalPrice(cartBean.getTotalPrice());
				Product product = EntityDaoHelper.load(Product.DEFINITION_NAME, cartItem.getProductId());
				orderProduct.setOrderPrice(product.getPrice());
				orderProduct.setQuantity(cartItem.getQuantity().longValue());
				orderProduct.setProductCode(product);
				SelectValue selectValue = new SelectValue("7");
				orderProduct.setOrderStatus(selectValue);
				
				String oderItemOid = EntityDaoHelper.insert(orderProduct);
			}
			cartBean = new CartBean();
			request.getSession().setAttribute(CART_BEAN_SESSION_KEY, cartBean);
			request.setAttribute(RESULT_REDIRECT_URL, "homepage");
		}
		return Constants.CMD_EXEC_SUCCESS;
	}
	
    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
