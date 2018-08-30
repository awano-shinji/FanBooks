package jp.co.sji.edu.fb.common.dao;


/**
 * <p>[概 要] SeqenceMgrInfoのDAOのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface SeqenceMgrInfoDao {

    /**
     * <p>[概 要] IDを払出する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param idType ID種類
     * @return String ID
     */
    String selectSeqNo(String idType);

    /**
     * <p>[概 要] IDを更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param idType ID種類
     * @param seqence ID
     * @return 更新件数
     */
    int updateSeqNo(String idType, String seqence);
}

