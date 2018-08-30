package jp.co.sji.edu.fb.common.dao;


import jp.co.sji.edu.fb.common.dto.SystemInfo;

import org.springframework.stereotype.Repository;

/**
 * <p>[概 要] SystemInfoのDAOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Repository ("systemInfoDao")
public class SystemInfoDaoImpl extends BaseDao implements SystemInfoDao  {

    /**
     * <p>[概 要] SystemInfo情報のRunFlag情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return SystemInfo SystemInfo情報
     */
    public SystemInfo selectRunFlag() {
        return (SystemInfo) queryForObject("systemInfo.selectRunFlag");
    }

}

