package jp.co.sji.edu.fb.control;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sji.edu.fb.common.base.AbstractBaseController;
import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.common.util.StringUtil;
import jp.co.sji.edu.fb.dto.S1001Dto;
import jp.co.sji.edu.fb.service.S1001Service;

/**
 * <p>[概 要] Change Password画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/s1001")
public class S1001Controller extends AbstractBaseController {
    /**
     * ログ
     */
    private static Logger logger = LoggerFactory
            .getLogger(S1001Controller.class);

    /**
     * ユーザサービス
     */
    @Resource
    private S1001Service s1001Service;

     /**
     * <p>[概 要] 画面初期化情報の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param loginID loginID
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.GET)
    public String processInit(String loginID, Model model, HttpSession session) {
        S1001Dto s1001Dto = new S1001Dto();
        if (StringUtil.isEmpty(loginID)) {
            UserInfo user = (UserInfo) session
                    .getAttribute(Constants.SESSION_LOGIN);
            s1001Dto.setLoginID(user.getLoginID());
            s1001Dto.setDivType("entries");
        } else {
            s1001Dto.setLoginID(loginID);
            s1001Dto.setDivType("popup");
        }
        logger.debug("loginID is:" + loginID);
        logger.debug("DivType is:" + s1001Dto.getDivType());

        model.addAttribute("s1001Dto", s1001Dto);
        return "s1001";
    }

    /**
     * <p>[概 要] 画面情報の更新処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s1001Dto s1001Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     * @throws IOException IOException
     */
    @RequestMapping(method = RequestMethod.POST, value = "/modify")
    public String processModify(S1001Dto s1001Dto, Model model,
            HttpSession session) throws IOException {
        try {
            // パスワードを変更する。
            s1001Service.updatePassword(s1001Dto);
            UserInfo user = (UserInfo) session
                    .getAttribute(Constants.SESSION_LOGIN);
            if (null != user) {
                s1001Dto.setUserType(user.getUserType());
            }
        } catch (BpException e) {
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
            return "s1001";
        }
        // 画面遷移
        if (Constants.KEY_USER_SITEMANAGER.equals(s1001Dto.getUserType())) {
            return "redirect:/p0101.do";
        } else if (Constants.KEY_USER_OPERATOR.equals(s1001Dto.getUserType())) {
            return "redirect:/b0101.do";
        } else if (Constants.KEY_USER_SUPPLIER.equals(s1001Dto.getUserType())) {
            return "";
        } else {
            model.addAttribute("closeFlg", "true");
            return "s1001";
        }
    }
}
