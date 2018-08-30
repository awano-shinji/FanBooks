package jp.co.sji.edu.fb.common.dto;

import java.io.Serializable;
/**
 * <p>[概 要] CodeMasterInfoのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class CodeMasterInfo implements Serializable {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * CodeGroup
     */
    private String codeGroup;

    /**
     * Code
     */
    private String code;

    /**
     * CodeName
     */
    private String codeName;

    /**
     * DisplayIndex
     */
    private int displayIndex;


    /**
     * <p>[概 要] CodeGroupの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String CodeGroup
     */
    public String getCodeGroup() {
        return codeGroup;
    }

    /**
     * <p>[概 要] Codeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Code
     */
    public String getCode() {
        return code;
    }

    /**
     * <p>[概 要] CodeNameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String CodeName
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * <p>[概 要] DisplayIndexの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return int DisplayIndex
     */
    public int getDisplayIndex() {
        return displayIndex;
    }

    /**
     * <p>[概 要] CodeGroupの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param codeGroup CodeGroup
     */
    public void setCodeGroup(String codeGroup) {
        this.codeGroup = codeGroup;
    }

    /**
     * <p>[概 要] Codeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param code Code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <p>[概 要] CodeNameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param codeName CodeName
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * <p>[概 要] DisplayIndexの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param displayIndex DisplayIndex
     */
    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }
}

