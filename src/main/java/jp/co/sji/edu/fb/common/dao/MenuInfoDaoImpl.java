package jp.co.sji.edu.fb.common.dao;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.MenuInfo;

import org.springframework.stereotype.Repository;

/**
 * <p>[概 要] MenuInfoのDAOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c).</p>
 * @author Edu.SJI
 */
@Repository ("menuInfoDao")
public class MenuInfoDaoImpl extends BaseDao implements MenuInfoDao  {
    /**
     * <p>[概 要] MenuInfo情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userType userType情報
     * @return MenuInfo MenuInfo情報
     */
    public List<MenuInfo> selectMenu(String userType) {
        return (List<MenuInfo>) queryForList("menuInfo.selectMenu", userType);
    }

}

