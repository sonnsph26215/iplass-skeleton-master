package storeApp.product.command.Cart;

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
import org.iplass.mtp.entity.query.condition.predicate.In;

import storeApp.product.dao.EntityDaoHelper;
import storeApp.product.dto.CartBean;
import storeApp.product.dto.CartItem;
import storeApp.product.dto.ShowCart;
import storeApp.product.entity.Product;

@ActionMapping(
	    name = "store-app/cart/info", 
	    displayName = "cartInfo", 
	    privileged = true, 
		result = @Result(type=Type.JSP,
		value = "/jsp/store-app/cartInfo.jsp",
		templateName="store-app/cartInfo"),
	    command=@CommandConfig(commandClass=getCartBeanCommand.class))
@CommandClass(
		name = "store-app/cart/info", 
		displayName = "cartInfo")
public class getCartBeanCommand implements Command {
	
	private final String CART_BEAN_SESSION_KEY = "cart-bean";
	private final String RESULT_CART = "resultcart";

	@Override
	public String execute(RequestContext request) {
		
		CartBean cartBean = (CartBean) request.getSession().getAttribute(CART_BEAN_SESSION_KEY);
		if (cartBean != null && cartBean.getCartSize() > 0) {
			
			Object[] productIds = cartBean.getProductIds().toArray();
			In in = new In(Product.OID, productIds);
			String[] properties = new String[] { Product.OID, Product.NAME, Product.PRICE};
			List<Product> products = EntityDaoHelper.searchDistinctEntity(Product.DEFINITION_NAME, in, properties);
			
			List<CartItem> items = cartBean.getCartItems();
			List<ShowCart> carts = convertShowCart(items, products);
			request.setAttribute(RESULT_CART, carts);
		}
		return Constants.CMD_EXEC_SUCCESS;
	}
	
	private List<ShowCart> convertShowCart(List<CartItem> cartItems, List<Product> products) {
		List<ShowCart> carts = new ArrayList<ShowCart>();
		
		for (CartItem i : cartItems) {
			for (Product product : products) {
				if(i.getProductId().equals(product.getOid())) {
					ShowCart cart = new ShowCart(product, i.getQuantity());
					carts.add(cart);
				}
			}
		}
		return carts;
	}
	
}
