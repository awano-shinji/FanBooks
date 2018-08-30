package jp.co.sji.edu.fb.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>[概 要] Log AOPのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c).</p>
 * @author Edu.SJI
 */
@Aspect
public class LogAspect {

    /**
     * ログ
     */
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * <p>[概 要] ログ出力処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param jp ProceedingJoinPoint
     * @return Object Object
     * @throws Throwable 例外
     */
    @Around("execution(* jp.co.sji.edu.fb.service.*.*(..))")
    public Object outputLog(ProceedingJoinPoint jp) throws Throwable {
        // メソッド実行前、ログを出力する。
        logger.info("Starting execution "
                + jp.getSignature().getDeclaringTypeName() + "."
                + jp.getSignature().getName());
//        logger.debug("input param:");
//        for (Object obj : jp.getArgs()) {
//            // ファイルダウンロードとアップロード対応
//            if (!(obj instanceof byte[])) {
//                logger.debug(ToStringBuilder.reflectionToString(obj));
//            }
//        }

        // メソッドを実行する。
        Object rvt = jp.proceed();

        // メソッド実行した後で、ログを出力する。
        logger.info("Finishing execution "
                + jp.getSignature().getDeclaringTypeName() + "."
                + jp.getSignature().getName());
//        logger.debug("Return Output:");
//        // ファイルダウンロードとアップロード対応
//        if (!(rvt instanceof byte[]) && !(rvt instanceof FormatInfo)) {
//            logger.debug(ToStringBuilder.reflectionToString(rvt));
//        }
        return rvt;
    }
}
