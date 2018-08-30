package jp.co.sji.edu.fb.common.aspect;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.util.Date;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.util.DateUtil;




/**
 * <p>[概 要] 文字列処理共通クラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * @author SJI
 */
public class BpConvert extends PropertyEditorSupport {
    /**
     * <p>[概 要] 文字列を転換する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param text データ
     */
    @Override
    public void setAsText(String text) {
        if (text == null || text.equals("")) {
            setValue(null);
        } else {
            if (text.length() > Constants.DATE_LEN) {
                super.setValue(DateUtil.getTimestamp(text));
            } else {
                super.setValue(text);
            }

        }
    }

    /**
     * <p>[概 要] 文字列を転換する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return データ
     */
    @Override
    public String getAsText() {
        if (null == super.getAsText() || "null".equals(super.getAsText())) {
            return "";
        } else {
            if (super.getValue() instanceof Date) {
                if (super.getValue() instanceof Timestamp) {
                    return DateUtil.formatDate((Date) super.getValue(),
                            DateUtil.DB_TIME_PATTERN_1);
                } else {
                    return DateUtil.formatDate((Date) super.getValue(),
                            DateUtil.DATE_PATTERN_2);
                }
            } else {
                return super.getAsText();
            }
        }
    }

}
