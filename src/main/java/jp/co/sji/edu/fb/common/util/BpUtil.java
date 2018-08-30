package jp.co.sji.edu.fb.common.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.dto.RelateDto;

/**
 * <p>[概 要] 業務処理共通クラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class BpUtil {

    /**
     * ログ
     */
    private static Logger logger = LoggerFactory.getLogger(BpUtil.class);

    /**
     * 設定portBを選択した場合
     */
    public static final String PORT_B = "B";

    /**
     * 設定portCを選択した場合
     */
    public static final String PORT_C = "C";

    /**
     * <p>[概 要] コンストラクタ。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     */
    protected BpUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>[概 要] Excel情報の検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param data data処理
     * @param excelName excelNmae処理
     * @param response response処理
     */
    public static void fileDownlod(byte[] data, String excelName,
            HttpServletResponse response) {
        OutputStream outputStream = null;

        try {
            excelName = new String(excelName.getBytes(Constants.CHARSET_FILENAME_IN),
                    Constants.CHARSET_FILENAME_OUT);
            response.reset();
            response.setHeader("Content-Disposition", "attachment;" + "filename=\""
                    + excelName + "\"");
            response.addHeader("Content-Length", "" + data.length);
            response.setContentType("application/octet-stream;charset=UTF-8");
            outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(data);
            outputStream.flush();

        } catch (IOException e) {
            logger.debug("ファイルをダウンロードする時、クライアントでキャンセルしました");
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.debug("ファイルをダウンロードする時、クライアントでキャンセルしました");
                }
            }
        }
    }

    /**
     * <p>[概 要] ETAとETDドロップダウンリストの初期設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return List<RelateDto> ETAとETDリスト
     */
    public static List<RelateDto> getMonths() {
        // 現在の初期設定。
        Date today = DateUtil.getCurrentDate();
        List<RelateDto> months = new ArrayList<RelateDto>();
        for (int i = Constants.DATE_NTWELVE + 1; i <= 0; i++) {
            RelateDto month = new RelateDto();
            // yyyyMMの初期設定。
            month.setCode(DateUtil.formatDate(DateUtil.addMonths(today, i),
                    DateUtil.DATE_PATTERN_7));
            // yyyy/MMの初期設定。
            month.setCodeName(DateUtil.formatDate(DateUtil.addMonths(today, i),
                    DateUtil.DATE_PATTERN_8));
            months.add(month);
        }
        return months;
    }

}
