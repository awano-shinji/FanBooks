package jp.co.sji.edu.fb.common.dto;

import java.io.Serializable;
/**
 * <p>[概 要] MenuInfoのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public class MenuInfo implements Serializable {

    /**
     * Serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * MenuClass
     */
    private String menuClass;

    /**
     * MenuGroup
     */
    private String menuGroup;

    /**
     * MenuName
     */
    private String menuName;

    /**
     * Url
     */
    private String url;

    /**
     * DisplayIndex
     */
    private int displayIndex;


    /**
     * <p>[概 要] MenuClassの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String MenuClass
     */
    public String getMenuClass() {
        return menuClass;
    }

    /**
     * <p>[概 要] MenuGroupの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String MenuGroup
     */
    public String getMenuGroup() {
        return menuGroup;
    }

    /**
     * <p>[概 要] MenuNameの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String MenuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * <p>[概 要] Urlの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return String Url
     */
    public String getUrl() {
        return url;
    }

    /**
     * <p>[概 要] DisplayIndexの取得。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @return int DisplayIndex
     */
    public int getDisplayIndex() {
        return displayIndex;
    }

    /**
     * <p>[概 要] MenuClassの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param menuClass MenuClass
     */
    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    /**
     * <p>[概 要] MenuGroupの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param menuGroup MenuGroup
     */
    public void setMenuGroup(String menuGroup) {
        this.menuGroup = menuGroup;
    }

    /**
     * <p>[概 要] MenuNameの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param menuName MenuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * <p>[概 要] Urlの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param url Url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * <p>[概 要] DisplayIndexの設定。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     *
     * @param displayIndex DisplayIndex
     */
    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }
}

