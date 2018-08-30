package jp.co.sji.edu.fb.dto;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.CodeMasterInfo;

/**
 * <p>[概 要] BookInfoのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) SJI.</p>
 * @author Edu.SJI
 */
public class B0301CondDto extends BaseDto {
	   /**
     * BookTitle
     */
    private String bookTitle;

    /**
     * CategoryID
     */
    private String categoryID;

    /**
     * CategoryList
     */
    private List<CodeMasterInfo> categoryList;

	/**
     * <p>[概 要] BookTitleの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String bookTitle
     */
    public String getBookTitle() {
		return bookTitle;
	}

    /**
     * <p>[概 要] BookTitleの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String bookTitle
     */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

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

	/**
     * <p>[概 要] CategoryListの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return List<CodeMasterInfo> categoryList
     */
	public List<CodeMasterInfo> getCategoryList() {
		return categoryList;
	}

	/**
     * <p>[概 要] CategoryListの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param List<CodeMasterInfo> categoryList
     */
	public void setCategoryList(List<CodeMasterInfo> categoryList) {
		this.categoryList = categoryList;
	}
}