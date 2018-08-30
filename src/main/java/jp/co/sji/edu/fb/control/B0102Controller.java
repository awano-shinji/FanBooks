package jp.co.sji.edu.fb.control;

import javax.servlet.http.HttpSession;

import jp.co.sji.edu.fb.common.base.AbstractBaseController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>[概 要] HomePage画面のアクションクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
@Controller
@RequestMapping("/b0102")
public class B0102Controller extends AbstractBaseController {


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

    	
        return "b0102";
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
    	

    	
        return "b0102";
    }
}
