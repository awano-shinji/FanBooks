package jp.co.sji.edu.fb.common.dao;

import java.util.List;

import jp.co.sji.edu.fb.common.dto.CodeMasterInfo;

import org.springframework.stereotype.Repository;

/**
 * <p>[概 要] CodeMasterInfoのDAOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c).</p>
 * @author Edu.SJI
 */
@Repository ("codeMasterInfoDao")
public class CodeMasterInfoDaoImpl extends BaseDao implements CodeMasterInfoDao  {
    /**
     * <p>[概 要] CodeMasterInfo情報を登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param info CodeMasterInfo情報
     * @return CodeMasterInfo CodeMasterInfo情報
     */
    public CodeMasterInfo insert(CodeMasterInfo info) {
        return (CodeMasterInfo) insert("codeMasterInfo.insert", info);
    }

    /**
     * <p>[概 要] 全部のコード情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return List コード情報リスト
     */
    public List<CodeMasterInfo> getAll() {
        return (List<CodeMasterInfo>) queryForList("codeMasterInfo.selectAll");
    }
}
