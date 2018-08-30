package jp.co.sji.edu.fb.service;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.MenuInfo;
import jp.co.sji.edu.fb.common.dto.SystemInfo;
import jp.co.sji.edu.fb.common.dto.UserInfo;

import org.springframework.transaction.annotation.Transactional;


/**
 * <p>[概 要] L0101のServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface L0101Service {

    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userDto userDto
     * @return UserInfo UserInfo情報
     */
    UserInfo getLoginInfo(UserInfo userDto);

    /**
     * <p>[概 要] SystemInfo情報のRunFlag情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return SystemInfo SystemInfo情報
     */
    SystemInfo getRunFlagInfo();

    /**
     * <p>[概 要] MenuInfo情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userType userType情報
     * @return List<List<MenuInfo>> MenuInfo情報
     */
    @Transactional(readOnly = true)
    List<List<MenuInfo>> getMenuInfo(String userType);

}
