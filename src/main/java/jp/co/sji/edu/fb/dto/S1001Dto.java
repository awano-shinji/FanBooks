package jp.co.sji.edu.fb.dto;

import java.util.Date;

/**
 * <p>[概 要] S1001の画面データ。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class S1001Dto extends BaseDto {
   /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

   /**
     * LoginID
     */
    private String loginID;

   /**
     * oldPassword
     */
    private String oldPassword;

   /**
     * newPassword
     */
    private String newPassword;

   /**
     * confirmNewPassword
     */
    private String confirmNewPassword;

   /**
     * PswChangeDate
     */
    private Date pwdChangeDate;

    /**
     * userType
     */

    private String userType;

    /**
     * userType
     */

    private String modeType;

    /**
     * divType
     */
    private String divType;

    /**
     * <p>[概 要] divTypeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String divType
     */
   public String getDivType() {
        return divType;
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
    * <p>[概 要] divTypeの設定。</p>
    * <p>[詳 細] </p>
    * <p>[備 考] </p>
    *
    * @param divType divType
    */
    public void setDivType(String divType) {
        this.divType = divType;
    }

    /**
     * <p>[概 要] loginIDの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String loginID
     */
    public String getLoginID() {
        return loginID;
    }

   /**
     * <p>[概 要] getOldPasswordの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String getOldPassword
     */
    public String getOldPassword() {
        return oldPassword;
  }

   /**
     * <p>[概 要] getNewPasswordの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String getNewPassword
     */
    public String getNewPassword() {
       return newPassword;
   }


   /**
     * <p>[概 要] confirmNewPasswordの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String confirmNewPassword
     */
    public String getConfirmNewPassword() {
       return confirmNewPassword;
   }
   /**
     * <p>[概 要] PswChangeDateの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String pwdChangeDate
     */
    public Date getPwdChangeDate() {
       return pwdChangeDate;
    }
   /**
     * <p>[概 要] PswChangeDateの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String PswChangeDate
     */
    public String getUserType() {
       return userType;
    }

   /**
     * <p>[概 要] loginIDの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param loginID loginID
     */
    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }


   /**
     * <p>[概 要] oldPasswordの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param oldPassword oldPassword
     */
    public void setOldPassword(String oldPassword) {
         this.oldPassword = oldPassword;
    }
   /**
     * <p>[概 要] newPasswordの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param newPassword newPassword
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
   /**
     * <p>[概 要] confirmNewPasswordの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param confirmNewPassword confirmNewPassword
     */
     public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
      }
   /**
     * <p>[概 要] pwdChangeDateの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param pwdChangeDate pwdChangeDate
     */
     public void setPwdChangeDate(Date pwdChangeDate) {
       this.pwdChangeDate = pwdChangeDate;
     }
   /**
     * <p>[概 要] PswChangeDateの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param userType userType
     */
     public void setUserType(String userType) {
       this.userType = userType;
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
}
