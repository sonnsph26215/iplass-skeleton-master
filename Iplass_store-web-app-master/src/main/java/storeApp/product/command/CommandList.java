package storeApp.product.command;

import org.iplass.mtp.command.annotation.MetaDataSeeAlso;

@MetaDataSeeAlso({ 
	storeApp.product.command.ProductListCommand.class,
	storeApp.product.command.DetailProductCommand.class,
	storeApp.product.command.HomePageCommand.class,
	storeApp.product.command.Cart.addCartItemCommand.class,
	storeApp.product.command.Cart.getCartBeanCommand.class,
	storeApp.product.command.Cart.RemoveCartItemCommand.class,
	storeApp.product.command.Cart.UpdateCartItemCommand.class
})
public class CommandList {

}
