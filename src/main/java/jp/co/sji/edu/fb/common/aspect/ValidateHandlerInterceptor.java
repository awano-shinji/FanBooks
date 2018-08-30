package jp.co.sji.edu.fb.common.aspect;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dto.MenuInfo;
import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.common.util.MessageUtil;
import jp.co.sji.edu.fb.common.util.StringUtil;

/**
 * <p>[概 要] 例外処理のクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c).</p>
 * @author Edu.SJI
 */
public class ValidateHandlerInterceptor implements HandlerInterceptor {

    /**
     * ログ
     */
    private static Logger logger = LoggerFactory
            .getLogger(ValidateHandlerInterceptor.class);

    /**
     * USER_ID
     */
    private static final String USER_ID = "user_id";

    /**
     * ポップアップ画面
     */
    private static List<String> popupList = new ArrayList<String>();
    static {
        popupList.add("s1001");
        popupList.add("error");
    }

    /**
     * Token対象外
     */
    private static List<String> unTokenList = new ArrayList<String>();
    static {
        unTokenList.add("back");
        unTokenList.add("init");
        unTokenList.add("search");
        unTokenList.add("reset");
        unTokenList.add("page");
    }

    /**
     * <p>[概 要] 全部処理終わった処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param arg0 HttpServletRequest
     * @param arg1 HttpServletResponse
     * @param arg2 Object
     * @param arg3 Exception
     * @throws Exception 例外
     */
    public void afterCompletion(HttpServletRequest arg0,
            HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    /**
     * <p>[概 要] 処理後処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param arg0 HttpServletRequest
     * @param arg1 HttpServletResponse
     * @param arg2 Object
     * @param arg3 ModelAndView
     * @throws Exception 例外
     */
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
            Object arg2, ModelAndView arg3) throws Exception {
        if (null == arg3) {
            return;
        }
        MDC.remove(USER_ID);
        // メニュー情報を設定する。
        arg3.addObject("menuGroup",
                arg0.getSession().getAttribute(Constants.SESSION_MENU));
        arg3.getModel().put(Constants.TOKEN_KEY,
                arg0.getAttribute(Constants.TOKEN_KEY));
        // ユーザタイプより、TILESを設定する。
        Object obj = arg0.getSession().getAttribute(Constants.SESSION_LOGIN);
        if (null != obj) {
            UserInfo loginInfo = (UserInfo) obj;
            boolean popupFlg = false;
            for (String popup : popupList) {
                if (arg3.getViewName().indexOf(popup) > -1) {
                    popupFlg = true;
                }
            }
            if (arg3.getViewName().indexOf(".do") == -1
                    && arg3.getViewName().indexOf("l0101") == -1
                    && (!popupFlg || arg3.getViewName().indexOf("s1001") > -1)) {
                arg3.setViewName(arg3.getViewName()
                        + Constants.TILES_ROLE_MAP.get(
                                loginInfo.getUserType()));
            }
            arg3.getModel().put("menuUser", loginInfo);
        }
    }

