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
public class FileInfo implements Serializable {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * FileID 
     */
    private String fileID ;

    /**
     * FileType
     */
    private String fileType;

    /**
     * FileName
     */
    private String fileName;
 
    /**
     * FileName
     */
    private String orgFileName;
    
    /**
     * FileSize 
     */
    private String fileSize ;

    /**
     * RegDate
     */
    private Date regDate;
        
    /**
     * LastUpdate
     */
    private Timestamp lastUpdate;
    
    /**
     * <p>[概 要] FileIDの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String fileID
     */
	public String getFileID() {
		return fileID;
	}
    
    /**
     * <p>[概 要] FileIDの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String fileID
     */
	public void setFileID(String fileID) {
		this.fileID = fileID;
	}
	
    /**
     * <p>[概 要] FileTypeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String fileType
     */
	public String getFileType() {
		return fileType;
	}
	
    /**
     * <p>[概 要] FileTypeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String fileType
     */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
    /**
     * <p>[概 要] FileNameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String fileName
     */
	public String getFileName() {
		return fileName;
	}
	
    /**
     * <p>[概 要] FileNameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String fileName
     */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
    /**
     * <p>[概 要] OrgFileNameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param 
     */
    public String getOrgFileName() {
		return orgFileName;
	}
    
    /**
     * <p>[概 要] OrgFileNameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String orgFileName
     */
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	/**
     * <p>[概 要] FileSizeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String fileSize
     */
	public String getFileSize() {
		return fileSize;
	}
	
    /**
     * <p>[概 要] FileSizeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param String fileSize
     */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
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
	

}

