package jp.co.sji.edu.fb.common.util;

import jp.co.sji.edu.fb.common.ApplicationContextProvider;

import org.springframework.context.MessageSource;

/**
 * <p>[概 要] メッセージの内容取得のユーティリティクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public final class MessageUtil {

    /**
     * メッセージリソース
     */
    private static MessageSource msgs = ApplicationContextProvider
            .getApplicationContext().getBean(
            "messageSource", MessageSource.class);

    /**
     * 構造関数
     */
    private MessageUtil() {
        // avoid create instance
    }

    /**
     * メッセージIDとパラメータによりメッセージプロパティに定義されたメッセージ内容を組立て返す。
     *
     * @param messageId
     *            メッセージID
     * @return フォーマットしたメッセージ内容
     */
    public static String getMessage(String messageId) {
        return getMessage(messageId, null);
    }

    /**
     * メッセージIDとパラメータによりメッセージプロパティに定義されたメッセージ内容を組立て返す。
     *
     * @param messageId
     *            メッセージID
     * @param args
     *            メッセージパラメータ
     * @return フォーマットしたメッセージ内容
     */
    public static String getMessage(String messageId, String... args) {
        return msgs.getMessage(messageId, args, "メッセージ" + messageId
                + "の定義が見つかれません。", null);
    }
}
