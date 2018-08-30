package jp.co.sji.edu.fb.common.dto;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>[概 要] UserInfoのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class UserInfo implements Serializable {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * LoginID
     */
    private String loginID;

    /**
     * Password1
     */
    private String password1;

    /**
     * Password2
     */
    private String password2;

    /**
     * Password3
     */
    private String password3;

    /**
     * Password4
     */
    private String password4;

    /**
     * Password5
     */
    private String password5;

    /**
     * PwdChangeDate
     */
    private Date pwdChangeDate;

    /**
     * UserType
     */
    private String userType;

    /**
     * UserName
     */
    private String userName;

    /**
     * email
     */
    private String email;

    /**
     * Address
     */
    private String address;

    /**
     * City
     */
    private String city;

    /**
     * State
     */
    private String state;

    /**
     * Country
     */
    private String country;

    /**
     * Zip
     */
    private String zip;

    /**
     * Telephone
     */
    private String telephone;

    /**
     * Fax
     */
    private String fax;

    /**
     * WebSite
     */
    private String webSite;

    /**
     * Status
     */
    private String status;

    /**
     * Remark
     */
    private String remark;

    /**
     * LastUpdate
     */
    private String lastUpdate;


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
     * <p>[概 要] Password1の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Password1
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * <p>[概 要] Password2の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Password2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * <p>[概 要] Password3の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Password3
     */
    public String getPassword3() {
        return password3;
    }

    /**
     * <p>[概 要] Password4の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Password4
     */
    public String getPassword4() {
        return password4;
    }

    /**
     * <p>[概 要] Password5の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Password5
     */
    public String getPassword5() {
        return password5;
    }

    /**
     * <p>[概 要] PwdChangeDateの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return Date PwdChangeDate
     */
    public Date getPwdChangeDate() {
        return pwdChangeDate;
    }

    /**
     * <p>[概 要] UserTypeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String UserType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * <p>[概 要] UserNameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String UserName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * <p>[概 要] EMailの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>[概 要] Addressの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p>[概 要] Cityの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String City
     */
    public String getCity() {
        return city;
    }

    /**
     * <p>[概 要] Stateの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String State
     */
    public String getState() {
        return state;
    }

    /**
     * <p>[概 要] Countryの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Country
     */
    public String getCountry() {
        return country;
    }

    /**
     * <p>[概 要] Zipの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * <p>[概 要] Telephoneの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * <p>[概 要] Faxの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * <p>[概 要] WebSiteの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String WebSite
     */
    public String getWebSite() {
        return webSite;
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
     * <p>[概 要] Remarkの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Remark
     */
    public String getRemark() {
        return remark;
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
     * <p>[概 要] Password1の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param password1 Password1
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    /**
     * <p>[概 要] Password2の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param password2 Password2
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    /**
     * <p>[概 要] Password3の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param password3 Password3
     */
    public void setPassword3(String password3) {
        this.password3 = password3;
    }

    /**
     * <p>[概 要] Password4の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param password4 Password4
     */
    public void setPassword4(String password4) {
        this.password4 = password4;
    }

    /**
     * <p>[概 要] Password5の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param password5 Password5
     */
    public void setPassword5(String password5) {
        this.password5 = password5;
    }

    /**
     * <p>[概 要] PwdChangeDateの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param pwdChangeDate PwdChangeDate
     */
    public void setPwdChangeDate(Date pwdChangeDate) {
        this.pwdChangeDate = pwdChangeDate;
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
     * <p>[概 要] UserNameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param userName UserName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * <p>[概 要] EMailの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>[概 要] Addressの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param address Address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <p>[概 要] Cityの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param city City
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * <p>[概 要] Stateの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param state State
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * <p>[概 要] Countryの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param country Country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * <p>[概 要] Zipの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param zip Zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * <p>[概 要] Telephoneの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param telephone Telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * <p>[概 要] Faxの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param fax Fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * <p>[概 要] WebSiteの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param webSite WebSite
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
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
     * <p>[概 要] Remarkの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param remark Remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <p>[概 要] LastUpdateの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param lastUpdate LastUpdate
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

