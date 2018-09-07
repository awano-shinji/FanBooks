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
import jp.co.sji.edu.fb.dto.B0301Dto;
import jp.co.sji.edu.fb.dto.B0302Dto;
import jp.co.sji.edu.fb.service.B0302Service;

/**
 * <p>[概 要] 資料登録・更新画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/b0302")
public class B0302Controller extends AbstractBaseController {

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
     * B0302サービス
     */
    @Resource
    private B0302Service b0302Service;


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

    	B0302Dto b0302Dto = new B0302Dto();
    	b0302Dto.setModeType(modeType);
    	model.addAttribute(b0302Service.getInitInfo(false, b0302Dto));
        return "b0302";
    }

    /**
     * <p>[概 要] 画面初期化情報の取得処理(初期一覧)から)。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param B0301Dto b0301Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processInitPost(B0301Dto b0301Dto,Model model,
            HttpSession session) {

    	// Book一覧回復用情報をセッションに設定する。
        session.setAttribute(Constants.SESSION_B0301_LIST, b0301Dto);
        // 初期化処理を行う
        B0302Dto b0302Dto = new B0302Dto();
        b0302Dto.setModeType(REG_MODE);
        b0302Dto.setBookID(b0301Dto.getBookInfo().getBookID());
    	model.addAttribute(b0302Service.getInitInfo(true, b0302Dto));
        return "b0302";
    }


    /**
     * <p>[概 要] 「Add」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     * @throws IOException IOException
     */
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String processAdd(B0302Dto b0302Dto, Model model, HttpSession session)
            throws IOException {

    	//ファイルをアップロードする
       	if(!b0302Dto.getMpFile().getOriginalFilename().isEmpty()){
       		try{
       			String fileID = b0302Service.fileUploads(b0302Dto,
           				session.getServletContext().getRealPath(""));
       			b0302Dto.setCoverImgID(fileID);
       		}catch(BpException e){
       			// 例外発生する場合、画面情報を回復する。
                handleError(b0302Dto);
                model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
           		return "b0302";
       		}
        }
       	//Book　の登録
       	try {
    		b0302Service.insertBooks(b0302Dto);
    		return "redirect:/b0302.do?modeType=reg";
    	}
    	catch(BpException e){
    		// 例外発生する場合、画面情報を回復する。
            handleError(b0302Dto);
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
    		return "b0302";
    	}
     }

    /**
     * <p>[概 要] 例外発生する場合、画面情報を回復する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto
     * @param addFlag Addの時：true；Modifyの時：false
     */
    private void handleError(B0302Dto b0302Dto) {
        // 例外発生する場合、画面情報を回復する。
        B0302Dto initDto = null;
        initDto = b0302Service.getInitInfo(false, b0302Dto);
        b0302Dto.setCategoryList(initDto.getCategoryList());
    }

    /**
     * <p>[概 要] 「Modify」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST, value = "/modify")
    public String processModify(B0302Dto b0302Dto, Model model,
            HttpSession session) {

    	//ファイルをアップロードする
    	if(!b0302Dto.getMpFile().getOriginalFilename().isEmpty()){
    		try{
    			String fileID = b0302Service.fileUploads(b0302Dto,
        				session.getServletContext().getRealPath(""));
    			b0302Dto.setCoverImgID(fileID);
    		}catch(BpException e){
    			// 例外発生する場合、画面情報を回復する。
                handleError(b0302Dto);
                model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
        		return "b0302";
    		}
    	}
    	// Bookを更新する
        try {
            b0302Service.updateBooks(b0302Dto);
        } catch (BpException e) {
            // 例外発生する場合、画面情報を回復する。
            handleError(b0302Dto);
            model.addAttribute("buttonMode", "modify");
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
            return "b0302";
        }
        return "redirect:/b0301.do";
    }

    /**
     * <p>[概 要] 「delete」ボタン押下の処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto
     * @param model データモデル
     * @param session セッション
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public String processDelete(B0302Dto b0302Dto, Model model,
            HttpSession session) {
        try {
        	// Bookを削除する
            b0302Service.deleteBooks(b0302Dto,
            		session.getServletContext().getRealPath(""));
        } catch (BpException e) {
            // 例外発生する場合、画面情報を回復する。
            handleError(b0302Dto);
            model.addAttribute("buttonMode", "delete");
            model.addAttribute(Constants.KEY_ERROR_MSG, e.getMessage());
            return "b0302";
        }
        return "redirect:/b0301.do";
    }
}