package jp.co.sji.edu.fb.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jp.co.sji.edu.fb.common.dto.CodeMasterInfo;

/**
 * <p>[概 要] B0302の画面データ。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class B0302Dto extends BaseDto{

	/**
     * Serial
     */
	private static final long serialVersionUID = 1L;

	/**
	 * modeType
	 */
	private String modeType;

	/**
     * BookID
     */
    private String bookID;

    /**
     * CategoryID
     */
    private String categoryID;

    /**
     * BookTitle
     */
    private String bookTitle;

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
    private String description ;

    /**
     * CoverImgID
     */
    private String coverImgID;

    /**
     * CoverImgID
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

	/**
     * CategoryList
     */
    private List<CodeMasterInfo> categoryList;

    /**
     * MultipartFile
     */
    private MultipartFile mpFile;

	public String getModeType() {
		return modeType;
	}

	public void setModeType(String modeType) {
		this.modeType = modeType;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

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

	public List<CodeMasterInfo> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CodeMasterInfo> categoryList) {
		this.categoryList = categoryList;
	}

	public MultipartFile getMpFile() {
		return mpFile;
	}

	public void setMpFile(MultipartFile mpFile) {
		this.mpFile = mpFile;
	}
}
