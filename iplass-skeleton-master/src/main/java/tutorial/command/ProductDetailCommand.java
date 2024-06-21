package tutorial.command;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.CommandConfig;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;

import tutorial.dao.EntityDaoHelper;
import tutorial.entity.Product;

@ActionMapping(
	    name = "tutorial/DetailCommand", 
	    displayName = "DetailCommand", 
	    privilaged = true, 
		result = @Result(type=Type.JSP,
		value = "/jsp/tutorial/ProductsDetailPage.jsp",
		templateName="tutorial/ProductsDetailPage"),
	    command=@CommandConfig(commandClass=ProductDetailCommand.class))
@CommandClass(
		name = "tutorial/DetailCommand", 
		displayName = "DetailCommand")
public class ProductDetailCommand implements Command {

	@Override
	  public String execute(RequestContext request) {
		String productId = request.getParam("productId");
		Product product = EntityDaoHelper.load(Product.DEFINITION_NAME, productId);
		request.setAttribute("productInfo", product);
	    return Constants.CMD_EXEC_SUCCESS;
	  }
	
}
