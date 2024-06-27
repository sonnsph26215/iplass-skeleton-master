package storeApp.product.command;

import org.iplass.mtp.command.annotation.MetaDataSeeAlso;

@MetaDataSeeAlso({ 
	storeApp.product.command.ProductListCommand.class,
	storeApp.product.command.DetailProductCommand.class,
	storeApp.product.command.HomePageCommand.class
})
public class CommandList {

}
