package jp.co.sji.edu.fb.common.dao;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.BookInfo;
import jp.co.sji.edu.fb.dto.B0101CondDto;
import jp.co.sji.edu.fb.dto.B0201CondDto;
import jp.co.sji.edu.fb.dto.B0202Dto;
import jp.co.sji.edu.fb.dto.B0301CondDto;
import jp.co.sji.edu.fb.dto.B0302Dto;


/**
 * <p>[概 要] BookInfoのDAOのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface BookInfoDao {

    /**
     * <p>[概 要] BookInfo情報を登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0202Dto b0202Dto情報
     * @return
     */
    void insertBook(B0202Dto b0202Dto);

    /**
     * <p>[概 要] BookInfo情報を登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0302Dto b0302Dto情報
     * @return
     */
    void insertBooks(B0302Dto b0302Dto);

    /**
     * <p>[概 要] 条件を絞り込みBook情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0301CondDto condDto 検索条件DTO
     * @return List BookInfo
     */
    List<BookInfo> selectBooks(B0301CondDto condDto);

    /**
     * <p>[概 要] 条件を絞り込みBook情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0201CondDto condDto 検索条件DTO
     * @return List BookInfo
     */
    List<BookInfo> selectBooks(B0201CondDto condDto);

    /**
     * <p>[概 要] 条件を絞り込みBook情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0201CondDto condDto 検索条件DTO
     * @return List BookInfo
     */
    List<BookInfo> selectShBooks(B0101CondDto condDto);

    /**
     * <p>[概 要] bookIDで条件を絞り込みBook情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param String bookID
     * @return BookInfo 情報
     */
    BookInfo selectBookByID(String bookID);



    /**
     * <p>[概 要] bookIDを条件に１件のBookを更新する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0202Dto b0202Dto
     * @return BookInfo 情報
     */
    int updateBook(B0202Dto b0202Dto);

    /**
     * <p>[概 要] 資料一覧のbookIDを条件に１件のBookを更新する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0302Dto b0302Dto
     * @return BookInfo 情報
     */
    int updateBooks(B0302Dto b0302Dto);

    /**
     * <p>[概 要] bookIDを条件に１件のBookを削除する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0202Dto b0202Dto
     * @return BookInfo 情報
     */
    int deleteBook(B0202Dto b0202Dto);


    /**
     * <p>[概 要] 資料一覧のbookIDを条件に１件のBookを削除する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0302Dto b0302Dto
     * @return BookInfo 情報
     */
    int deleteBooks(B0302Dto b0302Dto);

  }



