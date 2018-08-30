package jp.co.sji.edu.fb.dto;

import jp.co.sji.edu.fb.common.dto.BookInfo;


/**
 * <p>[概 要] B0201の画面データ。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class B0201Dto extends BaseDto {

	/**
     * Serial
     */
    private static final long serialVersionUID = 5046411049766117857L;

    /**
     * 検索条件
     */
    private B0201CondDto condDto;

    /**
     * 一覧情報回復条件
     */
    private ListRecoveryDto listRecoveryDto;

    /**
     * BookInfo
     */
    private BookInfo bookInfo;


	public B0201CondDto getCondDto() {
		return condDto;
	}

	public void setCondDto(B0201CondDto condDto) {
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
	
	
}

