package jp.co.sji.edu.fb.common.dao;

import jp.co.sji.edu.fb.common.dto.SeqenceMgrInfo;

import org.springframework.stereotype.Repository;

/**
 * <p>[概 要] SeqenceMgrInfoのDAOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Repository ("seqenceMgrInfoDao")
public class SeqenceMgrInfoDaoImpl extends BaseDao implements SeqenceMgrInfoDao  {
    /**
     * <p>[概 要] IDを払出する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param idType ID種類
     * @return ID
     */
    public String selectSeqNo(String idType) {
        return (String) queryForObject("seqenceMgrInfo.selectSeqNo", idType);
    }

    /**
     * <p>[概 要] IDを更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param idType ID種類
     * @param seqence ID
     * @return 更新件数
     */
    public int updateSeqNo(String idType, String seqence) {
        SeqenceMgrInfo info = new SeqenceMgrInfo();
        info.setIDType(idType);
        info.setSeqence(Integer.valueOf(seqence).intValue());
        return update("seqenceMgrInfo.updateSeqNo", info);
    }
}

