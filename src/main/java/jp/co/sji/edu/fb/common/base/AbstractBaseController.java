package jp.co.sji.edu.fb.common.base;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import jp.co.sji.edu.fb.common.aspect.BpConvert;
import jp.co.sji.edu.fb.common.constant.Constants;

/**
 * <p>[概 要] ベースコントロール。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class AbstractBaseController {

    /**
     * <p>[概 要] データ型を処理する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param request リクエスト
     * @param binder 処理対象
     * @throws Exception 例外
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {
        binder.setAutoGrowCollectionLimit(Constants.AUTO_GROW_COLLECTIONLIMIT);
        binder.registerCustomEditor(Date.class, new BpConvert());
        binder.registerCustomEditor(Timestamp.class, new BpConvert());

    }
}
