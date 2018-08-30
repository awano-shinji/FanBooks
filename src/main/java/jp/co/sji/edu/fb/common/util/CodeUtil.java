package jp.co.sji.edu.fb.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.sji.edu.fb.common.dto.CodeMasterInfo;


/**
 * <p>[概 要] コード情報処理共通クラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class CodeUtil {

    /**
     * コードマップ
     */
    private static Map<String, List<CodeMasterInfo>> cdMap;

    /**
     * <p>[概 要] コンストラクタ。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     */
    protected CodeUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>[概 要] コード情報リストを取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return List コード情報リスト
     */
    public static Map<String, List<CodeMasterInfo>> getCdMap() {
        return cdMap;
    }

    /**
     * <p>[概 要] コード情報リストを取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param cdConstList コード情報リスト
     */
    public static void setCdMap(List<CodeMasterInfo> cdConstList) {
        cdMap = new HashMap<String, List<CodeMasterInfo>>();
        String codeGroup = null;
        List<CodeMasterInfo> innerList = null;

        // コード情報リストを繰り返して、同じコードテーブル種別のコード情報はサブリストを作成して、
        // コードテーブル種別をマップキーとして、マップに追加する。
        for (CodeMasterInfo cdConst : cdConstList) {
            if (cdConst.getCodeGroup().equals(codeGroup)) {
                innerList.add(cdConst);
            } else {
                if (null != codeGroup) {
                    cdMap.put(codeGroup, innerList);
                }
                codeGroup = cdConst.getCodeGroup();
                innerList = new ArrayList<CodeMasterInfo>();
                innerList.add(cdConst);
            }
        }
        cdMap.put(codeGroup, innerList);
    }

    /**
     * <p>[概 要] コード種別コードよりコード情報の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param codeGroup コードテーブル種別
     * @param codeClassCode コード種別コード
     * @return CodeMasterInfo コード情報
     */
    public static CodeMasterInfo getCdConstByCd(String codeGroup,
        String codeClassCode) {
        // コードテーブル種別より、メモリのコード情報マップから、コード情報リストを取得する。
        List<CodeMasterInfo> cdList = cdMap.get(StringUtil.trim(codeGroup));
        for (CodeMasterInfo cdConst : cdList) {
            // コード情報のコード種別コードとパラメータのコード種別コードを比較して、
            // 同じな場合、コード情報を戻り値として戻る。
            if (StringUtil.trim(codeClassCode).equals(
                cdConst.getCode())) {
                return cdConst;
            }
        }

        // コード情報取得できない場合、空オブジェクトを戻る。
        return new CodeMasterInfo();
    }

    /**
     * <p>[概 要] コード種別コードよりコード内容の取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param codeGroup コードテーブル種別
     * @param codeClassCode コード種別コード
     * @return String コード内容
     */
    public static String getNameByCd(String codeGroup, String codeClassCode) {
        // 非正常のパラメータの処理
        if (StringUtil.isEmpty(codeGroup)
            || StringUtil.isEmpty(codeClassCode)) {
            return StringUtil.BLANK;
        }
        // コードテーブル種別とコード種別コードより、コード情報のコード内容を取得する。
        return getCdConstByCd(codeGroup, codeClassCode).getCodeName();
    }

    /**
     * <p>[概 要] コード種別コードよりドロップダウンの内容取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param codeGroup コードテーブル種別
     * @param emptyValue 未選択コード
     * @return List コード情報リスト
     */
    public static List<CodeMasterInfo> getComBox(String codeGroup,
        String emptyValue) {
        // コードテーブル種別より、メモリのコード情報マップから、コード情報リストを作成する。
        List<CodeMasterInfo> cdList = cdMap.get(codeGroup);
        if (null == emptyValue) {
            // 未選択コードがnullの場合、取得したコード情報リストを戻り値として戻る。
            return cdList;

        } else {
            // 未選択コードがnullでない場合、仮コードレコードを作成する
            List<CodeMasterInfo> cdConstList = new ArrayList<CodeMasterInfo>();
            CodeMasterInfo emptyBean = new CodeMasterInfo();
            emptyBean.setCodeGroup(codeGroup);
            emptyBean.setCode(StringUtil.EMPTY);
            emptyBean.setCodeName(emptyValue);
            cdConstList.add(emptyBean);

            // コード情報リストの頭に追加して、コード情報リストを戻り値として戻る。
            cdConstList.addAll(cdList);
            return cdConstList;
        }
    }
}
