package jp.co.sji.edu.fb.service;

import java.io.IOException;
import java.util.List;

import jp.co.sji.edu.fb.common.dao.UserInfoDao;
import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.common.util.DateUtil;
import jp.co.sji.edu.fb.common.util.MessageUtil;
import jp.co.sji.edu.fb.dto.S1001Dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> [概 要] ChangePasswordServiceのクラス。</p>
 * <p>[詳 細]</p>
 * <p> [備 考]</p>
 * <p>Copyright(c) . </p>
 * @author Edu.SJI
 */
@Service("s1001Service")
public class S1001ServiceImpl implements S1001Service {

   /**
     * UserInfoDao
     */
    @Autowired(required = true)
    private UserInfoDao userInfoDao;

   /**
     * <p>[概 要] Change Password処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s1001Dto S1001画面情報
 * @throws IOException IOException
     */
    @Transactional(readOnly = true)
    public void updatePassword(S1001Dto s1001Dto) throws IOException {
        String newPassword = s1001Dto.getNewPassword();
        //
        List<UserInfo> userInfoList = userInfoDao.selectPassword(s1001Dto
                .getLoginID());
        UserInfo updateUser = new UserInfo();
        // パスワードフラグ
        boolean isPasswordOK = false;
        UserInfo loginUser = null;
        for (UserInfo userInfo : userInfoList) {
            // 旧パスワードチェック
            if (s1001Dto.getOldPassword().equals(userInfo.getPassword1())
                    || s1001Dto.getOldPassword()
                            .equals(userInfo.getPassword1())
                    || s1001Dto.getOldPassword()
                            .equals(userInfo.getPassword1())
                    || s1001Dto.getOldPassword()
                            .equals(userInfo.getPassword1())
                    || s1001Dto.getOldPassword()
                            .equals(userInfo.getPassword1())) {
                isPasswordOK = true;
            }
            if (s1001Dto.getLoginID().equals(userInfo.getLoginID())) {
                loginUser = userInfo;
            }
        }
        // パスワード正しいの場合
        if (isPasswordOK) {
            // 同じパスワードが５世代以内に使用されていないかをチェックする。
            if (!newPassword.equals(loginUser.getPassword1())
                    && !newPassword.equals(loginUser.getPassword2())
                    && !newPassword.equals(loginUser.getPassword3())
                    && !newPassword.equals(loginUser.getPassword4())
                    && !newPassword.equals(loginUser.getPassword5())) {
                updateUser.setLoginID(s1001Dto.getLoginID());
                updateUser.setPassword1(newPassword);
                updateUser.setPassword2(loginUser.getPassword1());
                updateUser.setPassword3(loginUser.getPassword2());
                updateUser.setPassword4(loginUser.getPassword3());
                updateUser.setPassword5(loginUser.getPassword4());
                updateUser.setPwdChangeDate(DateUtil.getCurrentDate());
                userInfoDao.updatePassword(updateUser);
            } else {
                // 新パスワードが2.3の①で取得したPassword1-5にある場合、エラーを表示する。
                throw new BpException(MessageUtil.getMessage("W0007"));
            }
        } else {
            // 旧パスワードが①で検索したPasswordと異なる場合、エラーを表示する。
            throw new BpException(MessageUtil.getMessage("E0002"));
        }

    }
}
