package jp.co.sji.edu.fb.common.dao;

import jp.co.sji.edu.fb.common.dto.SystemInfo;


/**
 * <p>[概 要] SystemInfoのDAOのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface SystemInfoDao {

    /**
     * <p>[概 要] SystemInfo情報のRunFlag情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return SystemInfo SystemInfo情報
     */
    SystemInfo selectRunFlag();

}

