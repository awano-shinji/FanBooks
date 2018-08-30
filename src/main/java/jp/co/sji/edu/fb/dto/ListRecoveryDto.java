package jp.co.sji.edu.fb.dto;

/**
 * <p>[概 要] 一覧用回復共通DTOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) </p>
 * @author SJI.EDU
 */
public class ListRecoveryDto extends BaseDto {

    /**
     * シリアル番号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 遷移元画面ID
     */
    private String motoID;

    /**
     * 遷移元画面Back用キー
     */
    private String motoAction;

    /**
     * 遷移先画面ID
     */
    private String sakiID;

    /**
     * 一覧１ソート順
     */
    private String sort1;

    /**
     * 一覧２ソート順
     */
    private String sort2;

    /**
     * 一覧３ソート順
     */
    private String sort3;

    /**
     * currently
     */
    private int currently;

    /**
     * V0101とP0206条件の設定。
     */
    private String flagPage;

    /**
     * <p>[概 要] V0101とP0206条件の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return flagPage flagPage
     */
    public String getFlagPage() {
        return flagPage;
    }

    /**
     * <p>[概 要] V0101とP0206条件の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param flagPage flagPage
     */
    public void setFlagPage(String flagPage) {
        this.flagPage = flagPage;
    }

    /**
     * <p>[概 要] currently。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return currently currently
     */
    public int getCurrently() {
        return currently;
    }

    /**
     * <p>[概 要] currently用キ。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param currently currently
     */
    public void setCurrently(int currently) {
        this.currently = currently;
    }

    /**
     * <p>[概 要] 移元画面Back用キ。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String 移元画面
     */
    public String getMotoAction() {
        return motoAction;
    }

    /**
     * <p>[概 要] 移元画面Back用キ。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param motoAction 移元画面
     */
    public void setMotoAction(String motoAction) {
        this.motoAction = motoAction;
    }

    /**
     * <p>[概 要] 遷移元画面IDの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String 遷移元画面ID
     */
    public String getMotoID() {
        return motoID;
    }

    /**
     * <p>[概 要] 遷移先画面IDの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String 遷移先画面ID
     */
    public String getSakiID() {
        return sakiID;
    }

    /**
     * <p>[概 要] 一覧１ソート順の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String 一覧１ソート順
     */
    public String getSort1() {
        return sort1;
    }

    /**
     * <p>[概 要] 一覧２ソート順の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String 一覧２ソート順
     */
    public String getSort2() {
        return sort2;
    }

    /**
     * <p>[概 要] 一覧３ソート順の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String 一覧３ソート順
     */
    public String getSort3() {
        return sort3;
    }


    /**
     * <p>[概 要] 遷移元画面IDの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param motoID 遷移元画面ID
     */
    public void setMotoID(String motoID) {
        this.motoID = motoID;
    }

    /**
     * <p>[概 要] 遷移先画面IDの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param sakiID 遷移先画面ID
     */
    public void setSakiID(String sakiID) {
        this.sakiID = sakiID;
    }

    /**
     * <p>[概 要] 一覧１ソート順の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param sort1 一覧１ソート順
     */
    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    /**
     * <p>[概 要] 一覧２ソート順の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param sort2 一覧２ソート順
     */
    public void setSort2(String sort2) {
        this.sort2 = sort2;
    }

    /**
     * <p>[概 要] 一覧３ソート順の設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param sort3 一覧３ソート順
     */
    public void setSort3(String sort3) {
        this.sort3 = sort3;
    }


}

