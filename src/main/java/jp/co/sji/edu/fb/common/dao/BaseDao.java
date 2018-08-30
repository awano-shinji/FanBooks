package jp.co.sji.edu.fb.common.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;

import jp.co.sji.edu.fb.common.util.StringUtil;

/**
 * <p>[概 要] DAOの共通処理。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c).</p>
 * @author Edu.SJI
 */
public class BaseDao extends SqlMapClientDaoSupport {

    /**
     * sqlMapClient
     */
    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;

    /**
     * <p>[概 要] iBatisを初期化する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     */
    @PostConstruct
    public void initSqlMapClient() {
        super.setSqlMapClient(sqlMapClient);
    }

    /**
     * <p>[概 要] レコードを登録する(バッチモード)。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param list パラメータ
     */
    public void batchInsert(final String statementName, final List list) {
        if (list != null) {
            getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {
                    executor.startBatch();
                    for (int i = 0, n = list.size(); i < n; i++) {
                        executor.insert(statementName, list.get(i));
                    }
                    executor.executeBatch();
                    return null;
                }
            });
        }
    }

    /**
     * <p>[概 要] レコードを更新する（排他無し）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param parameterObject パラメータ
     * @return int 更新件数
     */
    public int update(String statementName, Object parameterObject) {
        return getSqlMapClientTemplate().update(statementName, parameterObject);
    }

    /**
     * <p>[概 要] レコードを削除する（排他無し）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param parameterObject パラメータ
     * @return int 削除件数
     */
    public int delete(String statementName, Object parameterObject) {
        return getSqlMapClientTemplate().delete(statementName, parameterObject);
    }

    /**
     * <p>[概 要] レコードを登録する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param parameterObject パラメータ
     * @return Object 登録レコード
     */
    public Object insert(String statementName, Object parameterObject) {
        return getSqlMapClientTemplate().insert(statementName, parameterObject);
    }

    /**
     * <p>[概 要] レコードを検索する（一件）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param parameterObject パラメータ
     * @return Object 検索結果レコード
     */
    public Object queryForObject(String statementName, Object parameterObject) {
        List<Object> resultList =
            (List<Object>) queryForList(statementName, parameterObject);
        if (0 < resultList.size()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    /**
     * <p>[概 要] 文字列を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param parameterObject パラメータ
     * @return Object 検索結果レコード
     */
    public String queryForString(String statementName, Object parameterObject) {
        List<Object> resultList =
            (List<Object>) queryForList(statementName, parameterObject);
        if (0 < resultList.size()) {
            return StringUtil.nvl((String) resultList.get(0));
        } else {
            return null;
        }
    }

    /**
     * <p>[概 要] レコードを検索する（一件）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @return Object 検索結果レコード
     */
    public Object queryForObject(String statementName) {
        List<Object> resultList = (List<Object>) queryForList(statementName);
        if (0 < resultList.size()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    /**
     * <p>[概 要] レコードを検索する（複数件）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param parameterObject パラメータ
     * @return List 検索結果レコードリスト
     */

    public List<?> queryForList(String statementName, Object parameterObject) {
        return getSqlMapClientTemplate().queryForList(statementName,
            parameterObject);
    }

    /**
     * <p>[概 要] レコードを検索する（複数件）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @return List 検索結果レコードリスト
     */
    public List<?> queryForList(String statementName) {
        return getSqlMapClientTemplate().queryForList(statementName);
    }

    /**
     * <p>[概 要] レコードを検索する（指定件数）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param parameterObject パラメータ
     * @param skipResults 開始件数
     * @param maxResults 終了件数
     * @return List 検索結果レコードリスト
     */
    public List<?> queryForList(String statementName, Object parameterObject,
        int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList(statementName,
            parameterObject, skipResults, maxResults);
    }

    /**
     * <p>[概 要] レコードを検索する（指定件数）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param skipResults 開始件数
     * @param maxResults 終了件数
     * @return List 検索結果レコードリスト
     */
    public List<?> queryForList(String statementName, int skipResults,
        int maxResults) {
        return getSqlMapClientTemplate().queryForList(statementName,
            skipResults, maxResults);
    }

    /**
     * <p>[概 要] レコードを検索する（MAP）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param parameterObject パラメータ
     * @param keyProperty マップキー
     * @return Map 検索結果マップ
     */
    public Map<?, ?> queryForMap(String statementName, Object parameterObject,
        String keyProperty) {
        return getSqlMapClientTemplate().queryForMap(statementName,
            parameterObject, keyProperty);
    }

    /**
     * <p>[概 要] レコードを検索する（MAP）。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param statementName ステートメント名
     * @param parameterObject パラメータ
     * @param keyProperty マップキー
     * @param valueProperty マップ値
     * @return Map 検索結果マップ
     */
    public Map<?, ?> queryForMap(String statementName, Object parameterObject,
        String keyProperty, String valueProperty) {
        return getSqlMapClientTemplate().queryForMap(statementName,
            parameterObject, keyProperty, valueProperty);
    }

}
