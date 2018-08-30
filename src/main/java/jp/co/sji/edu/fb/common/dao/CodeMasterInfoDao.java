package jp.co.sji.edu.fb.common.dao;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.CodeMasterInfo;


/**
 * <p>[概 要] CodeMasterInfoのDAOのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c).</p>
 * @author Edu.SJI
 */
public interface CodeMasterInfoDao {

    /**
     * <p>[概 要] CodeMasterInfo情報を登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param info CodeMasterInfo情報
     * @return CodeMasterInfo CodeMasterInfo情報
     */
    CodeMasterInfo insert(CodeMasterInfo info);

    /**
     * <p>[概 要] 全部のコード情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return List コード情報リスト
     */
    List<CodeMasterInfo> getAll();

}
