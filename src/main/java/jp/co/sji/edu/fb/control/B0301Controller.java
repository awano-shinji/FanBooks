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
import jp.co.sji.edu.fb.dto.B0301CondDto;
import jp.co.sji.edu.fb.dto.B0301Dto;
import jp.co.sji.edu.fb.dto.B0301ResultDto;
import jp.co.sji.edu.fb.service.B0301Service;

/**
 * <p>[概 要] 管理者初期画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/b0301")
public class B0301Controller extends AbstractBaseController {

	/**
	 * B0301サービス
	 */
	@Resource
	private B0301Service b0301Service;


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
		// Dto情報設定
		B0301Dto b0301Dto = new B0301Dto();
		B0301CondDto b0301CondDto = new B0301CondDto();
		// DropDownを初期化する
		initDropdown(b0301CondDto);
		b0301Dto.setCondDto(b0301CondDto);
		model.addAttribute(b0301Dto);
		// Book検索
		List<B0301ResultDto> bookList = b0301Service.getInitInfo(b0301Dto.getCondDto());
		session.setAttribute(Constants.SESSION_B0301_COND, b0301Dto);
		model.addAttribute("searchResult", bookList);
		return "b0301";
	}

	/**
	 * <p>[概 要] ドロップダウン初期化情報の取得処理。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param b0301CondDto 画面対象
	 */
	private void initDropdown(B0301CondDto b0301CondDto) {
		// CategoryList ドロップダウンのセット
		List<CodeMasterInfo> categoryList = CodeUtil.getComBox(
				Constants.CD_GROUP_VESSELTYPE, Constants.DRP_EMPTY_BLANK);
		b0301CondDto.setCategoryList(categoryList);
	}

	 /**
     * <p>[概 要] ブック情報の検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0301Dto ユーザ対象
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public String processSearch(B0301Dto b0301Dto,
            Model model, HttpSession session) {
        B0301CondDto b0301CondDto = b0301Dto.getCondDto();
        // DropDownを初期化する
        initDropdown(b0301CondDto);
        // Book情報の検索処理
        List<B0301ResultDto> bookList = b0301Service.getInitInfo(b0301CondDto);
   	   	session.setAttribute(Constants.SESSION_B0301_COND, b0301Dto);
    	model.addAttribute("searchResult", bookList);
        return "b0301";
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

    	B0301Dto b0301Dto = new B0301Dto();
    	B0301Dto searchDto = new B0301Dto();
    	// 検索一覧の情報を回復する。
    	if(null != session.getAttribute(Constants.SESSION_B0301_LIST)) {
    		b0301Dto = (B0301Dto) session.getAttribute(Constants.SESSION_B0301_LIST);
    	}

    	if(null != session.getAttribute(Constants.SESSION_B0301_COND)) {
    		searchDto = (B0301Dto) session.getAttribute(Constants.SESSION_B0301_COND);
    	}
    	model.addAttribute(b0301Dto);
    	// DropDownを初期化する
    	initDropdown(b0301Dto.getCondDto());
    	// 一覧情報を取得する
    	List<B0301ResultDto> bookList = b0301Service.getInitInfo(searchDto.getCondDto());
    	model.addAttribute("searchResult", bookList);

    	return "b0301";

    }
}