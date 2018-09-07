package jp.co.sji.edu.fb.dto;

import java.sql.Timestamp;
import java.util.Date;

import jp.co.sji.edu.fb.common.dto.BookInfo;


/**
 * <p>[概 要] B0301の検索結果。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class B0301ResultDto extends BookInfo {

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
     * BookCover
     */
    private String bookCover;

    /**
     * CategoryID
     */
    private String categoryName;

    /**
     * CoverImgID
     */
    private String coverImgID;

    /**
     * RegDate
     */
    private Date regDate;

    /**
     * LastUpdate
     */
    private Timestamp lastUpdate;

    /**
     * Author
     */
    private String author;

    /**
     * Publisher
     */
    private String publisher;

    /**
     * Description
     */
    private String description;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
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