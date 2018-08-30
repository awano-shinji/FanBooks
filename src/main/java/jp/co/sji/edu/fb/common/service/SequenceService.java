package jp.co.sji.edu.fb.common.service;


/**
 * <p>[概 要] SequenceのServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface SequenceService {

    /**
     * <p>[概 要] IDを払出する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param idType 払出種類
     * @return 払出したID
     */
    String getSeqNo(String idType);
}
