package jp.co.sji.edu.fb.service;


import java.io.IOException;

import jp.co.sji.edu.fb.dto.S1001Dto;


/**
 * <p>[概 要] S1001のServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface S1001Service {
   /**
     * <p>[概 要] Change Password処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s1001Dto S1001画面情報
     * @throws IOException IOException
     */
    void updatePassword(S1001Dto s1001Dto) throws IOException;
}
