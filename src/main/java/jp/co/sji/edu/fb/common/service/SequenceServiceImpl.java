package jp.co.sji.edu.fb.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sji.edu.fb.common.dao.SeqenceMgrInfoDao;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.common.util.MessageUtil;
import jp.co.sji.edu.fb.common.util.StringUtil;

/**
 * <p>[概 要] P0202のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("sequenceService")
public class SequenceServiceImpl implements SequenceService {

    /**
     * SeqenceMgrInfoDao
     */
    @Autowired(required = true)
    private SeqenceMgrInfoDao seqenceMgrInfoDao;

    /**
     * <p>[概 要] IDを払出する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param idType 払出種類
     * @return 払出したID
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String getSeqNo(String idType) {
        // IDを払出する
        String seqence = seqenceMgrInfoDao.selectSeqNo(idType);
        if (StringUtil.isEmpty(seqence)) {
            throw new BpException(MessageUtil.getMessage("E0011"));
        }
        // IDを更新する
        seqenceMgrInfoDao.updateSeqNo(idType, seqence);
        //IDをPrefix+固定桁にFormat
        seqence = idType + String.format("%05d", Integer.parseInt(seqence));
        return seqence;
    }

}
