package jp.co.sji.edu.fb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dao.BookInfoDao;
import jp.co.sji.edu.fb.common.dto.BookInfo;
import jp.co.sji.edu.fb.common.util.CodeUtil;
import jp.co.sji.edu.fb.common.util.StringUtil;
import jp.co.sji.edu.fb.dto.B0301CondDto;
import jp.co.sji.edu.fb.dto.B0301ResultDto;

/**
 * <p>[概 要] B0301のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("b0301Service")
public class B0301ServiceImpl implements B0301Service {

	/**
	 * BookInfoDaos
	 */
	@Autowired(required = true)
	private BookInfoDao bookInfoDao;

	/**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param condDto P0301画面の検索条件
     * @return List<P0301ResultDto> ユーザリスト
     */
	@Transactional(readOnly = true)
	 public List<B0301ResultDto> getInitInfo(B0301CondDto condDto) {
        List<BookInfo> bookList = bookInfoDao.selectBooks(condDto);
        List<B0301ResultDto> retList = new ArrayList<B0301ResultDto>();
        // DBデータを画面データに転換する
        for (BookInfo bookInfo : bookList) {
            B0301ResultDto bookDto = new B0301ResultDto();
            bookDto.setBookID(StringUtil.escapeHtml(bookInfo.getBookID()));
            bookDto.setBookTitle(StringUtil.escapeHtml(bookInfo.getBookTitle()));
            bookDto.setCategoryID(StringUtil.escapeHtml(bookInfo.getCategoryID()));
            bookDto.setCategoryName(CodeUtil.getNameByCd(
            		Constants.CD_GROUP_VESSELTYPE, bookInfo.getCategoryID()));
            bookDto.setBookCover(StringUtil.escapeHtml(bookInfo.getBookCover()));
            bookDto.setRegDate(bookInfo.getRegDate());
            bookDto.setLastUpdate(bookInfo.getLastUpdate());

            retList.add(bookDto);
        }
        return retList;
    }
}