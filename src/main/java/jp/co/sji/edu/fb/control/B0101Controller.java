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
import jp.co.sji.edu.fb.dto.B0101CondDto;
import jp.co.sji.edu.fb.dto.B0101Dto;
import jp.co.sji.edu.fb.dto.B0101ResultDto;
import jp.co.sji.edu.fb.service.B0101Service;

/**
 * <p>[概 要] 閲覧者初期画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/b0101")
public class B0101Controller extends AbstractBaseController {

    /**
     * B0201サービス
     */
    @Resource
    private B0101Service b0101Service;


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
    	B0101Dto b0101Dto = new B0101Dto();
    	B0101CondDto b0101CondDto = new B0101CondDto();
    	// ShowのMenuをセットする
    	List<CodeMasterInfo> categoryList = CodeUtil.getComBox(
                Constants.CD_GROUP_VESSELTYPE, Constants.DRP_EMPTY_ALL);
    	b0101Dto.setCategoryList(categoryList);

    	//検索条件をセットする。
    	b0101Dto.setCondDto(b0101CondDto);
    	// Book検索
    	List<B0101ResultDto> bookList = b0101Service.getInitInfo(b0101Dto.getCondDto());
   	   	session.setAttribute(Constants.SESSION_B0101_COND, b0101Dto);
    	model.addAttribute("searchResult", bookList);
    	model.addAttribute(b0101Dto);
        return "b0101";
    }

    /**
     * <p>[概 要] 画面初期化情報の取得処理(BookSlide)から)。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0201Dto b0201Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processInitPost(B0101Dto b0101Dto, Model model,
            HttpSession session) {
    	// ShowのMenuをセットする
    	List<CodeMasterInfo> categoryList = CodeUtil.getComBox(
                Constants.CD_GROUP_VESSELTYPE, Constants.DRP_EMPTY_ALL);
    	b0101Dto.setCategoryList(categoryList);
    	// Book検索
    	List<B0101ResultDto> bookList = b0101Service.getInitInfo(b0101Dto.getCondDto());
   	   	session.setAttribute(Constants.SESSION_B0101_COND, b0101Dto);
    	model.addAttribute("searchResult", bookList);
    	model.addAttribute(b0101Dto);
        return "b0101";
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



        return "b0101";
    }
}
