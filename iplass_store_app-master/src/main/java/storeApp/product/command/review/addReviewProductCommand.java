package storeApp.product.command.review;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.webapi.RestJson;
import org.iplass.mtp.command.annotation.webapi.WebApi;
import org.iplass.mtp.entity.SelectValue;
import org.iplass.mtp.entity.UpdateOption;
import org.iplass.mtp.webapi.definition.MethodType;
import org.iplass.mtp.webapi.definition.RequestType;

import storeApp.product.command.cart.addCartItemCommand;
import storeApp.product.dao.EntityDaoHelper;
import storeApp.product.dto.CartBean;
import storeApp.product.entity.Product;
import storeApp.product.entity.ReviewProduct;

@WebApi(
		name = "store-app/review/add", 
		displayName = "addReview", 
		accepts = RequestType.REST_JSON, 
		methods = MethodType.POST, 
		privileged = true,  
		synchronizeOnSession = true,
		restJson = @RestJson(parameterName = "param"), 
		results = addReviewProductCommand.RESULT)
@CommandClass(
		name = "store-app/review/add", 
		displayName = "addReview")
public class addReviewProductCommand implements Command {

	private final String PARAM_PRODUCT_ID = "productId";
	private final String PARAM_COMMENT = "comment";
	private final String PARAM_VOTE = "vote";
	private final String PARAM_NAME = "name";
	public final static String RESULT= "result";
	
	public String execute(RequestContext request) {
//		Param
		String productId = request.getParam(PARAM_PRODUCT_ID);
		String comment = request.getParam(PARAM_COMMENT);
		String vote = request.getParam(PARAM_VOTE);
		String name = request.getParam(PARAM_NAME);
//		Tạo mới review
		ReviewProduct reviewProduct = new ReviewProduct();
		reviewProduct.setCodeProduct(productId);
		reviewProduct.setCommentReview(comment);
		reviewProduct.setNameReview(name);
		SelectValue selectValue = new SelectValue(vote);
		reviewProduct.setVoteReview(selectValue);
		reviewProduct.setName(name);
		reviewProduct.setStartDateReview(Timestamp.valueOf(LocalDateTime.now()));
		
		String reviewID = EntityDaoHelper.insert(reviewProduct);
		
//		Cập nhật lượt vote vào sản phẩm
		Product product = EntityDaoHelper.load(Product.DEFINITION_NAME, productId);
		String[] properties = new String[] { ReviewProduct.VOTE_REVIEW };
		List<ReviewProduct> reviewProducts = EntityDaoHelper.searchDistinctEntity(ReviewProduct.DEFINITION_NAME, null, properties);
		Integer start = 0;
		Integer temp = 0;
		for (ReviewProduct i : reviewProducts) {
			start += Integer.valueOf(i.getVoteReview().getValue());
			temp++;
		}
		Long average = (temp == 0) ? 0L : (long) start / temp;
		product.setFavorites(average);
		
		UpdateOption option = new UpdateOption();
		option.setUpdateProperties(Product.FAVORITES);
		EntityDaoHelper.update(product, option);

		request.setAttribute(RESULT, "SUCCESS");

		return Constants.CMD_EXEC_SUCCESS;
	}
}
