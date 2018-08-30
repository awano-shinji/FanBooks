package jp.co.sji.edu.fb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dao.UserInfoDao;
import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.util.CodeUtil;
import jp.co.sji.edu.fb.common.util.StringUtil;
import jp.co.sji.edu.fb.dto.P0101CondDto;
import jp.co.sji.edu.fb.dto.P0101ResultDto;

/**
 * <p>[概 要] P0101のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("p0101Service")
public class P0101ServiceImpl implements P0101Service {

    /**
     * UserInfoDaos
     */
    @Autowired(required = true)
    private UserInfoDao userInfoDao;

    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param condDto P0101画面の検索条件
     * @return List<P0101ResultDto> ユーザリスト
     */
    @Transactional(readOnly = true)
    public List<P0101ResultDto> getInitInfo(P0101CondDto condDto) {
        List<UserInfo> userList = userInfoDao.selectUsers(condDto);
        List<P0101ResultDto> retList = new ArrayList<P0101ResultDto>();
        // DBデータを画面データに転換する
        for (UserInfo userInfo : userList) {
            P0101ResultDto userDto = new P0101ResultDto();
            userDto.setLoginID(StringUtil.escapeHtml(userInfo.getLoginID()));
            userDto.setUserName(StringUtil.escapeHtml(userInfo.getUserName()));
            userDto.setUserType(userInfo.getUserType());
            userDto.setUserTypeName(CodeUtil.getNameByCd(
                    Constants.CD_GROUP_USERTYPE, userInfo.getUserType()));
            userDto.setStatusName(CodeUtil.getNameByCd(
                    Constants.CD_GROUP_STATUS, userInfo.getStatus()));
            userDto.setLastUpdate(userInfo.getLastUpdate());
            retList.add(userDto);
        }
        return retList;
    }
}
