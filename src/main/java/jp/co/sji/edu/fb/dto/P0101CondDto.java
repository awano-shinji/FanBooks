package jp.co.sji.edu.fb.dto;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.CodeMasterInfo;

/**
 * <p>[概 要] P0101の検索条件。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class P0101CondDto extends BaseDto {

    /**
     * Serial
     */
    private static final long serialVersionUID = 5046411049766117857L;

    /**
     * Name
     */
    private String name;

    /**
     * LoginID
     */
    private String loginID;

    /**
     * Type
     */
    private String type;

    /**
     * Status
     */
    private String status;

    /**
     * typeList
     */
    private List<CodeMasterInfo> typeList;

    /**
     * statusList
     */
    private List<CodeMasterInfo> statusList;

    /**
     * <p>[概 要] List<CodeMasterInfo>の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return List<CodeMasterInfo> typeList
     */
    public List<CodeMasterInfo> getTypeList() {
        return typeList;
    }

    /**
     * <p>[概 要] List<CodeMasterInfo>の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param typeList typeList
     */
    public void setTypeList(List<CodeMasterInfo> typeList) {
        this.typeList = typeList;
    }

    /**
     * <p>[概 要] List<CodeMasterInfo>の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return List<CodeMasterInfo> statusList
     */
    public List<CodeMasterInfo> getStatusList() {
        return statusList;
    }

    /**
     * <p>[概 要] List<CodeMasterInfo>の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param statusList statusList
     */
    public void setStatusList(List<CodeMasterInfo> statusList) {
        this.statusList = statusList;
    }

    /**
     * <p>[概 要] Nameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Name
     */
    public String getName() {
        return name;
    }

    /**
     * <p>[概 要] LoginIDの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String LoginID
     */
    public String getLoginID() {
        return loginID;
    }

    /**
     * <p>[概 要] Typeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Type
     */
    public String getType() {
        return type;
    }

    /**
     * <p>[概 要] Statusの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Status
     */
    public String getStatus() {
        return status;
    }

    /**
     * <p>[概 要] Nameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>[概 要] LoginIDの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param loginID LoginID
     */
    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    /**
     * <p>[概 要] Typeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param type Type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <p>[概 要] Statusの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param status Status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}

