package jp.co.sji.edu.fb.common.constant;

import java.util.HashMap;
import java.util.Map;

import jp.co.sji.edu.fb.common.util.PropertiesUtil;

/**
 * <p> [概 要] 定数クラス。 </p>
 * <p> [詳 細] </p>
 * <p> [備 考] </p>
 * <p> Copyright(c). </p>
 * @author Edu.SJI
 */
public class Constants {
	/**
	 * 設定プロパティのspringコンポーネント名
	 */
	public static final String CONFIG_BASENAME = "fanBooksProperties";

	/**
	 * セッションキー：ログイン情報
	 */
	public static final String SESSION_LOGIN = "SessionLogin";

	/**
	 * セッションキー：システム情報
	 */
	public static final String SESSION_SYSTEMINFO = "SystemInfo";

	/**
	 * セッションキー：メニュー情報
	 */
	public static final String SESSION_MENU = "SessionMenu";

	/**
	 * セッションキー：Tokenキー
	 */
	public static final String TOKEN_KEY = "tokenKey";

	/**
	 * セッションキー：P0101検索一覧条件
	 */
	public static final String SESSION_P0101_LIST = "P0101";

	/**
	 * セッションキー：B0101検索一覧条件
	 */
	public static final String SESSION_B0101_LIST = "B0101";

	/**
	 * セッションキー：B0201検索一覧条件
	 */
	public static final String SESSION_B0201_LIST = "B0201";

	/**
	 * セッションキー：P0101_COND検索一覧条件
	 */
	public static final String SESSION_P0101_COND = "P0101_COND";

	/**
	 * セッションキー：B0201_COND検索一覧条件
	 */
	public static final String SESSION_B0101_COND = "B0101_COND";

	/**
	 * セッションキー：B0201_COND検索一覧条件
	 */
	public static final String SESSION_B0201_COND = "B0201_COND";
	/**
	 * セッションキー：B0301_COND検索一覧条件
	 */
	public static final String SESSION_B0301_COND = "B0301_COND";
	/**
	 * ドロップダウングループの「Unit」
	 */
	public static final String CD_GROUP_UNIT = "0002";

	/**
	 * ドロップダウングループの「Vessel Type」
	 */
	public static final String CD_GROUP_VESSELTYPE = "0003";

	/**
	 * ドロップダウングループの「UserType」
	 */
	public static final String CD_GROUP_USERTYPE = "0007";

	/**
	 * ドロップダウングループの「Status」
	 */
	public static final String CD_GROUP_STATUS = "0008";

	/**
	 * ドロップダウンの空の表示「All」
	 */
	public static final String DRP_EMPTY_ALL = "全て";

	/**
	 * ドロップダウンの空の表示「Blank」
	 */
	public static final String DRP_EMPTY_BLANK = "";

	/**
	 * ドロップダウンの空の表示「Select」
	 */
	public static final String DRP_EMPTY_SELECT = "Select";

	/**
	 * 画面のエラーメッセージ
	 */
	public static final String KEY_ERROR_MSG = "errorMsg";

	/**
	 * SystemDate
	 */
	public static final String SYSTEM_DATE = "systemDate";

	/**
	 * Map「TILES_ROLE_MAP」
	 */
	public static final Map<String, String> TILES_ROLE_MAP = new HashMap<String, String>();
	static {
		TILES_ROLE_MAP.put("0", "A");
		TILES_ROLE_MAP.put("1", "O");
		TILES_ROLE_MAP.put("2", "B");
		TILES_ROLE_MAP.put("3", "S");
	}

	/**
	 * UserInfoのキー「siteManager」
	 */
	public static final String KEY_USER_SITEMANAGER = "0";

	/**
	 * UserInfoのキー「operator」
	 */
	public static final String KEY_USER_OPERATOR = "1";

	/**
	 * UserInfoのキー「Keeper」
	 */
	public static final String KEY_USER_KEEPER = "2";

	/**
	 * UserInfoのキー「supplier」
	 */
	public static final String KEY_USER_SUPPLIER = "3";

	/**
	 * 採番種類：「Book」
	 */
	public static final String SEQ_TYPE_BOOK = "BK";

	/**
	 * 採番種類：「File」
	 */
	public static final String SEQ_TYPE_FILE = "FL";

	/**
	 * UserInfoのキー「day」
	 */
	public static final int KEY_USER_DAY = -7;

	/**
	 * UserInfoのキー「mounth1」
	 */
	public static final int KEY_USER_MOUNTH_EXPIRE = 3;

	/**
	 * UserInfoのキー「mounth2」
	 */
	public static final int KEY_USER_MOUNTH_FREEZE = 12;

	/**
	 * 符号br
	 */
	public static final String HTML_NEW_LINE = "<br>";

	/**
	 * 符号\r\n
	 */
	public static final String TXT_NEW_LINE = "\r\n";

	/**
	 * 頁毎件数のコード
	 */
	public static final int KEY_COUNT_PAGE = PropertiesUtil
			.getIntegerProperty("paging.count");

	/**
	 * Token長さ
	 */
	public static final int TOKEN_LEN = 15;

	/**
	 * 1日の長さ
	 */
	public static final int DATE_YONE = 1;

	/**
	 * 2日の長さ
	 */
	public static final int DATE_YTWO = 1;

	/**
	 * -1日の長さ
	 */
	public static final int DATE_NONE = -1;

	/**
	 * -2日の長さ
	 */
	public static final int DATE_NTWO = -2;

	/**
	 * -12日の長さ
	 */
	public static final int DATE_NTWELVE = -12;

	/**
	 * 天数の長さ
	 */
	public static final long DATE_COUNT = 24 * 60 * 60 * 1000;

	/**
	 * 日付の長さ
	 */
	public static final int DATE_LEN = 10;

	/**
	 * AutoGrowCollectionLimit設定する
	 */
	public static final int AUTO_GROW_COLLECTIONLIMIT = 2048;

	/**
	 * ドロップダウンの空の表示「Blank」
	 */
	public static final String BACKSLASH = "/";

	/**
	 * ファイル種類：BookCover
	 */
	public static final String FILE_BOOKCOVER = "01";

	/**
	 * webapp以下のImage Contentsの相対パス
	 */
	public static final String IMG_CONTENTS_PATH = "img/contents";

	/**
	 * LOGINのREMARK
	 */
	public static final String REMARK_NO_1 = "1";

	/**
	 * CHARSET
	 */
	public static final String CHARSET_FILENAME_IN = "Shift_JIS";

	/**
	 * CHARSET
	 */
	public static final String CHARSET_FILENAME_OUT = "ISO-8859-1";

	/**
	 * 制御フラグ
	 */
	public static final String SYSTEM_UNRUN = "0";

}
