package jp.co.sji.edu.fb.service;

import java.util.List;

import jp.co.sji.edu.fb.dto.P0101CondDto;
import jp.co.sji.edu.fb.dto.P0101ResultDto;

/**
 * <p>[概 要] P0101のServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface P0101Service {

    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param p0101CondDto P0101画面の検索条件
     * @return List<P0101ResultDto> ユーザリスト
     */
    List<P0101ResultDto> getInitInfo(P0101CondDto p0101CondDto);
}