    /**
     * <p>[概 要] 処理前処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param arg0 HttpServletRequest
     * @param arg1 HttpServletResponse
     * @param handler Objectr
     * @return boolean 続きフラグ
     * @throws Exception 例外
     */
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
            Object handler) throws Exception {
        String userId = "";
        Object obj = arg0.getSession().getAttribute(Constants.SESSION_LOGIN);
        if (null != obj) {
            UserInfo loginInfo = (UserInfo) obj;
            userId = loginInfo.getLoginID();
        }

        MDC.put(USER_ID, userId);

        if (arg0.getRequestURI().indexOf("/ajax/") > -1) {
            return true;
        }

        // Sessionチェック
        if (arg0.getRequestURI().indexOf("l0101.do") == -1
                && null == arg0.getSession().getAttribute(
                        Constants.SESSION_LOGIN)) {
            // ログインの時、パスワード変更必要場合
            if (arg0.getRequestURI().indexOf("s1001") > -1) {
                return true;
            } else {
                throw new BpException(MessageUtil.getMessage("E0013"));
            }
        }

        // ファイルダウンロードの権限設定
        if (arg0.getRequestURI().indexOf("excel") > -1
                || arg0.getRequestURI().indexOf("filedownload") > -1) {
            return true;
        }
        boolean popupFlg = false;
        // tokenチェック
        if ("POST".equalsIgnoreCase(arg0.getMethod())) {
            for (String popup : popupList) {
                if (arg0.getRequestURI().indexOf(popup) > -1) {
                    popupFlg = true;
                }
            }
            if (popupFlg && arg0.getRequestURI().indexOf("s1001") == -1) {
                return true;
            }
            // ログインの場合、Tokenｔチェックしない
            if (arg0.getRequestURI().indexOf("l0101.do") > -1) {
                String newToken = StringUtil.genRandomNum(Constants.TOKEN_LEN);
                arg0.getSession().setAttribute(Constants.TOKEN_KEY, newToken);
                arg0.setAttribute(Constants.TOKEN_KEY, newToken);
            } else {
                // Tokenチェック
                String tokenKey = arg0.getParameter(Constants.TOKEN_KEY);
                if (!StringUtil.isEmpty(tokenKey)) {
                    boolean tokenFlg = true;
                    if (arg0.getRequestURI()
                            .substring(arg0.getContextPath().length() + 1)
                            .indexOf("/") == -1) {
                        tokenFlg = false;
                    }
                    for (String unToken : unTokenList) {
                        if (arg0.getRequestURI().indexOf(unToken) > -1) {
                            tokenFlg = false;
                            break;
                        }
                    }
                    if (tokenFlg) {
                        if (tokenKey.equals(arg0.getSession().getAttribute(
                                Constants.TOKEN_KEY))) {
                            String newToken = StringUtil
                                    .genRandomNum(Constants.TOKEN_LEN);
                            arg0.getSession().setAttribute(Constants.TOKEN_KEY,
                                    newToken);
                            arg0.setAttribute(Constants.TOKEN_KEY, newToken);
                        } else {
                            // Tokenが不一致場合、エラーとする
                            throw new BpException(
                                    MessageUtil.getMessage("E0012"));
                        }
                    }
                } else {
                    // Tokenがない場合、エラーとする
                    throw new BpException(MessageUtil.getMessage("E0012"));
                }
            }
        } else {
            arg0.setAttribute(Constants.TOKEN_KEY, arg0.getSession()
                    .getAttribute(Constants.TOKEN_KEY));
            if (arg0.getRequestURI().indexOf("l0101.do") > -1) {
                return true;
            }

            // 権限チェック
            List<List<MenuInfo>> menuList = (List<List<MenuInfo>>) arg0
                    .getSession().getAttribute(Constants.SESSION_MENU);
            boolean existFlg = false;
            int idStart = arg0.getRequestURI().lastIndexOf("/");
            String gamenID = arg0.getRequestURI().substring(
                    arg0.getContextPath().length() + 1);
            if (gamenID.indexOf("/") > -1) {
                gamenID = gamenID.substring(0, gamenID.indexOf("/"));
            } else {
                gamenID = gamenID.substring(0, gamenID.indexOf("."));
            }

            // メニュー情報より、該当画面の権限をチェックする
            for (List<MenuInfo> menuGroup : menuList) {
                for (MenuInfo menu : menuGroup) {
                    if (StringUtil.nvl(menu.getUrl()).indexOf(gamenID) >= 0) {
                        existFlg = true;
                        break;
                    }
                }
            }

            if (!existFlg) {
                for (String popup : popupList) {
                    if (arg0.getRequestURI().indexOf(popup) > -1) {
                        existFlg = true;
                    }
                }
            }

            if (!existFlg) {
                // invalid accessの場合、エラーとする
                throw new BpException(MessageUtil.getMessage("E0013"));
            }
        }

        logger.debug("preHandle finished: " + arg0.getRequestURI());
        return true;
    }

}
