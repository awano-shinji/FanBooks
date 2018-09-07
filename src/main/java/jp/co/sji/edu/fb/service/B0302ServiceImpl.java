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
import jp.co.sji.edu.fb.dto.B0302Dto;

/**
 * <p>[概 要] B0302のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("b0302Service")
public class B0302ServiceImpl implements B0302Service {

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
     * @param B0302Dto b0302Dto
     * @return B0302Dto
     */
    @Transactional(readOnly = true)
    public B0302Dto getInitInfo(boolean hasIdFlg, B0302Dto b0302Dto){
    	// カテゴリリストを取得する
    	b0302Dto.setCategoryList(CodeUtil.getComBox(Constants.CD_GROUP_VESSELTYPE,
                null));
    	//Bookデータの取得
        if (hasIdFlg) {
        	//特定なBookの場合
        	BookInfo book = bookInfoDao.selectBookByID(b0302Dto.getBookID());
        	b0302Dto.setCategoryID(book.getCategoryID());
        	b0302Dto.setBookTitle(book.getBookTitle());
        	b0302Dto.setAuthor(book.getAuthor());
        	b0302Dto.setPublisher(book.getPublisher());
        	b0302Dto.setDescription(book.getDescription());
        	b0302Dto.setCoverImgID(book.getCoverImgID());
        	String coverImgUrl = getCoverImgUrl(book.getCoverImgID());
        	b0302Dto.setCoverImgUrl(coverImgUrl);
        	b0302Dto.setRegDate(book.getRegDate());
        	b0302Dto.setLastUpdate(book.getLastUpdate());
        } else {
        	//その他のモード
        }

        return b0302Dto;
    }

    /**
     * <p>[概 要] Book情報を新規する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0302Dto b0302Dto
     * @throws IOException IOException
     */
    @Transactional()
    public void insertBooks(B0302Dto b0302Dto) throws IOException {

    	// BookIDを採番する
        String bookID = sequenceService.getSeqNo(Constants.SEQ_TYPE_BOOK);
        // BookID重複チェック
        BookInfo bookInfo = bookInfoDao.selectBookByID(bookID);
        if(null != bookInfo){
        	throw new BpException(MessageUtil.getMessage("E0005"));
        }else{
        	// Bookを登録する
        	b0302Dto.setBookID(bookID);
            bookInfoDao.insertBooks(b0302Dto);
        };
    	return;
    }

    /**
     * <p>[概 要] Book情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0302Dto b0302Dto
     */
    @Transactional()
    public void updateBooks(B0302Dto b0302Dto) {

    	// Book情報を更新する。
        int updCnt = bookInfoDao.updateBooks(b0302Dto);
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
     * @param B0302Dto b0302Dto
     */
    @Transactional()
    public void deleteBooks(B0302Dto b0302Dto, String contentPath){
    	//BookCoverのImageIDがある場合、ゴミ掃除する。
    	if(null != b0302Dto.getCoverImgID()){
    		fileService.deleteFile(b0302Dto.getCoverImgID(), contentPath);
    	}
    	//BookInfoの削除
    	bookInfoDao.deleteBooks(b0302Dto);

    	return;
    }

    /**
     * <p>[概 要] ファイルのアップロード</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto, String contentPath
     */
	public String fileUploads(B0302Dto b0302Dto, String contentPath) {

		//FileInfoの設定
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileID(b0302Dto.getCoverImgID());
    	fileInfo.setFileType(Constants.FILE_BOOKCOVER);
    	fileInfo.setRegDate(b0302Dto.getRegDate());
    	return fileService.uploadFile(b0302Dto.getMpFile(), fileInfo, contentPath);
	}

	/**
     * <p>[概 要] CoverImageUrlを生成する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto, String contentPath
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
