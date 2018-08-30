package jp.co.sji.edu.fb.dto;

import jp.co.sji.edu.fb.common.dto.UserInfo;

/**
 * <p>[概 要] P0101の画面データ。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class P0101Dto extends BaseDto {

    /**
     * Serial
     */
    private static final long serialVersionUID = 5046411049766117857L;

    /**
     * 検索条件
     */
    private P0101CondDto condDto;

    /**
     * userInfo
     */
    private UserInfo userInfo;

    /**
     * <p>[概 要] P0101CondDtoの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return P0101CondDto p0101CondDto
     */
    public P0101CondDto getCondDto() {
        return condDto;
    }

    /**
     * <p>[概 要] P0101CondDtoの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param condDto condDto
     */
    public void setCondDto(P0101CondDto condDto) {
        this.condDto = condDto;
    }

    /**
     * <p>[概 要] UserInfoの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return UserInfo userInfo
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * <p>[概 要] UserInfoの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param userInfo userInfo
     */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

}

