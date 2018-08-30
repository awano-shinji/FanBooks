package jp.co.sji.edu.fb.dto;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.BookInfo;
import jp.co.sji.edu.fb.common.dto.CodeMasterInfo;


/**
 * <p>[概 要] B0101の画面データ。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class B0101Dto extends BaseDto {

	/**
     * Serial
     */
    private static final long serialVersionUID = 5046411049766117857L;

    /**
     * 検索条件
     */
    private B0101CondDto condDto;

    /**
     * 一覧情報回復条件
     */
    private ListRecoveryDto listRecoveryDto;

    /**
     * BookInfo
     */
    private BookInfo bookInfo;

    /**
     * CategoryList
     */
    private List<CodeMasterInfo> categoryList;
 
    
    
	public B0101CondDto getCondDto() {
		return condDto;
	}

	public void setCondDto(B0101CondDto condDto) {
		this.condDto = condDto;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

    /**
     * <p>[概 要] ListRecoveryDtoの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return ListRecoveryDto listRecoveryDto
     */
    public ListRecoveryDto getListRecoveryDto() {
        return listRecoveryDto;
    }

    /**
     * <p>[概 要] ListRecoveryDtoの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param listRecoveryDto listRecoveryDto
     */
    public void setListRecoveryDto(ListRecoveryDto listRecoveryDto) {
        this.listRecoveryDto = listRecoveryDto;
    }

	public List<CodeMasterInfo> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CodeMasterInfo> categoryList) {
		this.categoryList = categoryList;
	}


}

