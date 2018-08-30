package jp.co.sji.edu.fb.dto;

import jp.co.sji.edu.fb.common.dto.UserInfo;



/**
 * <p>[概 要] P0101の検索結果。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class P0101ResultDto extends UserInfo {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * UserTypeName
     */
    private String userTypeName;

    /**
     * UserTypeName
     */
    private String userType;

    /**
     * StatusName
     */
    private String statusName;

    /**
     * <p>[概 要] userTypeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * <p>[概 要] userTypeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param userType userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * <p>[概 要] UserTypeNameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String UserTypeName
     */
    public String getUserTypeName() {
        return userTypeName;
    }

    /**
     * <p>[概 要] StatusNameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String StatusName
     */
    public String getStatusName() {
        return statusName;
    }


    /**
     * <p>[概 要] UserTypeNameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param userTypeName UserTypeName
     */
    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }


    /**
     * <p>[概 要] StatusNameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param statusName StatusName
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}

