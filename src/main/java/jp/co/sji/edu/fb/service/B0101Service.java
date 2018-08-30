package jp.co.sji.edu.fb.service;

import java.util.List;

import jp.co.sji.edu.fb.dto.B0101CondDto;
import jp.co.sji.edu.fb.dto.B0101Dto;
import jp.co.sji.edu.fb.dto.B0101ResultDto;

/**
 * <p>[概 要] B0101のServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface B0101Service {

    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0201CondDto b0201CondDto 画面の検索条件
     * @return List<B0201ResultDto> Book情報
     */
    List<B0101ResultDto> getInitInfo(B0101CondDto b0101CondDto);

}
