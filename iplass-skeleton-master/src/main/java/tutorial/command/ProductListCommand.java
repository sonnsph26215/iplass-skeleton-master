package tutorial.command;

import java.util.List;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.ManagerLocator;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.CommandConfig;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;
import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.entity.EntityManager;
import org.iplass.mtp.entity.SearchResult;
import org.iplass.mtp.entity.query.Query;

import tutorial.dao.EntityDaoHelper;
import tutorial.entity.Product;

@ActionMapping(
	    name = "tutorial/ProductListCommand", 
	    displayName = "ProductListCommand", 
	    privileged = true, 
		result = @Result(type=Type.JSP,
		value = "/jsp/tutorial/ProductsPage.jsp",
		templateName="tutorial/ProductsPage"),
	    command=@CommandConfig(commandClass=ProductListCommand.class))
@CommandClass(
		name = "tutorial/ProductListCommand", 
		displayName = "ProductListCommand")
public class ProductListCommand implements Command {

	
	
	@Override
	  public String execute(RequestContext request) {
		String[] properties = new String[] { Product.OID, Product.NAME, Product.PRICE, Product.NOTE, Product.IMAGE};
		List<Product> productList = EntityDaoHelper.searchDistinctEntity(Product.DEFINITION_NAME, properties);
		if (productList.size() > 0) {
			request.setAttribute("productList", productList);
		}
	    return Constants.CMD_EXEC_SUCCESS;
	  }
}
