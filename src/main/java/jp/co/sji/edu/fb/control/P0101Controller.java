package jp.co.sji.edu.fb.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sji.edu.fb.common.base.AbstractBaseController;
import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dto.CodeMasterInfo;
import jp.co.sji.edu.fb.common.util.CodeUtil;
import jp.co.sji.edu.fb.dto.P0101CondDto;
import jp.co.sji.edu.fb.dto.P0101Dto;
import jp.co.sji.edu.fb.dto.P0101ResultDto;
import jp.co.sji.edu.fb.service.P0101Service;


/**
 * <p>[概 要] SiteManager初期画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/p0101")
public class P0101Controller extends AbstractBaseController {

    /**
     * P0101ユーザサービス
     */
    @Resource
    private P0101Service p0101Service;

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
        // DropDownを初期化する
        P0101Dto p0101Dto = new P0101Dto();
        P0101CondDto p0101CondDto = new P0101CondDto();
        initDropdown(p0101CondDto);
        p0101Dto.setCondDto(p0101CondDto);
        model.addAttribute(p0101Dto);
        List<P0101ResultDto> userList = p0101Service.getInitInfo(p0101Dto.getCondDto());
        session.setAttribute(Constants.SESSION_P0101_COND, p0101Dto);
        model.addAttribute("searchResult", userList);
        return "p0101";
    }

    /**
     * <p>[概 要] ユーザ情報の検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param p0101Dto ユーザ対象
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public String processSearch(P0101Dto p0101Dto,
            Model model, HttpSession session) {
        P0101CondDto p0101CondDto = p0101Dto.getCondDto();
        // DropDownを初期化する
        initDropdown(p0101CondDto);
        // ユーザ情報の検索処理
        List<P0101ResultDto> userList = p0101Service.getInitInfo(p0101CondDto);
        session.setAttribute(Constants.SESSION_P0101_COND, p0101Dto);
        model.addAttribute("searchResult", userList);
        return "p0101";
    }

    /**
     * <p>[概 要] ドロップダウ初期化情報の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param p0101CondDto 画面対象
     */
    private void initDropdown(P0101CondDto p0101CondDto) {
        // Status ドロップダウンのセット
        p0101CondDto.setStatusList(CodeUtil.getComBox(
                Constants.CD_GROUP_STATUS, Constants.DRP_EMPTY_ALL));
        // Type ドロップダウンのセット
        List<CodeMasterInfo> typeList = CodeUtil.getComBox(
                Constants.CD_GROUP_USERTYPE, Constants.DRP_EMPTY_BLANK);
        for (CodeMasterInfo mastInfo : typeList) {
            if (Constants.KEY_USER_SITEMANAGER.equals(mastInfo.getCode())) {
                typeList.remove(mastInfo);
                break;
            }
        }
        p0101CondDto.setTypeList(typeList);
    }

    /**
     * <p>[概 要] 画面初期化情報の取得処理(子画面Back時の初期化処理)。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(value = "/back")
    public String processBack(Model model, HttpSession session) {

        P0101Dto p0101Dto = new P0101Dto();
        P0101Dto searchDto = new P0101Dto();
        // 検索一覧の情報を回復する。
        if (null != session.getAttribute(Constants.SESSION_P0101_LIST)) {
            p0101Dto = (P0101Dto) session.getAttribute(Constants.SESSION_P0101_LIST);
        }

        if (null != session.getAttribute(Constants.SESSION_P0101_COND)) {
            searchDto = (P0101Dto) session.getAttribute(Constants.SESSION_P0101_COND);
        }
        model.addAttribute(p0101Dto);
        // DropDownを初期化する
        initDropdown(p0101Dto.getCondDto());
        // 一覧情報を取得する
        List<P0101ResultDto> userList = p0101Service.getInitInfo(searchDto.getCondDto());
        model.addAttribute("searchResult", userList);
        return "p0101";
    }
}
