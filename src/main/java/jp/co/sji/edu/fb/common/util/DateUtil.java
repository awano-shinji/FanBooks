package jp.co.sji.edu.fb.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import jp.co.sji.edu.fb.common.constant.Constants;

/**
 * <p>[概 要] 日付処理共通クラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class DateUtil {

    /** パターン(yyyyMMdd) */
    public static final String DATE_PATTERN_0 = "yyyyMMdd";

    /** パターン(yyyy/MM/dd) */
    public static final String DATE_PATTERN_1 = "yyyy/MM/dd";

    /** パターン(MM/dd/yyyy) */
    public static final String DATE_PATTERN_2 = "MM/dd/yyyy";

    /** パターン(MM/dd/yyyy) */
    public static final String DATE_PATTERN_3 = "MM/dd";

    /** パターン(MM/dd/yyyy) */
    public static final String DATE_PATTERN_4 = "yyyy";

    /** パターン(dd/MMM/yyyy) */
    public static final String DATE_PATTERN_5 = "dd/MMM/yyyy";

    /** パターン(MMMM dd,yyyy) */
    public static final String DATE_PATTERN_6 = "MMMM dd, yyyy";

    /** パターン(yyyyMM) */
    public static final String DATE_PATTERN_7 = "yyyyMM";

    /** パターン(yyyy/MM) */
    public static final String DATE_PATTERN_8 = "yyyy/MM";

    /** パターン(yyyy-MM-dd HH:mm:ss.SSS) */
    public static final String DB_TIME_PATTERN_1 = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * <p>[概 要] コンストラクタ。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     */
    protected DateUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * YYYY/MM/ddの文字列から日付(Timestamp)をフォーマットする
     *
     * @param date
     *            日付
     * @return Timestamp
     */
    public static Timestamp getTimestamp(String date) {
        if (!StringUtil.isEmpty(date)) {
            return new Timestamp(toDate(date, DB_TIME_PATTERN_1).getTime());
        } else {
            return null;
        }
    }

    /**
     * <p>[概 要] 指定されたフォーマットによって、システム日付取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @return Date 日付
     */
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    /**
     * <p>[概 要] 指定されたフォーマットによって、システム日付取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param format フォーマット
     * @return String 日付
     */
    public static String getCurrentDate(String format) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdFromat = new SimpleDateFormat(format);
        return sdFromat.format(date);
    }

    /**
     * <p>[概 要] 指定されたフォーマットによって、日付をフォーマットする。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param date 日付
     * @param format フォーマット
     * @return String 日付
     */
    public static String formatDate(Date date, String format) {
        if (null == date) {
            return StringUtil.BLANK;
        }
        SimpleDateFormat sdFromat = new SimpleDateFormat(format);
        return sdFromat.format(date);
    }

    /**
     * <p>[概 要] 指定されたフォーマットによって、日付をフォーマットする。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param date 日付
     * @param format フォーマット
     * @return String 日付
     */
    public static String formatDateWest(Date date, String format) {
        if (null == date) {
            return StringUtil.BLANK;
        }
        SimpleDateFormat sdFromat = new SimpleDateFormat(format, Locale.ENGLISH);
        return sdFromat.format(date);
    }

    /**
     * <p>[概 要] 指定されたフォーマットによって、日付をフォーマットする。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param date 日付
     * @param fmtFrom フォーマット
     * @param fmtTo フォーマット
     * @return String 日付
     */
    public static String formatDate(String date, String fmtFrom, String fmtTo) {
        if (StringUtil.isEmpty(date)) {
            return StringUtil.BLANK;
        }
        return formatDate(toDate(date, fmtFrom), fmtTo);
    }

    /**
     * <p>[概 要] 入力したストリングは入力フォーマットに着替える。</p>
     * <p>[詳 細]
     * 入力できるフォーマット: <br>
     * &quot;yyyyMMdd&quot; <br>
     * &quot;yyyy/MM/dd HH:mm:ss.SSS&quot; <br>
     * その他フォーマットはjava.text.SimpleDateFormatを参照してください。 <br>
     * 使用例： <br>
     * DateUtil.toDate( &quot;20030918&quot;, &quot;yyyyMMdd&quot;)の結果は 20030918
     * 00:00:00.000 DateUtil.toDate(&quot;20030918&quot;,
     * &quot;yyyy/MM/dd&quot;)の結果は ParseException
     * DateUtil.toDate(&quot;17000101&quot;, &quot;yyyyMMdd&quot;)の結果は 1700
     * 00:00:00.000 </p>
     * <p>[備 考] </p>
     *
     * @param sDate
     *            入力したストリング(NULL禁止)
     * @param sFmt
     *            入力したフォーマット(NULL禁止)
     * @return Date 着替える日付
     * @see java.text.SimpleDateFormat
     */
    public static Date toDate(String sDate, String sFmt) {
        Date dt = null;
        try {
            dt = new SimpleDateFormat(sFmt).parse(sDate);
        } catch (ParseException e) {
            return dt;
        }
        return dt;
    }

    /**
     * <p>[概 要] 日付編集。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param date 日付
     * @return String 日付(編集後)
     */
    public static String fmtDateYYYYMMDD(String date) {
        return DateUtil.formatDate(date, DateUtil.DATE_PATTERN_0,
            DateUtil.DATE_PATTERN_2);

    }

    /**
     * <p>[概 要] DB処理用日付編集。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param date 日付
     * @return String 日付(編集後)
     */
    public static String fmtSqlDate(String date) {
        return DateUtil.formatDate(date, DateUtil.DATE_PATTERN_2,
            DateUtil.DATE_PATTERN_0);
    }

    /**
     * <p>[概 要] 基準日付±n日の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param kijunYmd 指定日付
     * @param format 日付フォーマット
     * @param biasVal 増減日数
     * @return 日付増減後の結果
     */
    public static String addDays(String kijunYmd, String format, int biasVal) {
        if (StringUtil.isEmpty(kijunYmd)) {
            return StringUtil.BLANK;
        }
        Date inDate = toDate(kijunYmd, format);

        Date date = null;
        if (inDate != null) {
            // calendarの初期化
            Calendar calendar = Calendar.getInstance();
            // calendarのtimeを設定する。
            calendar.setTime(inDate);
            // 最終年月日の計算
            calendar.add(Calendar.DAY_OF_MONTH, biasVal);
            // 最終年月日を設定する。
            date = calendar.getTime();
        }
        return formatDate(date, format);
    }


    /**
     * <p>[概 要] 基準日付±n月の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param format 日付フォーマット
     * @param biasVal 増減日数
     * @return 日付増減後の結果
     */
    public static String addMonths(String format, int biasVal) {
        Calendar cal = Calendar.getInstance();
        Date inDate = cal.getTime();

        Date date = null;
        if (inDate != null) {
            // calendarの初期化
            Calendar calendar = Calendar.getInstance();
            // calendarのtimeを設定する。
            calendar.setTime(inDate);
            // 最終年月日の計算
            calendar.add(Calendar.MONTH, biasVal);
            // 最終年月日を設定する。
            date = calendar.getTime();
        }
        return formatDate(date, format);
    }

    /**
     * <p>[概 要] 基準日付±n月の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param inDate 指定日付
     * @param biasVal 増減日数
     * @return 日付増減後の結果
     */
    public static Date addMonths(Date inDate, int biasVal) {
        Date date = null;
        if (inDate != null) {
            // calendarの初期化
            Calendar calendar = Calendar.getInstance();
            // calendarのtimeを設定する。
            calendar.setTime(inDate);
            // 最終年月日の計算
            calendar.add(Calendar.MONTH, biasVal);
            // 最終年月日を設定する。
            date = calendar.getTime();
        }
        return date;
    }

    /**
     * <p>[概 要] 基準日付±n月の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param inDate 指定日付
     * @param format 日付フォーマット
     * @param biasVal 増減日数
     * @return 日付増減後の結果
     */
    public static String addMonths(Date inDate, String format, int biasVal) {
        Date date = null;
        if (inDate != null) {
            // calendarの初期化
            Calendar calendar = Calendar.getInstance();
            // calendarのtimeを設定する。
            calendar.setTime(inDate);
            // 最終年月日の計算
            calendar.add(Calendar.MONTH, biasVal);
            // 最終年月日を設定する。
            date = calendar.getTime();
        }
        return formatDate(date, format);
    }

    /**
     * <p>[概 要] 基準日付±n年の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param kijunYmd 指定日付
     * @param format 日付フォーマット
     * @param biasVal 増減年数
     * @return 日付増減後の結果
     */
    public static String addYears(String kijunYmd, String format, int biasVal) {
        if (StringUtil.isEmpty(kijunYmd)) {
            return StringUtil.BLANK;
        }
        Date inDate = toDate(kijunYmd, format);

        Date date = null;
        if (inDate != null) {
            // calendarの初期化
            Calendar calendar = Calendar.getInstance();
            // calendarのtimeを設定する。
            calendar.setTime(inDate);
            // 最終年月日の計算
            calendar.add(Calendar.YEAR, biasVal);
            // 最終年月日を設定する。
            date = calendar.getTime();
        }
        return formatDate(date, format);
    }

    /**
     * <p>[概 要] 二つ時間の間に、天数を取得する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param from 開始時間
     * @param to 終了時間
     * @return 天数
     */
    public static long getDateCntBetweenTwoDay(Date from, Date to) {
        // パラメータチャック
        if (from == null || to == null) {
            return 0;
        }
        long lfrom = DateUtil.toDate(
                DateUtil.formatDate(from, DateUtil.DATE_PATTERN_0),
                DateUtil.DATE_PATTERN_0).getTime();
        long lto = DateUtil.toDate(
                DateUtil.formatDate(to, DateUtil.DATE_PATTERN_0),
                DateUtil.DATE_PATTERN_0).getTime();

        long inter = lto - lfrom;

        long dateMillSec = Constants.DATE_COUNT;

        long dateCnt = inter / dateMillSec;

        long remainder = inter % dateMillSec;

        if (remainder != 0) {
            dateCnt++;
        }

        return dateCnt;
    }

    /**
     * <p>[概 要] 基準日付±n分以内の判定処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param compDate 対象日付
     * @param biasVal 増減分数
     * @return True：n分以内/False:n分以外
     */
    public static boolean inMinutes(Date compDate, int biasVal) {
        Calendar cal = Calendar.getInstance();
        Date inDate = cal.getTime();

        Date date = null;
        if (inDate != null) {
            // calendarの初期化
            Calendar calendar = Calendar.getInstance();
            // calendarのtimeを設定する。
            calendar.setTime(inDate);
            // 最終年月日の計算
            calendar.add(Calendar.MINUTE, 0 - biasVal);
            // 最終年月日を設定する。
            date = calendar.getTime();
        }
        return formatDate(date, DB_TIME_PATTERN_1).compareTo(
        		formatDate(compDate, DB_TIME_PATTERN_1)) < 0;
    }

}
