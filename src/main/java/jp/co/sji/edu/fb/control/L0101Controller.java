package jp.co.sji.edu.fb.control;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sji.edu.fb.common.base.AbstractBaseController;
import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dto.SystemInfo;
import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.common.util.DateUtil;
import jp.co.sji.edu.fb.service.L0101Service;

/**
 * <p>[概 要] ログイン画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/l0101")
public class L0101Controller extends AbstractBaseController {

    /**
     * l0101サービス
     */
    @Resource
    private L0101Service l0101Service;


    /**
     * <p>[概 要] 画面のログアウト処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String processLogout(Model model, HttpSession session) {
        Enumeration<String> sessions = session.getAttributeNames();
        while (sessions.hasMoreElements()) {
            session.removeAttribute(sessions.nextElement());
        }
        return "redirect:/l0101.do";
    }

    /**
     * <p>[概 要] 画面初期化情報の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.GET)
    public String processInit(Model model, HttpSession session) {
        model.addAttribute(new UserInfo());
        // 縮退運行フラグ取得
        SystemInfo systemInfo = l0101Service.getRunFlagInfo();
        session.setAttribute(Constants.SESSION_SYSTEMINFO, systemInfo);
        model.addAttribute("runFlag", systemInfo.getRunFlag());
        return "l0101";
    }

    /**
     * <p>[概 要] 「Login」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param userDto userDto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processLogin(UserInfo userDto, Model model,
            HttpSession session) {
        // 縮退運行フラグ取得
        SystemInfo systemInfo = l0101Service.getRunFlagInfo();
        session.setAttribute(Constants.SESSION_SYSTEMINFO, systemInfo);
        if (Constants.SYSTEM_UNRUN.equals(systemInfo.getRunFlag())) {
            model.addAttribute("runFlag", systemInfo.getRunFlag());
        	return "l0101";
        }

        UserInfo userInfo = null;
        String remark = userDto.getRemark();
        try {
            userInfo = l0101Service.getLoginInfo(userDto);
            session.setAttribute(Constants.SESSION_LOGIN, userInfo);
            // menuの値をセッションに保存する
            session.setAttribute(Constants.SESSION_MENU,
                    l0101Service.getMenuInfo(userInfo.getUserType()));
            session.setAttribute(Constants.SYSTEM_DATE, DateUtil
                    .formatDateWest(DateUtil.getCurrentDate(),
                            DateUtil.DATE_PATTERN_6));
        } catch (BpException e) {
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
            return "l0101";
        }

        if (Constants.REMARK_NO_1.equals(remark)) {
            return "redirect:/s1001.do";
        }
        if (Constants.KEY_USER_SITEMANAGER.equals(userInfo.getUserType())) {
            return "redirect:/p0101.do";
        } else if (Constants.KEY_USER_OPERATOR.equals(userInfo.getUserType())) {
            return "redirect:/b0101.do";
        } else if (Constants.KEY_USER_KEEPER.equals(userInfo.getUserType())) {
            return "redirect:/b0201.do";
        } else{
        	return "";
        }

    }
}
