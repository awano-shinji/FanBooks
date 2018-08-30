package jp.co.sji.edu.fb.service;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dao.UserInfoDao;
import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.common.util.CodeUtil;
import jp.co.sji.edu.fb.common.util.MessageUtil;
import jp.co.sji.edu.fb.common.util.StringUtil;
import jp.co.sji.edu.fb.dto.S0101Dto;
import net.sf.json.JSONArray;
/**
 * <p>[概 要] S0101のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("s0101Service")
public class S0101ServiceImpl implements S0101Service {

    /**
     * UserInfoDao
     */
    @Autowired(required = true)
    private UserInfoDao userInfoDao;

    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param errorFlg errorFlg
     * @param singleFlg 単一ユーザモード
     * @param s0101Dto s0101Dto
     * @return S0101Dto
     */
    @Transactional(readOnly = true)
    public S0101Dto getInitInfo(boolean singleFlg, boolean errorFlg,
            S0101Dto s0101Dto) {
        if (singleFlg) {
            // loginIDで条件を絞り込みユーザ情報を検索する
            UserInfo user = userInfoDao
                    .selectUserLoginID(s0101Dto.getLoginID());
            s0101Dto.setUserName(user.getUserName());
            s0101Dto.setPassword(user.getPassword1());
            s0101Dto.setEmail(user.getEmail());
            s0101Dto.setStatus(user.getStatus());
            s0101Dto.setLastUpdate(user.getLastUpdate());

        } else {
            // Userリスト を取得する。
            JSONArray userDropList = new JSONArray();
            List<UserInfo> userInfoList = userInfoDao.selectMolUser();
            UserInfo emptyuser = new UserInfo();
            emptyuser.setLoginID(StringUtil.BLANK);
            emptyuser.setUserName(Constants.DRP_EMPTY_SELECT);
            userInfoList.add(0, emptyuser);
            userDropList.addAll(userInfoList);
            s0101Dto.setUserNameList(userDropList.toString());

        }

        // ステータスリストを取得する
        s0101Dto.setStatusList(CodeUtil.getComBox(Constants.CD_GROUP_STATUS,
                null));
        s0101Dto.setUserType(Constants.KEY_USER_OPERATOR);
        return s0101Dto;
    }

    /**
     * <p>[概 要] User情報を新規する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto
     * @throws IOException IOException
     */
    @Transactional()
    public void insertUser(S0101Dto s0101Dto) throws IOException {
        UserInfo user = userInfoDao.selectUserLoginID(s0101Dto.getLoginID());
        // ユーザの重複チェック
        if (null != user) {
            throw new BpException(MessageUtil.getMessage("E0007", "LoginID"));
        } else {
            // ユーザを登録する
            userInfoDao.insertUser(s0101Dto);
        }


    }

    /**
     * <p>[概 要] User情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto
     */
    @Transactional()
    public void updateUser(S0101Dto s0101Dto) {
        // ユーザ情報を更新する。
        int updCnt = userInfoDao.updateUser(s0101Dto);
        // 更新0件の場合、排他エラーとする
        if (updCnt == 0) {
            throw new BpException(MessageUtil.getMessage("E0014"));
        }

    }
}
