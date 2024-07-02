package storeApp.product.entity;

import java.sql.Timestamp;
import org.iplass.mtp.entity.GenericEntity;
import org.iplass.mtp.entity.SelectValue;

/**
 * Review Entity。
 */
public class ReviewProduct extends GenericEntity {

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.ReviewProduct";

	/** Comment đánh giá */
	public static final String COMMENT_REVIEW = "commentReview";
	/** Ngày đánh giá */
	public static final String START_DATE_REVIEW = "startDateReview";
	/** Sao đánh giá */
	public static final String VOTE_REVIEW = "voteReview";
	/** Tên người đánh giá */
	public static final String NAME_REVIEW = "nameReview";
	/** Mã sản phẩm */
	public static final String CODE_PRODUCT = "codeProduct";

	public ReviewProduct() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Comment đánh giáを返します。
	 * 
	 * @return Comment đánh giá
	 */
	public String getCommentReview() {
		return getValue(COMMENT_REVIEW);
	}

	/**
	 * Comment đánh giáを設定します。
	 * 
	 * @param commentReview Comment đánh giá
	 */
	public void setCommentReview(String commentReview) {
		setValue(COMMENT_REVIEW, commentReview);
	}

	/**
	 * Ngày đánh giáを返します。
	 * 
	 * @return Ngày đánh giá
	 */
	public Timestamp getStartDateReview() {
		return getValue(START_DATE_REVIEW);
	}

	/**
	 * Ngày đánh giáを設定します。
	 * 
	 * @param startDateReview Ngày đánh giá
	 */
	public void setStartDateReview(Timestamp startDateReview) {
		setValue(START_DATE_REVIEW, startDateReview);
	}

	/**
	 * Sao đánh giáを返します。
	 * 
	 * @return Sao đánh giá
	 */
	public SelectValue getVoteReview() {
		return getValue(VOTE_REVIEW);
	}

	/**
	 * Sao đánh giáを設定します。
	 * 
	 * @param voteReview Sao đánh giá
	 */
	public void setVoteReview(SelectValue voteReview) {
		setValue(VOTE_REVIEW, voteReview);
	}

	/**
	 * Tên người đánh giáを返します。
	 * 
	 * @return Tên người đánh giá
	 */
	public String getNameReview() {
		return getValue(NAME_REVIEW);
	}

	/**
	 * Tên người đánh giáを設定します。
	 * 
	 * @param nameReview Tên người đánh giá
	 */
	public void setNameReview(String nameReview) {
		setValue(NAME_REVIEW, nameReview);
	}

	/**
	 * Mã sản phẩmを返します。
	 * 
	 * @return Mã sản phẩm
	 */
	public String getCodeProduct() {
		return getValue(CODE_PRODUCT);
	}

	/**
	 * Mã sản phẩmを設定します。
	 * 
	 * @param codeProduct Mã sản phẩm
	 */
	public void setCodeProduct(String codeProduct) {
		setValue(CODE_PRODUCT, codeProduct);
	}

}
