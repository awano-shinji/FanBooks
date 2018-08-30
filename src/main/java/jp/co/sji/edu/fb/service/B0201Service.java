package jp.co.sji.edu.fb.service;

import java.util.List;

import jp.co.sji.edu.fb.dto.B0201CondDto;
import jp.co.sji.edu.fb.dto.B0201ResultDto;

/**
 * <p>[概 要] B0201のServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface B0201Service {

    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0201CondDto b0201CondDto 画面の検索条件
     * @return List<B0201ResultDto> Book情報
     */
    List<B0201ResultDto> getInitInfo(B0201CondDto b0201CondDto);
}
