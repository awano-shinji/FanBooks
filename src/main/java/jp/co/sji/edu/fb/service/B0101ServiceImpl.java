package jp.co.sji.edu.fb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dao.BookInfoDao;
import jp.co.sji.edu.fb.common.dao.FileInfoDao;
import jp.co.sji.edu.fb.common.dto.BookInfo;
import jp.co.sji.edu.fb.common.dto.FileInfo;
import jp.co.sji.edu.fb.common.util.CodeUtil;
import jp.co.sji.edu.fb.common.util.StringUtil;
import jp.co.sji.edu.fb.dto.B0101CondDto;
import jp.co.sji.edu.fb.dto.B0101ResultDto;

/**
 * <p>[概 要] B0101のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("b0101Service")
public class B0101ServiceImpl implements B0101Service {

    /**
     * BookInfoDaos
     */
    @Autowired(required = true)
    private BookInfoDao bookInfoDao;

    /**
     * FileInfoDao
     */
    @Autowired(required = true)
    private FileInfoDao fileInfoDao;


    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param condDto P0101画面の検索条件
     * @return List<P0101ResultDto> ユーザリスト
     */
    @Transactional(readOnly = true)
    public List<B0101ResultDto> getInitInfo(B0101CondDto condDto) {
        List<BookInfo> bookList = bookInfoDao.selectShBooks(condDto);
        List<B0101ResultDto> retList = new ArrayList<B0101ResultDto>();
        // DBデータを画面データに転換する
        for (BookInfo bookInfo : bookList) {
            B0101ResultDto bookDto = new B0101ResultDto();
            bookDto.setBookID(StringUtil.escapeHtml(bookInfo.getBookID()));
            bookDto.setBookTitle(StringUtil.escapeHtml(bookInfo.getBookTitle()));
            bookDto.setCategoryID(StringUtil.escapeHtml(bookInfo.getCategoryID()));
            bookDto.setCategoryName(CodeUtil.getNameByCd(
            		Constants.CD_GROUP_VESSELTYPE, bookInfo.getCategoryID()));
            bookDto.setAuthor(bookInfo.getAuthor());
            bookDto.setPublisher(bookInfo.getPublisher());
            bookDto.setDescription(bookInfo.getDescription());
            String coverImgUrl = getCoverImgUrl(bookInfo.getCoverImgID());
            bookDto.setCoverImgUrl(coverImgUrl);
            bookDto.setRegDate(bookInfo.getRegDate());
            bookDto.setLastUpdate(bookInfo.getLastUpdate());
            retList.add(bookDto);
        }
        return retList;
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
