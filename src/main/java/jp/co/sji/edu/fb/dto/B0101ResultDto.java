package jp.co.sji.edu.fb.dto;

import java.sql.Timestamp;
import java.util.Date;

import jp.co.sji.edu.fb.common.dto.BookInfo;


/**
 * <p>[概 要] B0101の検索結果。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class B0101ResultDto extends BookInfo {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * BookID
     */
    private String bookID;

    /**
     * BookTitle
     */
    private String bookTitle;

    /**
     * CategoryName
     */
    private String categoryName;
 
    /**
     * CoverImgID
     */
    private String coverImgID;

    /**
     * CoverImgUrl
     */
    private String coverImgUrl;

    /**
     * RegDate
     */
    private Date regDate;
        
    /**
     * LastUpdate
     */
    private Timestamp lastUpdate;

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCoverImgID() {
		return coverImgID;
	}

	public void setCoverImgID(String coverImgID) {
		this.coverImgID = coverImgID;
	}

	public String getCoverImgUrl() {
		return coverImgUrl;
	}

	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
    
    
    
}

