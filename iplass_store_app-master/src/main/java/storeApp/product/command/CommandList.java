package storeApp.product.command;

import org.iplass.mtp.command.annotation.MetaDataSeeAlso;

@MetaDataSeeAlso({ 
	storeApp.product.command.ProductListCommand.class,
	storeApp.product.command.DetailProductCommand.class,
	storeApp.product.command.HomePageCommand.class,
	storeApp.product.command.UserCategoryWebApi.class,
	storeApp.product.command.resource.DownloadBinaryCommand.class,
	storeApp.product.command.cart.getCartBeanCommand.class,
	storeApp.product.command.cart.addCartItemCommand.class,
	storeApp.product.command.cart.RemoveCartItemCommand.class,
	storeApp.product.command.cart.UpdateCartItemCommand.class,
	storeApp.product.command.PaymentCommand.class,
	storeApp.product.command.review.addReviewProductCommand.class,
})
public class CommandList {

}
