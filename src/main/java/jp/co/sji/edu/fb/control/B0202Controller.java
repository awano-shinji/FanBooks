package jp.co.sji.edu.fb.control;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sji.edu.fb.common.base.AbstractBaseController;
import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.dto.B0201Dto;
import jp.co.sji.edu.fb.dto.B0202Dto;
import jp.co.sji.edu.fb.service.B0202Service;

/**
 * <p>[概 要] 資料登録・更新画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/b0202")
public class B0202Controller extends AbstractBaseController {

    /**
     * 画面初期化モード:molUser
     */
    //public static final String MOLUSER_MODE = "molUser";

    /**
     * 画面初期化モード:singleBook
     */
    public static final String SINGLEBOOK_MODE = "singleBook";
    public static final String REG_MODE = "reg";

    /**
     * B0202サービス
     */
    @Resource
    private B0202Service b0202Service;


    /**
     * <p>[概 要] 画面初期化情報の取得処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param

 データモデル
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.GET)
    public String processInit(String modeType, Model model, HttpSession session) {

    	B0202Dto b0202Dto = new B0202Dto();
    	b0202Dto.setModeType(modeType);
    	model.addAttribute(b0202Service.getInitInfo(false, b0202Dto));
        return "b0202";
    }

    /**
     * <p>[概 要] 画面初期化情報の取得処理(Book一覧)から)。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0201Dto b0201Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processInitPost(B0201Dto b0201Dto, Model model,
            HttpSession session) {

    	// Book一覧回復用情報をセッションに設定する。
        session.setAttribute(Constants.SESSION_B0201_LIST, b0201Dto);
        // 初期化処理を行う
        B0202Dto b0202Dto = new B0202Dto();
        b0202Dto.setModeType(REG_MODE);
        b0202Dto.setBookID(b0201Dto.getBookInfo().getBookID());
    	model.addAttribute(b0202Service.getInitInfo(true, b0202Dto));
        return "b0202";
    }

    /**
     * <p>[概 要] 「Add」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     * @throws IOException IOException
     */
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String processAdd(B0202Dto b0202Dto, Model model, HttpSession session)
            throws IOException {

    	//ファイルをアップロードする
       	if(!b0202Dto.getMpFile().getOriginalFilename().isEmpty()){
       		try{
       			String fileID = b0202Service.fileUpload(b0202Dto,
           				session.getServletContext().getRealPath(""));
       			b0202Dto.setCoverImgID(fileID);
       		}catch(BpException e){
       			// 例外発生する場合、画面情報を回復する。
                handleError(b0202Dto);
                model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
           		return "b0202";
       		}
        }
       	//Book　の登録
       	try {
    		b0202Service.insertBook(b0202Dto);
    		return "redirect:/b0202.do?modeType=reg";
    	}
    	catch(BpException e){
    		// 例外発生する場合、画面情報を回復する。
            handleError(b0202Dto);
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
    		return "b0202";
    	}
     }

    /**
     * <p>[概 要] 例外発生する場合、画面情報を回復する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto
     * @param addFlag Addの時：true；Modifyの時：false
     */
    private void handleError(B0202Dto b0202Dto) {
        // 例外発生する場合、画面情報を回復する。
        B0202Dto initDto = null;
        initDto = b0202Service.getInitInfo(false, b0202Dto);
        b0202Dto.setCategoryList(initDto.getCategoryList());
    }

    /**
     * <p>[概 要] 「Modify」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST, value = "/modify")
    public String processModify(B0202Dto b0202Dto, Model model,
            HttpSession session) {

    	//ファイルをアップロードする
    	if(!b0202Dto.getMpFile().getOriginalFilename().isEmpty()){
    		try{
    			String fileID = b0202Service.fileUpload(b0202Dto,
        				session.getServletContext().getRealPath(""));
    			b0202Dto.setCoverImgID(fileID);
    		}catch(BpException e){
    			// 例外発生する場合、画面情報を回復する。
                handleError(b0202Dto);
                model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
        		return "b0202";
    		}
    	}
    	// Bookを更新する
        try {
            b0202Service.updateBook(b0202Dto);
        } catch (BpException e) {
            // 例外発生する場合、画面情報を回復する。
            handleError(b0202Dto);
            model.addAttribute("buttonMode", "modify");
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
            return "b0202";
        }
        return "redirect:/b0201.do";
    }

    /**
     * <p>[概 要] 「delete」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public String processDelete(B0202Dto b0202Dto, Model model,
            HttpSession session) {
        try {
        	// Bookを削除する
            b0202Service.deleteBook(b0202Dto,
            		session.getServletContext().getRealPath(""));
        } catch (BpException e) {
            // 例外発生する場合、画面情報を回復する。
            handleError(b0202Dto);
            model.addAttribute("buttonMode", "delete");
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
            return "b0202";
        }
        return "redirect:/b0201.do";
    }

    /**
     * <p>[概 要] 「back」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST, value = "/back")
    public String processBack(B0202Dto b0202Dto, Model model,
            HttpSession session) {
        try {
        	// Bookを削除する
            b0202Service.deleteBook(b0202Dto,
            		session.getServletContext().getRealPath(""));
        } catch (BpException e) {
            // 例外発生する場合、画面情報を回復する
            handleError(b0202Dto);
            model.addAttribute("buttonMode", "delete");
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
            return "b0202";
        }
        return "redirect:/b0201.do";
    }

}
