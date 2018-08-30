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
import jp.co.sji.edu.fb.dto.B0201CondDto;
import jp.co.sji.edu.fb.dto.B0201ResultDto;

/**
 * <p>[概 要] B0201のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("b0201Service")
public class B0201ServiceImpl implements B0201Service {

    /**
     * UserInfoDaos
     */
    @Autowired(required = true)
    private BookInfoDao bookInfoDao;

    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param condDto P0101画面の検索条件
     * @return List<P0101ResultDto> ユーザリスト
     */
    @Transactional(readOnly = true)
    public List<B0201ResultDto> getInitInfo(B0201CondDto condDto) {
        List<BookInfo> bookList = bookInfoDao.selectBooks(condDto);
        List<B0201ResultDto> retList = new ArrayList<B0201ResultDto>();
        // DBデータを画面データに転換する
        for (BookInfo bookInfo : bookList) {
            B0201ResultDto bookDto = new B0201ResultDto();
            bookDto.setBookID(StringUtil.escapeHtml(bookInfo.getBookID()));
            bookDto.setBookTitle(StringUtil.escapeHtml(bookInfo.getBookTitle()));
            bookDto.setCategoryID(StringUtil.escapeHtml(bookInfo.getCategoryID()));
            bookDto.setCategoryName(CodeUtil.getNameByCd(
            		Constants.CD_GROUP_VESSELTYPE, bookInfo.getCategoryID()));
            bookDto.setRegDate(bookInfo.getRegDate());
            bookDto.setLastUpdate(bookInfo.getLastUpdate());

            retList.add(bookDto);
        }
        return retList;
    }
}
