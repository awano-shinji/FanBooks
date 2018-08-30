package jp.co.sji.edu.fb.service;

import java.io.IOException;

import jp.co.sji.edu.fb.dto.S0101Dto;

/**
 * <p>[概 要] S0101のServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface S0101Service {
    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param singleFlg 単一ユーザモード
     * @param errorFlg errorFlg対象
     * @param s0101Dto s0101Dto対象
     * @return S0101Dto
     */
    S0101Dto getInitInfo(boolean singleFlg, boolean errorFlg, S0101Dto s0101Dto);

    /**
     * <p>[概 要] User情報を新規する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto
     * @throws IOException IOException
     */
    void insertUser(S0101Dto s0101Dto) throws IOException;

    /**
     * <p>[概 要] User情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto対象
     */
    void updateUser(S0101Dto s0101Dto);
}
