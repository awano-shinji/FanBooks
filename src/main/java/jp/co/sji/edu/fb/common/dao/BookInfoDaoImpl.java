package jp.co.sji.edu.fb.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.sji.edu.fb.common.dto.BookInfo;
import jp.co.sji.edu.fb.dto.B0101CondDto;
import jp.co.sji.edu.fb.dto.B0201CondDto;
import jp.co.sji.edu.fb.dto.B0202Dto;
import jp.co.sji.edu.fb.dto.B0301CondDto;
import jp.co.sji.edu.fb.dto.B0302Dto;

/**
 * <p>[概 要] UserInfoのDAOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Repository ("bookInfoDao")
public class BookInfoDaoImpl extends BaseDao implements BookInfoDao  {
    /**
     * <p>[概 要] BookInfo情報を登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param BookInfo info情報
     * @return BookInfo情報
     */
    public void insertBook(B0202Dto b0202Dto){
        insert("bookInfo.insertBook", b0202Dto);
    }

    public void insertBooks(B0302Dto b0302Dto) {
    	insert("bookInfo.insertBooks", b0302Dto);
    }

    /**
     * <p>[概 要] 条件を絞り込みBook情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param condDto 条件DTO
     * @return List Bookリスト
     */
	public List<BookInfo> selectBooks(B0201CondDto condDto){
    	return (List<BookInfo>)queryForList("bookInfo.selectBooks", condDto);
    }

    /**
     * <p>[概 要] 条件を絞り込みBook情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param condDto 条件DTO
     * @return List Bookリスト
     */
	public List<BookInfo> selectShBooks(B0101CondDto condDto){
    	return (List<BookInfo>)queryForList("bookInfo.selectShBooks", condDto);
    }

    /**
     * <p>[概 要] loginIDで条件を絞り込みBook情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID Login中のloginID
     * @return UserInfo Book情報
     */
    public BookInfo selectBookByID(String bookID){
    	return (BookInfo)queryForObject("bookInfo.selectBookByID", bookID);
    }

    /**
     * <p>[概 要] loginIDで条件を絞り込みBook情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID Login中のloginID
     * @return UserInfo Book情報
     */
    public int updateBook(B0202Dto b0202Dto){
    	return update("bookInfo.updateBook", b0202Dto);
    }

    public int updateBooks(B0302Dto b0302Dto) {
    	return update("bookInfo.updateBooks", b0302Dto);
    }

    /**
     * <p>[概 要] loginIDで条件を絞り込みBook情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID Login中のloginID
     * @return UserInfo Book情報
     */
    public int deleteBook(B0202Dto b0202Dto){
    	return delete("bookInfo.deleteBook", b0202Dto);
    }

    public int deleteBooks(B0302Dto b0302Dto) {
    	return delete("bookInfo.deleteBooks", b0302Dto);
    }

	public List<BookInfo> selectBooks(B0301CondDto condDto) {
		return (List<BookInfo>)queryForList("bookInfo.selectBooksB3",condDto);
	}
}