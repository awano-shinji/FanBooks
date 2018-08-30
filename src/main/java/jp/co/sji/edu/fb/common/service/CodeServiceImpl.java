package jp.co.sji.edu.fb.common.service;

import javax.annotation.PostConstruct;

import jp.co.sji.edu.fb.common.dao.CodeMasterInfoDao;
import jp.co.sji.edu.fb.common.util.CodeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>[概 要] 共通コード情報ロジッククラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Service("codeService")
class CodeServiceImpl implements CodeService {

    /**
     * <p>[概 要] コード情報を初期化する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     */
    @PostConstruct
    public void cacheCode() {
        if (null == CodeUtil.getCdMap()) {
            CodeUtil.setCdMap(codeMasterInfoDao.getAll());
        }
    }

    /**
     * コード情報DAO
     */
    @Autowired(required = true)
    private CodeMasterInfoDao codeMasterInfoDao;

}
