package jp.co.sji.edu.fb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dao.MenuInfoDao;
import jp.co.sji.edu.fb.common.dao.SystemInfoDao;
import jp.co.sji.edu.fb.common.dao.UserInfoDao;
import jp.co.sji.edu.fb.common.dto.MenuInfo;
import jp.co.sji.edu.fb.common.dto.SystemInfo;
import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.common.util.DateUtil;
import jp.co.sji.edu.fb.common.util.MessageUtil;
import jp.co.sji.edu.fb.common.util.StringUtil;


/**
 * <p>[概 要] L0101のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("l0101Service")
public class L0101ServiceImpl implements L0101Service {

    /**
     * UserInfoDao
     */
    @Autowired(required = true)
    private UserInfoDao userInfoDao;


    /**
     * SystemInfoDao
     */
    @Autowired(required = true)
    private SystemInfoDao systemInfoDao;


    /**
     * MenuInfoDao
     */
    @Autowired(required = true)
    private MenuInfoDao menuInfoDao;

    /**
     * <p>[概 要] 検索、ログイン処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userDto userDto
     * @return UserInfo UserInfo情報
     */
    @Transactional(readOnly = true)
    public UserInfo getLoginInfo(UserInfo userDto) {

        List<UserInfo> userList = userInfoDao.selectLoginInfo(userDto);
        UserInfo loginUser = null;
        String remark = userDto.getRemark();
        if (StringUtil.isNotEmpty(remark)) {
            for (UserInfo user : userList) {
                // ログインユーザ．LoginIDとパラメータ．LoginIDを比較
                if (user.getLoginID().equals(userDto.getLoginID())) {
                    return user;
                }
            }
        }
        boolean isUserExist = false;

        /*   なぜサイトマネージャも一緒に比べるかは分からない
        for (UserInfo user : userList) {
            // ログインユーザ．LoginIDとパラメータ．LoginIDを比較
            if (user.getLoginID().equals(userDto.getLoginID())) {
                isUserExist = true;
                loginUser = user;
            }
        }
        // 不一致の場合、処理を中止し、エラーメッセージをログイン画面に表示する
        if (!isUserExist) {
            throw new BpException(MessageUtil.getMessage("E0001"));
        }
        boolean isPasswordOK = false;
        for (UserInfo use : userList) {
            // ログイン．Passwordとパラメータ．Passwordを比較
            if (use.getPassword1().equals(userDto.getPassword1())) {
                isPasswordOK = true;
            }
        }
        */

        // １ユーザのみログイン検証するように変更            Uyo.Tatsumi 2013.06
        UserInfo user = userInfoDao.selectUserByLoginID(userDto.getLoginID());
        if(null != user){
        	isUserExist = true;
        	loginUser = user;
        }
        // 不一致の場合、処理を中止し、エラーメッセージをログイン画面に表示する
        if (!isUserExist) {
            throw new BpException(MessageUtil.getMessage("E0001"));
        }
        boolean isPasswordOK = false;
        // ログイン．Passwordとパラメータ．Passwordを比較
        if (user.getPassword1().equals(userDto.getPassword1())) {
            isPasswordOK = true;
        }
        // ---- end modify 2013.06

        // 不一致の場合、処理を中止し、エラーメッセージをログイン画面に表示する
        if (!isPasswordOK) {
            throw new BpException(MessageUtil.getMessage("E0001"));
        }

        // 該当ユーザのPwdChangeDateを利用して、パスワード切れかどうかを判定する
        if (DateUtil.addDays(
                DateUtil.addMonths(loginUser.getPwdChangeDate(),
                        DateUtil.DATE_PATTERN_0,
                        Constants.KEY_USER_MOUNTH_EXPIRE),
                DateUtil.DATE_PATTERN_0, Constants.KEY_USER_DAY).compareTo(
                DateUtil.getCurrentDate(DateUtil.DATE_PATTERN_0)) < 0) {
            // 3ヶ月の前の時間とpwdChangeDateを比較
            if (DateUtil
                    .addMonths(loginUser.getPwdChangeDate(),
                            DateUtil.DATE_PATTERN_0,
                            Constants.KEY_USER_MOUNTH_EXPIRE)
                    .compareTo(DateUtil.getCurrentDate(DateUtil.DATE_PATTERN_0)) < 0) {
                // 12ヶ月の前の時間とpwdChangeDateを比較
                if (DateUtil.addMonths(loginUser.getPwdChangeDate(),
                        DateUtil.DATE_PATTERN_0,
                        Constants.KEY_USER_MOUNTH_FREEZE).compareTo(
                        DateUtil.getCurrentDate(DateUtil.DATE_PATTERN_0)) < 0) {
                    // PwdChangeDateから1年が過ぎた場合、SiteManagerへ連絡のメッセージを表示
                    throw new BpException(MessageUtil.getMessage("E0004"));
                } else {
                    // パスワードの有効期限を過ぎた場合
                    throw new BpException(MessageUtil.getMessage("E0003"));
                }
            } else {
                // パスワードの有効期限（PwdChangeDateから3カ月後）～切れる一週間前の場合
                long dayCnt = DateUtil.getDateCntBetweenTwoDay(DateUtil
                        .getCurrentDate(), DateUtil.addMonths(
                        loginUser.getPwdChangeDate(),
                        Constants.KEY_USER_MOUNTH_EXPIRE));
                throw new BpException(MessageUtil.getMessage("W0011",
                        String.valueOf(dayCnt)));
            }
        }
        return loginUser;
    }
    /**
     * <p>[概 要] SystemInfo情報のRunFlag情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return SystemInfo SystemInfo情報
     */
    @Transactional(readOnly = true)
    public SystemInfo getRunFlagInfo() {
        return systemInfoDao.selectRunFlag();
    }

    /**
     * <p>[概 要] MenuInfo情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userType userType情報
     * @return List<List<MenuInfo>> MenuInfo情報
     */
    @Transactional(readOnly = true)
    public List<List<MenuInfo>> getMenuInfo(String userType) {
        List<MenuInfo> menuList = menuInfoDao.selectMenu(userType);
        List<List<MenuInfo>> menuGroupList = new ArrayList<List<MenuInfo>>();
        List<MenuInfo> subGroupList = new ArrayList<MenuInfo>();
        String menuGroup = "";
        for (MenuInfo menu : menuList) {
            if (menuGroup.equals(menu.getMenuGroup())) {
                subGroupList.add(menu);
            } else {
                if (subGroupList.isEmpty()) {
                    subGroupList = new ArrayList<MenuInfo>();
                } else {
                    menuGroupList.add(subGroupList);
                    subGroupList = new ArrayList<MenuInfo>();
                }
                menuGroup = menu.getMenuGroup();
                subGroupList.add(menu);
            }
        }
        menuGroupList.add(subGroupList);
        return menuGroupList;

    }
}
