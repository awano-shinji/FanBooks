package jp.co.sji.edu.fb.dto;

import java.io.Serializable;


/**
 * <p>[概 要] 多層ドロップダウン項目用共通DTOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class RelateDto implements Serializable {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * code
     */
    private String code;

    /**
     * codeName
     */
    private String codeName;

    /**
     * parentCode
     */
    private String parentCode;


    /**
     * <p>[概 要] codeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String code
     */
    public String getCode() {
        return code;
    }

    /**
     * <p>[概 要] codeNameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String codeName
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * <p>[概 要] parentCodeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String parentCode
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * <p>[概 要] codeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <p>[概 要] codeNameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param codeName codeName
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * <p>[概 要] parentCodeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param parentCode parentCode
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}

