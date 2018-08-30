package jp.co.sji.edu.fb.common.exception;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.util.MessageUtil;
import jp.co.sji.edu.fb.common.util.StringUtil;

/**
 * <p>[概 要] 例外処理クラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class WebExceptionResolver implements HandlerExceptionResolver {
    /**
     * ログ
     */
    private final Logger logger = LoggerFactory.getLogger(WebExceptionResolver.class);

    /**
     * <p>[概 要] 処理前処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param object Object
     * @param e 例外
     * @return ModelAndView ModelAndView
     */
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object object, Exception e) {
        ModelAndView mav = null;

        // セッションタイムアウト
        if (MessageUtil.getMessage("E0012").equals(e.getMessage())) {
            mav = new ModelAndView("tokenError");
            mav.addObject("errorMsg", MessageUtil.getMessage("E0012"));
        } else if (MessageUtil.getMessage("E0013").equals(e.getMessage())) {
            mav = new ModelAndView("redirect:/l0101.do");
            // セッションをクリアする
            Enumeration<String> sessions = request.getSession().getAttributeNames();
            while (sessions.hasMoreElements()) {
                request.getSession().removeAttribute(sessions.nextElement());
            }
        } else {
            if (e instanceof MaxUploadSizeExceededException) {
                //if (request.getRequestURI().indexOf("s0502") > -1) {
                   // mav = new ModelAndView("errorPopup");
                //} else {
                    mav = new ModelAndView("error");
                //}
                mav.addObject("errorMsg", MessageUtil.getMessage("E0017"));
                mav.addObject("errorDetail", e.getLocalizedMessage());
            } else {
                logger.error(MessageUtil.getMessage("E0010"));
                logger.error("", e);
                mav = new ModelAndView("error");
                mav.addObject("errorMsg", MessageUtil.getMessage("E0010"));
                mav.addObject("errorDetail", StringUtil.getThrowableInfo(e));
            }

        }
        // メニュー情報を設定する。
        Object obj = request.getSession().getAttribute(Constants.SESSION_LOGIN);
        if (null != obj) {
            UserInfo loginInfo = (UserInfo) obj;
            mav.getModel().put("menuUser", loginInfo);
            mav.addObject("menuGroup",
                    request.getSession().getAttribute(Constants.SESSION_MENU));
        }
        return mav;

    }
}
