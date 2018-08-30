package jp.co.sji.edu.fb.dto;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.CodeMasterInfo;



/**
 * <p>[概 要] S0101の画面データ。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class S0101Dto extends BaseDto {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * LoginID
     */
    private String loginID;

    /**
     * UserType
     */
    private String userType;

    /**
     * Status
     */
    private String status;

    /**
     * Email
     */
    private String email;

    /**
     * LastUpdate
     */
    private String lastUpdate;


    /**
     * picList
     */
    private String picList;


    /**
     * userName
     */
    private String userName;

    /**
     * modeType
     */
    private String modeType;

    /**
     * userNameList
     */
    private String userNameList;

    /**
     * password
     */
    private String password;

    /**
     * <p>[概 要] picListの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return picList
     */
    public String getPicList() {
        return picList;
    }

    /**
     * <p>[概 要] picListの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param picList picList
     */
    public void setPicList(String picList) {
        this.picList = picList;
    }

    /**
     * statusList
     */
    private List<CodeMasterInfo> statusList;

    /**
     * <p>[概 要] statusListの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return statusList
     */
    public List<CodeMasterInfo> getStatusList() {
        return statusList;
    }
    /**
     * <p>[概 要] statusListの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param statusList statusList
     */
    public void setStatusList(List<CodeMasterInfo> statusList) {
        this.statusList = statusList;
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
     * <p>[概 要] UserTypeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return int UserType
     */
    public String getUserType() {
        return userType;
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
     * <p>[概 要] Emailの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Email
     */
    public String getEmail() {
        return email;
    }
    /**
     * <p>[概 要] LastUpdateの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String LastUpdate
     */
    public String getLastUpdate() {
        return lastUpdate;
    }
    /**
     * <p>[概 要] modeTypeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String modeType
     */
    public String getModeType() {
        return modeType;
    }
    /**
     * <p>[概 要] UserNameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * <p>[概 要] userNameListの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String userNameList
     */
    public String getUserNameList() {
        return userNameList;
    }

    /**
     * <p>[概 要] passwordの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String password
     */
    public String getPassword() {
        return password;
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
     * <p>[概 要] UserTypeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param userType UserType
     */
    public void setUserType(String userType) {
        this.userType = userType;
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

    /**
     * <p>[概 要] eMailの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>[概 要] LastUpdateの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param lastUpdate lastUpdate
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * <p>[概 要] UserNameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * <p>[概 要] modeTypeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param modeType modeType
     */
    public void setModeType(String modeType) {
        this.modeType = modeType;
    }
    /**
     * <p>[概 要] userNameListの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param userNameList userNameList
     */
    public void setUserNameList(String userNameList) {
        this.userNameList = userNameList;
    }

    /**
     * <p>[概 要] passwordの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

