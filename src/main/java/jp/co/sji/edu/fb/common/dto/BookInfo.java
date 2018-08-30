package jp.co.sji.edu.fb.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * <p>[概 要] BookInfoのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) SJI.</p>
 * @author Edu.SJI
 */
public class BookInfo implements Serializable {

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
	private String categoryID;

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
	 * <p>[概 要] BookIDの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param String BookID
	 */
	public String getBookID() {
		return bookID;
	}

	/**
	 * <p>[概 要] BookIDの設定。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param BookID BookID
	 */
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	/**
	 * <p>[概 要] CategoryIDの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param String CategoryID
	 */
	public String getCategoryID() {
		return categoryID;
	}

	/**
	 * <p>[概 要] CategoryIDの設定。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param CategoryID CategoryID
	 */
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	/**
	 * <p>[概 要] Authorの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param
	 * @return String author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <p>[概 要] Authorの設定。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param　String author
	 * @return
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * <p>[概 要] Publisherの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param
	 * @return　String publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * <p>[概 要] Publisherの設定。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param　String publisher
	 * @return
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * <p>[概 要] Descriptionの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param
	 * @return　String description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>[概 要] Descriptionの設定。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param　String description
	 * @return
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * <p>[概 要] BookTitleの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param String BookTitle
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
	 * <p>[概 要] CoverImgIDの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param String coverImgID
	 */
	public String getCoverImgID() {
		return coverImgID;
	}

	/**
	 * <p>[概 要] CoverImgIDの設定。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param String coverImgID
	 */
	public void setCoverImgID(String coverImgID) {
		this.coverImgID = coverImgID;
	}

	/**
	 * <p>[概 要] RegDateの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param Date RegDate
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * <p>[概 要] RegDateの設定。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param RegDate RegDate
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	/**
	 * <p>[概 要] LastUpdateの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param Timestamp LastUpdate
	 */
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * <p>[概 要] LastUpdateの設定。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param LastUpdate LastUpdate
	 */
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * <p>[概 要] bookCoverの取得。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param Timestamp LastUpdate
	 */
	public String getBookCover() {
		return bookCover;
	}

	/**
	 * <p>[概 要] bookCoverの設定。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param LastUpdate LastUpdate
	 */
	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

}
