package jp.co.sji.edu.fb.common.dao;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.dto.P0101CondDto;
import jp.co.sji.edu.fb.dto.S0101Dto;



/**
 * <p>[概 要] UserInfoのDAOのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface UserInfoDao {

    /**
     * <p>[概 要] UserInfo情報を登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param info UserInfo情報
     * @return UserInfo UserInfo情報
     */
    UserInfo insert(UserInfo info);

    /**
     * <p>[概 要] 条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param condDto 条件DTO
     * @return List ユーザリスト
     */
    List<UserInfo> selectUsers(P0101CondDto condDto);

    /**
     * <p>[概 要] loginIDで条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID Login中のloginID
     * @return UserInfo ユーザ情報
     */
    UserInfo selectUserByLoginID(String loginID);

    /**
     * <p>[概 要] loginIDで条件を絞り込みユーザ情報を検索する。(Status不問)</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID Login中のloginID
     * @return UserInfo ユーザ情報
     */
    UserInfo selectAllUserByLoginID(String loginID);

    /**
     * <p>[概 要] ユーザ情報のEmail情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID ログインID
     * @return UserInfo ユーザ情報
     */
    UserInfo selectEmail(String loginID);

    /**
     * <p>[概 要] UserInfo情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userInfo userInfo
     * @return int 更新件数
     */
    int updateEmail(UserInfo userInfo);

    /**
     * <p>[概 要] Operator Teamリストを検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return List Operator Teamリスト
     */
    List<UserInfo> selectOperatorTeam();

    /**
     * <p>[概 要] Password情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID ログインID
     * @return List ユーザリスト
     */
    List<UserInfo> selectPassword(String loginID);


    /**
     * <p>[概 要] Password情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userInfo userInfo
     * @return int 更新件数
     */
    int updatePassword(UserInfo userInfo);

    /**
     * <p>[概 要] SiteManager情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return UserInfo ユーザ情報
     */
    UserInfo selectSiteManager();

    /**
     * <p>[概 要] ログイン情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userDto userDto
     * @return UserInfo ユーザ情報
     */
    List<UserInfo> selectLoginInfo(UserInfo userDto);

    /**
     * <p>[概 要] 条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return List ユーザリスト
     */
    List<UserInfo> selectMolUser();

    /**
     * <p>[概 要] User情報を登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto情報
     */
    void insertUser(S0101Dto s0101Dto);

    
    /**
     * <p>[概 要] User情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto
     * @return int 更新件数
     */
    int updateUser(S0101Dto s0101Dto);

    /**
     * <p>[概 要] ユーザ情報のUserType情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID ログインID
     * @return UserInfo ユーザ情報
     */
    UserInfo selectUserType(String loginID);

    /**
     * <p>[概 要] loginIDで条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param supplier supplier
     * @return UserInfo ユーザ情報
     */
    UserInfo selectSupplier(String supplier);

    /**
     * <p>[概 要] loginIDで条件を絞り込みユーザ情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID Login中のloginID
     * @return UserInfo ユーザ情報
     */
    UserInfo selectUserLoginID(String loginID);

  }



