package jp.co.sji.edu.fb.common.util;

import java.util.Properties;

import jp.co.sji.edu.fb.common.ApplicationContextProvider;
import jp.co.sji.edu.fb.common.constant.Constants;


/**
 * <p>[概 要] 設定ファイルの内容取得のユーティリティクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public final class PropertiesUtil {

    /**
     * 構造関数
     */
    private PropertiesUtil() {
    }

    /**
     * <p>[概 要] 設定Propertiesファイルの内容を取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param key 設定キー
     * @return 設定キーの値
     */
    public static String getProperty(String key) {
        return ApplicationContextProvider.getApplicationContext()
                .getBean(Constants.CONFIG_BASENAME, Properties.class)
                .getProperty(key);
    }

    /**
     * <p>[概 要] 設定Propertiesファイルの内容を取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param key 設定キー
     * @param defaultValue デフォールト値
     * @return 設定キーの値
     */
    public static String getProperty(String key, String defaultValue) {
        return ApplicationContextProvider.getApplicationContext()
                .getBean(Constants.CONFIG_BASENAME, Properties.class)
                .getProperty(key, defaultValue);
    }

    /**
     * <p>[概 要] 設定Propertiesファイルの内容を取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param key 設定キー
     * @return 設定キーの値
     */
    public static int getIntegerProperty(String key) {
        String value = getProperty(key);
        return Integer.parseInt(value);
    }

    /**
     * <p>[概 要] 設定Propertiesファイルの内容を取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param key 設定キー
     * @param defaultValue デフォールト値
     * @return 設定キーの値
     */
    public static int getIntegerProperty(String key, int defaultValue) {
        String value = getProperty(key);

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}

