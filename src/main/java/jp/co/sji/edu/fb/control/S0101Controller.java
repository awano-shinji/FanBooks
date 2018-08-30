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

import jp.co.sji.edu.fb.common.aspect.ValidateHandlerInterceptor;
import jp.co.sji.edu.fb.common.base.AbstractBaseController;
import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dto.SystemInfo;
import jp.co.sji.edu.fb.common.dto.UserInfo;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.dto.P0101Dto;
import jp.co.sji.edu.fb.dto.S0101Dto;
import jp.co.sji.edu.fb.service.S0101Service;
/**
 * <p>[概 要] ユーザ登録・更新画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/s0101")
public class S0101Controller extends AbstractBaseController {


    /**
     * 画面初期化モード:molUser
     */
    public static final String MOLUSER_MODE = "molUser";

    /**
     * 画面初期化モード:listUser
     */
    public static final String HOMEPAGE_MODE = "listUser";

    /**
     * S0101サービス
     */
    @Resource
    private S0101Service s0101Service;

    /**
     * ログ
     */
    private static Logger logger = LoggerFactory
            .getLogger(ValidateHandlerInterceptor.class);


    /**
     * <p>[概 要] 画面初期化情報の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param modeType データモデル
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.GET)
    public String processInit(String modeType, Model model, HttpSession session) {

    	logger.debug("S0101Controller.processInit: GET: modeType = " + modeType);

        UserInfo user = (UserInfo) session
                .getAttribute(Constants.SESSION_LOGIN);
        S0101Dto s0101Dto = new S0101Dto();
        // 画面初期化モードを設定する
        s0101Dto.setModeType(modeType);
        // MOL USERモード：複数のユーザを検索する。
        if (MOLUSER_MODE.equals(modeType)) {
            model.addAttribute(s0101Service.getInitInfo(false, false, s0101Dto));
        } else {
            // MOL USERモード以外の場合、一つのユーザを検索する
            s0101Dto.setLoginID(user.getLoginID());
            model.addAttribute(s0101Service.getInitInfo(true, false, s0101Dto));
        }
        return "s0101";
    }

    /**
     * <p>[概 要] 画面初期化情報の取得処理（SiteManagerのHomepageから)。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param p0101Dto p0101Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processInitPost(P0101Dto p0101Dto, Model model,
            HttpSession session) {

    	logger.debug("S0101Controller.processInitPost: POST: ");

        // SiteManagerのHomepageの一覧回復用情報をセッションに設定する。
        session.setAttribute(Constants.SESSION_P0101_LIST, p0101Dto);
        // 初期化処理を行う
        S0101Dto s0101Dto = new S0101Dto();
        s0101Dto.setModeType(HOMEPAGE_MODE);
        s0101Dto.setLoginID(p0101Dto.getUserInfo().getLoginID());
        model.addAttribute(s0101Service.getInitInfo(true, false, s0101Dto));
        return "s0101";
    }

    /**
     * <p>[概 要] 「Add」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     * @throws IOException IOException
     */
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String processAdd(S0101Dto s0101Dto, Model model, HttpSession session)
            throws IOException {

        try {
            // Userを新規する
            SystemInfo systemInfo = (SystemInfo) session
                    .getAttribute(Constants.SESSION_SYSTEMINFO);
            // 初期PasswordはSystemInfo.InitialPasswordから取得し設定する。
            s0101Dto.setPassword(systemInfo.getInitialPassword());
            s0101Service.insertUser(s0101Dto);
            return "redirect:/s0101.do?modeType=" + s0101Dto.getModeType();
        } catch (BpException e) {
            // 例外発生する場合、画面情報を回復する。
            handleError(s0101Dto, true);
            model.addAttribute("buttonMode", "add");
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
            return "s0101";
        }
    }

    /**
     * <p>[概 要] 例外発生する場合、画面情報を回復する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto
     * @param addFlag Addの時：true；Modifyの時：false
     */
    private void handleError(S0101Dto s0101Dto, boolean addFlag) {
        // 例外発生する場合、画面情報を回復する。
        S0101Dto initDto = null;
        if (MOLUSER_MODE.equals(s0101Dto.getModeType())) {
            initDto = s0101Service.getInitInfo(false, addFlag, s0101Dto);
        } else {
            initDto = s0101Service.getInitInfo(true, addFlag, s0101Dto);
        }
        s0101Dto.setUserNameList(initDto.getUserNameList());
        s0101Dto.setStatusList(initDto.getStatusList());
        s0101Dto.setPicList(initDto.getPicList());
    }

    /**
     * <p>[概 要] 「Modify」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param s0101Dto s0101Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST, value = "/modify")
    public String processModify(S0101Dto s0101Dto, Model model,
            HttpSession session) {
        try {
            // Userを更新する
            s0101Service.updateUser(s0101Dto);
        } catch (BpException e) {
            // 例外発生する場合、画面情報を回復する。
            handleError(s0101Dto, false);
            model.addAttribute("buttonMode", "modify");
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
            return "s0101";
        }
        UserInfo user = (UserInfo) session
                .getAttribute(Constants.SESSION_LOGIN);
        // メニューのユーザ名を更新のために、セッションのユーザ名を更新する。
        if (user.getLoginID().equals(s0101Dto.getLoginID())) {
            user.setUserName(s0101Dto.getUserName());
        }
        // 画面遷移
        if (!MOLUSER_MODE.equals(s0101Dto.getModeType())) {
            // 遷移 Homepage(Site Manager)画面
            if (Constants.KEY_USER_SITEMANAGER.equals(user.getUserType())) {
                return "redirect:/p0101/back.do";
                // 遷移 Homepage(Operator)画面
            } else if (Constants.KEY_USER_OPERATOR.equals(user.getUserType())) {
                return "redirect:/b0101.do";
            } else {
            	return "";
            }
        } else {
            return "redirect:/s0101.do?modeType=" + s0101Dto.getModeType();
        }
    }










}
