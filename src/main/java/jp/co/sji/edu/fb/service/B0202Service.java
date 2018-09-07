package jp.co.sji.edu.fb.service;

import java.io.IOException;

import jp.co.sji.edu.fb.dto.B0202Dto;

/**
 * <p>[概 要] B0202のServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface B0202Service {
    /**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param singleFlg 単一ユーザモード
     * @param errorFlg errorFlg対象
     * @param b0202Dto b0202Dto対象
     * @return B0202Dto
     */
    B0202Dto getInitInfo(boolean hasIdFlg, B0202Dto b0202Dto);

    /**
     * <p>[概 要] Book情報を新規する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto
     * @throws IOException IOException
     */
    void insertBook(B0202Dto b0202Dto) throws IOException;

    /**
     * <p>[概 要] Book情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto対象
     */
    void updateBook(B0202Dto b0202Dto);

    /**
     * <p>[概 要] Book情報を削除する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto対象
     */
    void deleteBook(B0202Dto b0202Dto, String contentPath);

    /**
     * <p>[概 要] ファイルのアップロード</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0202Dto b0202Dto, String contentPath
     */
    String fileUpload(B0202Dto b0202Dto, String contentPath);

}
