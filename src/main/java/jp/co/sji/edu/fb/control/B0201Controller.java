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
import jp.co.sji.edu.fb.dto.B0201CondDto;
import jp.co.sji.edu.fb.dto.B0201Dto;
import jp.co.sji.edu.fb.dto.B0201ResultDto;
import jp.co.sji.edu.fb.service.B0201Service;

/**
 * <p>[概 要] 管理者初期画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/b0201")
public class B0201Controller extends AbstractBaseController {

    /**
     * B0201サービス
     */
    @Resource
    private B0201Service b0201Service;


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
    	//Dto情報設定
    	B0201Dto b0201Dto = new B0201Dto();
    	B0201CondDto b0201CondDto = new B0201CondDto();
    	// DropDownを初期化する
        initDropdown(b0201CondDto);
    	b0201Dto.setCondDto(b0201CondDto);
    	model.addAttribute(b0201Dto);
    	// Book検索
    	List<B0201ResultDto> bookList = b0201Service.getInitInfo(b0201Dto.getCondDto());
   	   	session.setAttribute(Constants.SESSION_B0201_COND, b0201Dto);
    	model.addAttribute("searchResult", bookList);
        return "b0201";
    }

    /**
     * <p>[概 要] ドロップダウ初期化情報の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param p0101CondDto 画面対象
     */
    private void initDropdown(B0201CondDto b0201CondDto) {
        // CategoryList ドロップダウンのセット
        List<CodeMasterInfo> categoryList = CodeUtil.getComBox(
                Constants.CD_GROUP_VESSELTYPE, Constants.DRP_EMPTY_BLANK);
        /*for (CodeMasterInfo mastInfo : categoryList) {
            if (Constants.KEY_USER_SITEMANAGER.equals(mastInfo.getCode())) {
            	categoryList.remove(mastInfo);
                break;
            }
        }*/
    	b0201CondDto.setCategoryList(categoryList);
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
    public String processSearch(B0201Dto b0201Dto,
            Model model, HttpSession session) {
        B0201CondDto b0201CondDto = b0201Dto.getCondDto();
        // DropDownを初期化する
        initDropdown(b0201CondDto);
        // Book情報の検索処理
        List<B0201ResultDto> bookList = b0201Service.getInitInfo(b0201CondDto);
   	   	session.setAttribute(Constants.SESSION_B0201_COND, b0201Dto);
    	model.addAttribute("searchResult", bookList);
        return "b0201";
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

        B0201Dto b0201Dto = new B0201Dto();
        B0201Dto searchDto = new B0201Dto();
        // 検索一覧の情報を回復する。
        if (null != session.getAttribute(Constants.SESSION_B0201_LIST)) {
            b0201Dto = (B0201Dto) session.getAttribute(Constants.SESSION_B0201_LIST);
        }

        if (null != session.getAttribute(Constants.SESSION_B0201_COND)) {
            searchDto = (B0201Dto) session.getAttribute(Constants.SESSION_B0201_COND);
        }
        model.addAttribute(b0201Dto);
        // DropDownを初期化する
        initDropdown(b0201Dto.getCondDto());
        // 一覧情報を取得する
        List<B0201ResultDto> bookList = b0201Service.getInitInfo(searchDto.getCondDto());
        model.addAttribute("searchResult", bookList);

        return "b0201";
    }
}
