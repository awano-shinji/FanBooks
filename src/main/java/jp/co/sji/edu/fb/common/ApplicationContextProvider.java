package jp.co.sji.edu.fb.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>[概 要] 実行環境のSpring ApplicationContextインスタンスのアクセスクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class ApplicationContextProvider implements ApplicationContextAware {

    /**
     * コンテント
     */
    private static ApplicationContext ctx;


    /**
     * <p>[概 要] 実行環境のSpring ApplicationContextインスタンスを設定する。</p>
     * <p>[詳 細] ApplicationContextProviderを宣言するcontext.xmlを初期化する時、本メソッドを呼ぶ。</p>
     * <p>[備 考] </p>
     *
     * @param applicationContext コンテント
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }

    /**
     * <p>[概 要] 実行環境のSpring ApplicationContextインスタンスを取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return 実行環境のSpring ApplicationContextインスタンス
     */
    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
}
