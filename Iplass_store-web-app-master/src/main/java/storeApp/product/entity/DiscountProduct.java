package storeApp.product.entity;

import java.sql.Date;
import org.iplass.mtp.entity.GenericEntity;

public class DiscountProduct extends GenericEntity{

	private static final long serialVersionUID = 1L;

	/** Entity Definition Name */
	public static final String DEFINITION_NAME = "storeApp.product.DiscountProduct";

	/** Title ưu đãi */
	public static final String TITLE_CAMPAGIN = "titleCampagin";
	/** Nội dung ưu đãi */
	public static final String CONTENT_CAMPAIGN = "contentCampaign";
	/** mã sản phẩm ưu đãi cho chiến dịch */
	public static final String CODE_CAMPAIGN = "codeCampaign";
	/** startDateCampaign */
	public static final String START_DATE_CAMPAIGN = "startDateCampaign";
	/** ngày kết thúc */
	public static final String END_DATE_CAMPAIGN = "endDateCampaign";

	public DiscountProduct() {
		setDefinitionName(DEFINITION_NAME);
	}

	/**
	 * Title ưu đãiを返します。
	 * 
	 * @return Title ưu đãi
	 */
	public String getTitleCampagin() {
		return getValue(TITLE_CAMPAGIN);
	}

	/**
	 * Title ưu đãiを設定します。
	 * 
	 * @param titleCampagin Title ưu đãi
	 */
	public void setTitleCampagin(String titleCampagin) {
		setValue(TITLE_CAMPAGIN, titleCampagin);
	}

	/**
	 * Nội dung ưu đãiを返します。
	 * 
	 * @return Nội dung ưu đãi
	 */
	public String getContentCampaign() {
		return getValue(CONTENT_CAMPAIGN);
	}

	/**
	 * Nội dung ưu đãiを設定します。
	 * 
	 * @param contentCampaign Nội dung ưu đãi
	 */
	public void setContentCampaign(String contentCampaign) {
		setValue(CONTENT_CAMPAIGN, contentCampaign);
	}

	/**
	 * mã sản phẩm ưu đãi cho chiến dịchを返します。
	 * 
	 * @return mã sản phẩm ưu đãi cho chiến dịch
	 */
	public String getCodeCampaign() {
		return getValue(CODE_CAMPAIGN);
	}

	/**
	 * mã sản phẩm ưu đãi cho chiến dịchを設定します。
	 * 
	 * @param codeCampaign mã sản phẩm ưu đãi cho chiến dịch
	 */
	public void setCodeCampaign(String codeCampaign) {
		setValue(CODE_CAMPAIGN, codeCampaign);
	}

	/**
	 * startDateCampaignを返します。
	 * 
	 * @return startDateCampaign
	 */
	public Date getStartDateCampaign() {
		return getValue(START_DATE_CAMPAIGN);
	}

	/**
	 * startDateCampaignを設定します。
	 * 
	 * @param startDateCampaign startDateCampaign
	 */
	public void setStartDateCampaign(Date startDateCampaign) {
		setValue(START_DATE_CAMPAIGN, startDateCampaign);
	}

	/**
	 * ngày kết thúcを返します。
	 * 
	 * @return ngày kết thúc
	 */
	public Date getEndDateCampaign() {
		return getValue(END_DATE_CAMPAIGN);
	}

	/**
	 * ngày kết thúcを設定します。
	 * 
	 * @param endDateCampaign ngày kết thúc
	 */
	public void setEndDateCampaign(Date endDateCampaign) {
		setValue(END_DATE_CAMPAIGN, endDateCampaign);
	}
}
