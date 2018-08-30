package jp.co.sji.edu.fb.common.util;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import com.mysql.jdbc.Blob;

import jp.co.sji.edu.fb.common.constant.Constants;

/**
 * <p>[概 要] 文字列処理共通クラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class StringUtil extends StringUtils {

	/**
	 * 日付
	 */
	public static final String DATE_SEP = "/";

	/**
	 * 半角スペース
	 */
	public static final String HALF_SPACE = " ";

	/**
	 * 右括弧(半角)
	 */
	public static final String RIGHT_KATU = ")";

	/**
	 * 左括弧(半角)
	 */
	public static final String LEFT_KATU = "(";

	/**
	 * 半角："-"
	 */
	public static final String LINE = "-";

	/**
	 * 半角コンマ
	 */
	public static final String COMMA = ",";

	/**
	 * 半角コンマ
	 */
	public static final String MAIL_SEP = ";";

	/**
	 * 半角コンマ
	 */
	public static final String SINGLE_QUOTATION_MARK = "'";

	/**
	 * UNDERLINE
	 */
	public static final String UNDERLINE = "_";

	/**
	 * コロン
	 */
	public static final String KORON = ":";

	/**
	 * BLANK:""
	 */
	public static final String BLANK = "";

	/**
	 * JSPの改行
	 */
	public static final String LINE_BR = "<BR>";

	/**
	 * 改行コード
	 */
	public static final String LINE_SEPARATOR = "\r\n";

	/**
	* 改行コード
	*/
	public static final String LINE_SEPARATOR_JSP = "<br>";

	/**
	 * ファイルセパレーター
	 */
	public static final String FILE_SEPARATOR = System
			.getProperty("file.separator");

	/**
	 * ゼロ
	 */
	public static final String ZERO = "0";

	/**
	 * チェックボックス:true:チェックオン
	 */
	public static final String CHECK_ON = "true";

	/**
	 * チェックボックス:false:チェックオフ
	 */
	public static final String CHECK_OFF = "false";

	/**
	 * チェックボックスの登録値:0
	 */
	public static final String CHECK_DB_VALUE_0 = "0";

	/**
	 * チェックボックスの登録値:1
	 */
	public static final String CHECK_DB_VALUE_1 = "1";

	/**
	 * チェックボックスの登録値:2
	 */
	public static final String CHECK_DB_VALUE_2 = "2";

	/**
	 * ポイント："."
	 */
	public static final String POINT = ".";

	/**
	 * 異常のTrace行数
	 */
	public static final int EXCEPTIONMAXLINE = Integer.MAX_VALUE;

	/**
	 * 文字コード：MS932
	 */
	public static final String CHARSET = "MS" + "932";

	/**
	 * <p>[概 要] 日付編集。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param date 日付
	 * @return String 日付(編集後)
	 */
	public static String fmtDate(String date) {
		if (isNotEmpty(trim(date))) {
			return DateUtil.fmtDateYYYYMMDD(date);
		} else {
			return LINE;
		}
	}

	/**
	 * <p>[概 要] 日付編集。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param date 日付
	 * @return String 日付(編集後)
	 */
	public static String fmtDateForDisplay(Date date) {
		if (null != date) {
			return DateUtil.formatDate(date, DateUtil.DATE_PATTERN_3)
					.concat(DATE_SEP).concat(LINE_SEPARATOR_JSP)
					.concat(DateUtil.formatDate(date, DateUtil.DATE_PATTERN_4));
		} else {
			return LINE;
		}
	}

	/**
	 * <p>[概 要] Null値変換（スペース）</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param data データ
	 * @return String データ(編集後)
	 */
	public static String nvl(String data) {
		if (data == null) {
			return BLANK;
		} else {
			return data;
		}
	}

	/**
	 * <p>[概 要] 前後ダブルコーテーション削除。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param data データ
	 * @return String データ(編集後)
	 */
	public static String trimQuart(String data) {
		if (isEmpty(data)) {
			return BLANK;
		}
		String str = data.substring(1, data.length() - 1);

		return str;
	}

	/**
	 * <p>[概 要] 文字列を連接する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param list 連接文字列リスト
	 * @param concatKey 連接子
	 * @return String データ(編集後)
	 */
	public static String strConcat(List<String> list, String concatKey) {
		String data = StringUtil.BLANK;
		if (null == list) {
			return data;
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (0 == i) {
					data = data.concat(trim(list.get(i)));
				} else {
					data = data.concat(concatKey + list.get(i));
				}
			}
			return data;
		}
	}

	/**
	 * <p>[概 要] TeamNameとPICを連接する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param teamName TeamName
	 * @param pic PIC
	 * @return String データ(編集後)
	 */
	public static String fmtTeamPIC(String teamName, String pic) {
		String data = StringUtil.escapeHtml(teamName);
		if (isEmpty(teamName)) {
			return pic;
		}
		if (!isEmpty(pic)) {
			data = data.concat(LINE);
			data = data.concat(StringUtil.escapeHtml(pic));
		}
		data = data.replaceAll(LINE, LINE + LINE_SEPARATOR_JSP);
		data = data.replaceAll(DATE_SEP, DATE_SEP + LINE_SEPARATOR_JSP);
		return data;
	}

	/**
	 * <p>[概 要] portNameとportを連接する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param portName portName
	 * @param port port
	 * @return String データ(編集後)
	 */
	public static String fmtPort(String portName, String port) {
		if (StringUtil.isEmpty(portName) || StringUtil.isEmpty(port)) {
			return null;
		} else {
			String data = StringUtil.nvl(StringUtil.escapeHtml(portName));
			data = data.concat(DATE_SEP);
			data = data.concat(StringUtil.nvl(StringUtil.escapeHtml(port)));
			data = data.replaceAll(DATE_SEP, DATE_SEP + LINE_SEPARATOR_JSP);
			return data;
		}
	}

	/**
	 * <p>[概 要] FuelGradetを連接する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param fuelGrade fuelGrade
	 * @param quantity quantity
	 * @param unitFlagA unitFlagA
	 * @return String データ(編集後)
	 */
	public static String fmtFuelGrade(String fuelGrade, String quantity,
			String unitFlagA) {
		if ("-".equals(fuelGrade) || StringUtil.isEmpty(StringUtil.trim(fuelGrade))) {
			return null;
		} else {
			String data = StringUtil.nvl(fuelGrade);
			data = data.concat(HALF_SPACE);
			data = data.concat(LEFT_KATU);
			data = data.concat(StringUtil.nvl(quantity));
			data = data.concat(HALF_SPACE);
			data = data.concat(StringUtil.nvl(CodeUtil.getNameByCd(
					Constants.CD_GROUP_UNIT, unitFlagA)));
			data = data.concat(RIGHT_KATU);
			return data;
		}
	}

	/**
	 * <p>[概 要] DeliveredQuantityAを連接する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param fuelGrade fuelGrade
	 * @param quantity quantity
	 * @param unitFlagA unitFlagA
	 * @return String データ(編集後)
	 */
	public static String fmtDelivery(String fuelGrade, String quantity,
			String unitFlagA) {
		if ("-".equals(fuelGrade)
				|| StringUtil.isEmpty(StringUtil.trim(fuelGrade))
				|| "-".equals(quantity)
				|| StringUtil.isEmpty(StringUtil.trim(quantity))) {
			return null;
		} else {
			String data = StringUtil.nvl(fuelGrade);
			data = data.concat(HALF_SPACE);
			data = data.concat(LEFT_KATU);
			data = data.concat(StringUtil.nvl(quantity));
			data = data.concat(HALF_SPACE);
			data = data.concat(StringUtil.nvl(CodeUtil.getNameByCd(
					Constants.CD_GROUP_UNIT, unitFlagA)));
			data = data.concat(RIGHT_KATU);
			return data;
		}
	}

	/**
	 * <p>[概 要] FuelGradetを連接する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param fuelGrade fuelGrade
	 * @param quantity quantity
	 * @param unitFlagA unitFlagA
	 * @return String データ(編集後)
	 */
	public static String fmtHistoryFuelGrade(String fuelGrade, String quantity,
			String unitFlagA) {
		if ("-".equals(fuelGrade) || StringUtil.isEmpty(StringUtil.trim(fuelGrade))) {
			return null;
		} else {
			String data = StringUtil.nvl(fuelGrade);
			data = data.concat(HALF_SPACE);
			data = data.concat(LEFT_KATU);
			data = data.concat(StringUtil.nvl(quantity));
			data = data.concat(HALF_SPACE);
			data = data.concat(StringUtil.nvl(unitFlagA));
			data = data.concat(RIGHT_KATU);
			return data;
		}
	}

	/**
	 * <p>[概 要] ExcelとportNameとportを連接する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param portName portName
	 * @param port port
	 * @return String データ(編集後)
	 */
	public static String fmtExcelPort(String portName, String port) {
		if (StringUtil.isEmpty(portName) || StringUtil.isEmpty(port)) {
			return null;
		} else {
			String data = StringUtil.nvl(portName);
			data = data.concat(DATE_SEP);
			data = data.concat(StringUtil.nvl(port));
			data = data.replaceAll(DATE_SEP, DATE_SEP);
			return data;

		}
	}

	/**
	 * <p>[概 要] 乱数を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param pwdLen 乱数個数
	 * @return String 乱数
	 */
	public static String genRandomNum(int pwdLen) {
		final int maxNum = 60;
		int i;
		int count = 0;
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwdLen) {

			i = Math.abs(r.nextInt(maxNum));

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}

		return pwd.toString();
	}

	/**
	 * <p>[概 要] 異常のログ情報を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param t 異常オブジェクト
	 * @return 異常のログ情報
	 */
	public static String getThrowableInfo(Throwable t) {
		StringBuffer sb = new StringBuffer();

		if (t == null) {
			return "";
		}
		Throwable t2 = t;
		if (t instanceof RemoteException) {
			t2 = getDetailOfRemoteEx((RemoteException) t);
		}
		sb.append(t.getLocalizedMessage());
		sb.append(StringUtil.LINE_SEPARATOR);
		sb.append('[');
		sb.append(t2.getClass().getName());
		sb.append(' ');
		if (t2 instanceof SQLException) {
			sb.append(((SQLException) t2).getErrorCode());
			sb.append(' ');
			sb.append(((SQLException) t2).getMessage());
			sb.append(' ');
		}
		sb.append(StringUtil.LINE_SEPARATOR);

		StackTraceElement[] stes = null;
		Throwable ttmp = t;
		int count = 0;
		String throwname = null;
		String msg = null;
		StringBuffer causesb = new StringBuffer();
		causesb.append(StringUtil.LINE_SEPARATOR);
		while (null != ttmp) {
			stes = ttmp.getStackTrace();
			throwname = ttmp.getClass().getName();
			msg = ttmp.getLocalizedMessage();
			if (null == msg) {
				msg = ttmp.getMessage();
			}

			if (0 != count && null != msg && !"".equals(msg)) {
				causesb.append("Caused By: " + throwname + ": " + msg);
				causesb.append(StringUtil.LINE_SEPARATOR);
			} else if (1 <= count) {
				causesb.append("Caused By: " + throwname);
				causesb.append(StringUtil.LINE_SEPARATOR);
			}

			for (int i = 0; i < stes.length; i++) {
				count++;
				sb.append(" at ");
				sb.append(stes[i].toString());
				sb.append(StringUtil.LINE_SEPARATOR);
			}

			ttmp = ttmp.getCause();
		}

		sb.append(']');

		return causesb.append(sb).toString();
	}

	/**
	 * <p>[概 要] リモート異常の詳細を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param re リモート異常
	 * @return 異常の具体インスタンス
	 */
	private static Throwable getDetailOfRemoteEx(RemoteException re) {
		Throwable ret = null;
		ret = re.detail;
		while (ret instanceof RemoteException) {
			ret = ((RemoteException) ret).detail;
		}
		return ret;
	}

	/**
	 * <p>[概 要] HTMLを転換する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param content 転換待ち文字
	 * @return String 転換した文字
	 */
	public static String escapeHtml(String content) {
		if (content == null) {
			return null;
		}
		String html = StringEscapeUtils.escapeHtml(content);
		//        html = StringUtils.replace(html, "'", "&apos;");
		return html;
	}

	/**
	 * <p>[概 要] SQL文を転換する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param content 転換待ち文字
	 * @return String 転換した文字
	 */
	public static String escapeSql(String content) {
		if (content == null) {
			return null;
		}
		String sql = StringEscapeUtils.escapeSql(content);
		sql = sql.replace("%", "/%");
		sql = sql.replace("/", "//");
		sql = sql.replace("_", "/_");
		return sql;
	}

	/**
	 * <p>[概 要] HTMLを転換する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param content 転換待ち文字
	 * @return String 転換した文字
	 */
	public static String escapeHtmlForMail(String content) {
		if (content == null) {
			return null;
		}
		String html = StringEscapeUtils.escapeHtml(content);
		return html;
	}

	/**
	 * <p>[概 要] HTMLを転換する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 *
	 * @param content 転換待ち文字
	 * @return String 転換した文字
	 */
	public static String unEscapeHtmlForMail(String content) {
		if (content == null) {
			return null;
		}
		String html = StringEscapeUtils.unescapeHtml(content);
		html.replaceAll(
				Constants.HTML_NEW_LINE, Constants.TXT_NEW_LINE);
		return html;
	}

	public static Blob escapeHtml(java.sql.Blob bookCover) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
