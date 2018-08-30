package jp.co.sji.edu.fb.dto;

import java.io.Serializable;

/**
 * <p>[概 要] ベースDTOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class BaseDto implements Serializable {
    /**
     * シリアル番号
     */
    private static final long serialVersionUID = 1L;

    /**
     * トークンキー
     */
    private String tokenKey = null;

    /**
     * <p>[概 要] トークンキーの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String トークンキー
     */
    public String getTokenKey() {
        return tokenKey;
    }

    /**
     * <p>[概 要] トークンキーの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param tokenKey トークンキー
     */
    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }
}
