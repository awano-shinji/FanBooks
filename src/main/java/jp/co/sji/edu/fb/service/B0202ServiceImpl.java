package jp.co.sji.edu.fb.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dao.BookInfoDao;
import jp.co.sji.edu.fb.common.dao.FileInfoDao;
import jp.co.sji.edu.fb.common.dto.BookInfo;
import jp.co.sji.edu.fb.common.dto.FileInfo;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.common.service.FileService;
import jp.co.sji.edu.fb.common.service.SequenceService;
import jp.co.sji.edu.fb.common.util.CodeUtil;
import jp.co.sji.edu.fb.common.util.MessageUtil;
import jp.co.sji.edu.fb.dto.B0202Dto;


/**
 * <p>[概 要] B0202のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("b0202Service")
public class B0202ServiceImpl implements B0202Service {

    /**
     * BookInfoDao
     */
    @Autowired(required = true)
    private BookInfoDao bookInfoDao;

    /**
     * 採番サービス
     */
    @Resource
    private SequenceService sequenceService;

    /**
     *　ファイルサービス
     */
    @Resource
    private FileService fileService;

    /**
     * FileInfoDao
     */
    @Autowired(required = true)
    private FileInfoDao fileInfoDao;

    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param errorFlg errorFlg
     * @param singleFlg 単一ユーザモード
     * @param s0101Dto s0101Dto
     * @return B0202Dto
     */
    @Transactional(readOnly = true)
    public B0202Dto getInitInfo(boolean hasIdFlg, B0202Dto b0202Dto){
    	// カテゴリリストを取得する
    	b0202Dto.setCategoryList(CodeUtil.getComBox(Constants.CD_GROUP_VESSELTYPE,
                null));
    	//Bookデータの取得
        if (hasIdFlg) {
        	//特定なBookの場合
        	BookInfo book = bookInfoDao.selectBookByID(b0202Dto.getBookID());
        	b0202Dto.setCategoryID(book.getCategoryID());
        	b0202Dto.setBookTitle(book.getBookTitle());
        	b0202Dto.setAuthor(book.getAuthor());
        	b0202Dto.setPublisher(book.getPublisher());
        	b0202Dto.setDescription(book.getDescription());
        	b0202Dto.setCoverImgID(book.getCoverImgID());
        	String coverImgUrl = getCoverImgUrl(book.getCoverImgID());
        	b0202Dto.setCoverImgUrl(coverImgUrl);
        	b0202Dto.setRegDate(book.getRegDate());
        	b0202Dto.setLastUpdate(book.getLastUpdate());
        } else {
        	//その他のモード

        }

        return b0202Dto;
    }


	/**
     * <p>[概 要] Book情報を新規する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0202Dto b0202Dto
     * @throws IOException IOException
     */
    @Transactional()
    public void insertBook(B0202Dto b0202Dto) throws IOException {

    	// BookIDを採番する
        String bookID = sequenceService.getSeqNo(Constants.SEQ_TYPE_BOOK);
        // BookID重複チェック
        BookInfo bookInfo = bookInfoDao.selectBookByID(bookID);
        if(null != bookInfo){
        	throw new BpException(MessageUtil.getMessage("E0005"));
        }else{
        	// Bookを登録する
        	b0202Dto.setBookID(bookID);
            bookInfoDao.insertBook(b0202Dto);
        };
    	return;
    }

    /**
     * <p>[概 要] Book情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0202Dto b0202Dto
     */
    @Transactional()
    public void updateBook(B0202Dto b0202Dto) {

    	// Book情報を更新する。
        int updCnt = bookInfoDao.updateBook(b0202Dto);
        // 更新0件の場合、排他エラーとする
        if (updCnt == 0) {
            throw new BpException(MessageUtil.getMessage("E0014"));
        }
        return;
    }

    /**
     * <p>[概 要] Book情報を削除する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0202Dto b0202Dto
     */
    @Transactional()
    public void deleteBook(B0202Dto b0202Dto, String contentPath){
    	//BookCoverのImageIDがある場合、ゴミ掃除する。
    	if(null != b0202Dto.getCoverImgID()){
    		fileService.deleteFile(b0202Dto.getCoverImgID(), contentPath);
    	}
    	//BookInfoの削除
    	bookInfoDao.deleteBook(b0202Dto);

    	return;
    }

    /**
     * <p>[概 要] ファイルのアップロード</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto, String contentPath
     */
	public String fileUpload(B0202Dto b0202Dto, String contentPath) {

		//FileInfoの設定
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileID(b0202Dto.getCoverImgID());
    	fileInfo.setFileType(Constants.FILE_BOOKCOVER);
    	fileInfo.setRegDate(b0202Dto.getRegDate());
    	return fileService.uploadFile(b0202Dto.getMpFile(), fileInfo, contentPath);
	}


    /**
     * <p>[概 要] CoverImageUrlを生成する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto, String contentPath
     */
    private String getCoverImgUrl(String coverImgID) {

    	FileInfo fileInfo = fileInfoDao.selectFileByID(coverImgID);
    	if(null != fileInfo){
    		String fileUrl = "/" + Constants.IMG_CONTENTS_PATH + "/" + fileInfo.getFileName();
    		return fileUrl;
    	}

    	return null;
	}

}
