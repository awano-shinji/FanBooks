package jp.co.sji.edu.fb.common.dto;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>[概 要] SystemInfoのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class SystemInfo implements Serializable {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * ETARemarkDays
     */
    private int eTARemarkDays;

    /**
     * InitialPassword
     */
    private String initialPassword;

    /**
     * RunFlag
     */
    private String runFlag;

    /**
     * BNKLDMail
     */
    private String bnkldMail;

    /**
     * historyDownloadFlag
     */
    private String historyDownloadFlag;

    /**
     * historyDownloadTime
     */
    private Date historyDownloadTime;

	/**
     * <p>[概 要] historyDownloadFlagの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String historyDownloadFlag
     */
    public String getHistoryDownloadFlag() {
		return historyDownloadFlag;
	}

    /**
     * <p>[概 要] historyDownloadFlagの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param historyDownloadFlag historyDownloadFlag
     */
	public void setHistoryDownloadFlag(String historyDownloadFlag) {
		this.historyDownloadFlag = historyDownloadFlag;
	}

	/**
     * <p>[概 要] historyDownloadTimeの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return Date historyDownloadTime
     */
	public Date getHistoryDownloadTime() {
		return historyDownloadTime;
	}

    /**
     * <p>[概 要] historyDownloadTimeの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param historyDownloadTime historyDownloadTime
     */
	public void setHistoryDownloadTime(Date historyDownloadTime) {
		this.historyDownloadTime = historyDownloadTime;
	}

    /**
     * <p>[概 要] ETARemarkDaysの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return int ETARemarkDays
     */
    public int getETARemarkDays() {
        return eTARemarkDays;
    }

    /**
     * <p>[概 要] InitialPasswordの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String InitialPassword
     */
    public String getInitialPassword() {
        return initialPassword;
    }

    /**
     * <p>[概 要] RunFlagの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String RunFlag
     */
    public String getRunFlag() {
        return runFlag;
    }

    /**
     * <p>[概 要] ETARemarkDaysの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param eTARemarkDays ETARemarkDays
     */
    public void setETARemarkDays(int eTARemarkDays) {
        this.eTARemarkDays = eTARemarkDays;
    }

    /**
     * <p>[概 要] InitialPasswordの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param initialPassword InitialPassword
     */
    public void setInitialPassword(String initialPassword) {
        this.initialPassword = initialPassword;
    }

    /**
     * <p>[概 要] RunFlagの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param runFlag RunFlag
     */
    public void setRunFlag(String runFlag) {
        this.runFlag = runFlag;
    }

    /**
     * <p>[概 要] bnkldMailの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String bnkldMail
     */
    public String getBnkldMail() {
        return bnkldMail;
    }

    /**
     * <p>[概 要] bnkldMailの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param bnkldMail bnkldMail
     */
    public void setBnkldMail(String bnkldMail) {
        this.bnkldMail = bnkldMail;
    }
}

