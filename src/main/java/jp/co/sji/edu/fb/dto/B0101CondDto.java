package jp.co.sji.edu.fb.dto;

/**
 * <p>[概 要] B0101の検索条件。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class B0101CondDto extends BaseDto {

    /**
     * Serial
     */
    private static final long serialVersionUID = 5046411049766117857L;

    /**
     * CategoryID
     */
    private String categoryID;


	/**
     * <p>[概 要] CategoryIDの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String categoryID
     */
	public String getCategoryID() {
		return categoryID;
	}

	/**
     * <p>[概 要] CategoryIDの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String categoryID
     */
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
    
}

