package jp.co.sji.edu.fb.service;

import java.util.List;

import jp.co.sji.edu.fb.dto.B0301CondDto;
import jp.co.sji.edu.fb.dto.B0301ResultDto;

/**
 * <p>[概 要] B0301のServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */

public interface B0301Service {
	/**
	 * <p>[概 要] 検索処理。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param B0301CondDto b0301CondDto 画面の検索条件
	 * @return List<B0301ResultDto> Book情報
	 */
	List<B0301ResultDto> getInitInfo(B0301CondDto b0301CondDto);
}