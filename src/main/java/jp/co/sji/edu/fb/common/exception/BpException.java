package jp.co.sji.edu.fb.common.exception;

import java.util.Arrays;
import java.util.List;

/**
 * <p>[概 要] 基本アプリケーションエラー。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class BpException extends RuntimeException {

    /**
     * 直列化ID
     */
    private static final long serialVersionUID = 1207481718407989213L;

    /**
     * メッセージID
     */
    private String message;

    /**
     * メッセージパラメータ
     */
    private List<Object> param;

    /**
     * <p>[概 要] メッセージIDを取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String メッセージID
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * <p>[概 要] メッセージIDを設定する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param message エラーメッセージ
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * <p>[概 要] メッセージパラメータを取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return List メッセージパラメータ
     */
    public List<Object> getParam() {
        return param;
    }

    /**
     * <p>[概 要] メッセージパラメータを設定する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param param メッセージパラメータ
     */
    public void setParam(List<Object> param) {
        this.param = param;
    }

    /**
     * <p>[概 要] コンストラクター。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param message エラーメッセージ
     */
    public BpException(final String message) {
        super(message, null);
        setMessage(message);
    }

    /**
     * <p>[概 要] コンストラクター。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param message エラーメッセージ
     * @param param パラメータ
     */
    public BpException(final String message, Object... param) {
        super(message, null);
        setMessage(message);
        setParam(Arrays.asList(param));
    }

    /**
     * <p>[概 要] コンストラクター。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     */
    public BpException() {
        super();
    }

    /**
     * <p>[概 要] コンストラクター。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param throwable エラー
     */
    public BpException(final Throwable throwable) {
        super(throwable);
    }

    /**
     * <p>[概 要] コンストラクター。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param message エラーメッセージ
     * @param throwable エラー
     */
    public BpException(final String message, final Throwable throwable) {
        super(message, throwable);
        setMessage(message);
    }
}
