package jp.co.sji.edu.fb.common.dao;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.util.StringUtil;
import jp.co.sji.edu.fb.dto.P0101CondDto;
import jp.co.sji.edu.fb.dto.S0101Dto;

import org.springframework.stereotype.Repository;

/**
 * <p>[概 要] UserInfoのDAOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Repository ("userInfoDao")
public class UserInfoDaoImpl extends BaseDao implements UserInfoDao  {
    /**
     * <p>[概 要] UserInfo情報を登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param info UserInfo情報
     * @return UserInfo UserInfo情報
     */
    public UserInfo insert(UserInfo info) {
        return (UserInfo) insert("userInfo.insert", info);
    }

    /**
     * <p>[概 要] 条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param condDto 条件DTO
     * @return List ユーザリスト
     */
    public List<UserInfo> selectUsers(P0101CondDto condDto) {
        P0101CondDto paramDto = escapeDto(condDto);
        return (List<UserInfo>) queryForList("userInfo.selectUsers", paramDto);
    }

    /**
     * <p>[概 要] loginIDで条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID Login中のloginID
     * @return List ユーザリスト
     */
    public UserInfo selectUserByLoginID(String loginID) {
        return (UserInfo) queryForObject("userInfo.selectUserByLoginID", loginID);
    }

    /**
     * <p>[概 要] loginIDで条件を絞り込みユーザ情報を検索する。(Status不問)</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID Login中のloginID
     * @return List ユーザリスト
     */
    public UserInfo selectAllUserByLoginID(String loginID) {
        return (UserInfo) queryForObject("userInfo.selectAllUserByLoginID", loginID);
    }

    /**
     * <p>[概 要] ユーザ情報のEmail情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID ログインID
     * @return UserInfo ユーザ情報
     */
    public UserInfo selectEmail(String loginID) {
        return (UserInfo) queryForObject("userInfo.selectEmail", loginID);
    }


    /**
     * <p>[概 要] UserInfo情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userInfo userInfo
     * @return int 更新件数
     */
    public int updateEmail(UserInfo userInfo) {
        return update("userInfo.updateEmail", userInfo);
    }

    /**
     * <p>[概 要] Operator Teamリストを検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return List Operator Teamリスト
     */
    public List<UserInfo> selectOperatorTeam() {
        return (List<UserInfo>) queryForList("userInfo.selectOperatorTeam");
    }

    /**
     * <p>[概 要] Password情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID ログインID
     * @return List ユーザリスト
     */
    public List<UserInfo> selectPassword(String loginID) {
        return (List<UserInfo>) queryForList("userInfo.selectPassword", loginID);
    }

    /**
     * <p>[概 要] Password情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userInfo userInfo
     * @return int 更新件数
     */
    public int updatePassword(UserInfo userInfo) {
        return update("userInfo.updatePassword", userInfo);
    }

    /**
     * <p>[概 要] SiteManager情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return UserInfo ユーザ情報
     */
    public UserInfo selectSiteManager() {
        return (UserInfo) queryForObject("userInfo.selectSiteManager");
    }

    /**
     * <p>[概 要] ログイン情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userDto userDto
     * @return UserInfo ユーザ情報
     */
    public List<UserInfo> selectLoginInfo(UserInfo userDto) {
        return (List<UserInfo>) queryForList("userInfo.selectLoginInfo",
                userDto);
    }

    /**
     * <p>[概 要] 条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return List ユーザリスト
     */
    public List<UserInfo> selectMolUser() {
        return (List<UserInfo>) queryForList("userInfo.selectMolUser");
    }

    /**
     * <p>[概 要] User情報を登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto情報
     */
    public void insertUser(S0101Dto s0101Dto) {
        insert("userInfo.insertUser", s0101Dto);
    }
   
    /**
     * <p>[概 要] User情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto
     * @return int 更新件数
     */
    public int updateUser(S0101Dto s0101Dto) {
        return update("userInfo.updateUser", s0101Dto);
    }
        
    /**
     * <p>[概 要] ユーザ情報のUserType情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID ログインID
     * @return UserInfo ユーザ情報
     */
    public UserInfo selectUserType(String loginID) {
        return (UserInfo) queryForObject("userInfo.selectUserType", loginID);
    }

    /**
     * <p>[概 要] loginIDで条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param supplier supplier
     * @return UserInfo ユーザ情報
     */
    public UserInfo selectSupplier(String supplier) {
        return (UserInfo) queryForObject("userInfo.selectSupplier", supplier);
    }

    /**
     * <p>[概 要] loginIDで条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID Login中のloginID
     * @return List ユーザリスト
     */
    public UserInfo selectUserLoginID(String loginID) {
        return (UserInfo) queryForObject("userInfo.selectUserLoginID", loginID);
    }

    /**
     * <p>[概 要] P0101CondDtoの取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param P0101CondDto condDto対象
     * @return P0101CondDto escapeDtoリスト
     */
    private P0101CondDto escapeDto(P0101CondDto condDto) {
        P0101CondDto p0101CondDto = new P0101CondDto();
        p0101CondDto.setName(StringUtil.escapeSql(condDto.getName()));
        p0101CondDto.setLoginID(condDto.getLoginID());
        p0101CondDto.setType(condDto.getType());
        p0101CondDto.setStatus(condDto.getStatus());
        return p0101CondDto;
    }


}

