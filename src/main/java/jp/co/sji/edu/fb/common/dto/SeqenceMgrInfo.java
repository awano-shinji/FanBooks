package jp.co.sji.edu.fb.common.dto;

import java.io.Serializable;
/**
 * <p>[概 要] SeqenceMgrInfoのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class SeqenceMgrInfo implements Serializable {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * IDType
     */
    private String iDType;

    /**
     * IDStart
     */
    private int iDStart;

    /**
     * IDEnd
     */
    private int iDEnd;

    /**
     * Seqence
     */
    private int seqence;

    /**
     * Remark
     */
    private String remark;


    /**
     * <p>[概 要] IDTypeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String IDType
     */
    public String getIDType() {
        return iDType;
    }

    /**
     * <p>[概 要] IDStartの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return int IDStart
     */
    public int getIDStart() {
        return iDStart;
    }

    /**
     * <p>[概 要] IDEndの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return int IDEnd
     */
    public int getIDEnd() {
        return iDEnd;
    }

    /**
     * <p>[概 要] Seqenceの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return int Seqence
     */
    public int getSeqence() {
        return seqence;
    }

    /**
     * <p>[概 要] Remarkの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>[概 要] IDTypeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param iDType IDType
     */
    public void setIDType(String iDType) {
        this.iDType = iDType;
    }

    /**
     * <p>[概 要] IDStartの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param iDStart IDStart
     */
    public void setIDStart(int iDStart) {
        this.iDStart = iDStart;
    }

    /**
     * <p>[概 要] IDEndの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param iDEnd IDEnd
     */
    public void setIDEnd(int iDEnd) {
        this.iDEnd = iDEnd;
    }

    /**
     * <p>[概 要] Seqenceの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param seqence Seqence
     */
    public void setSeqence(int seqence) {
        this.seqence = seqence;
    }

    /**
     * <p>[概 要] Remarkの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param remark Remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}

