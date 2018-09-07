package jp.co.sji.edu.fb.service;

import java.io.IOException;

import jp.co.sji.edu.fb.dto.B0302Dto;

/**
 * <p>[概 要] B0302のServiceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface B0302Service {
	/**
     * <p>[概 要] 検索処理。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param singleFlg 単一ユーザモード
     * @param errorFlg errorFlg対象
     * @param b0302Dto b0302Dto対象
     * @return B0302Dto
     */
	B0302Dto getInitInfo(boolean hasIdFlg, B0302Dto b0302Dto);

	 /**
     * <p>[概 要] Book情報を新規する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto
     * @throws IOException IOException
     */
	void insertBooks(B0302Dto b0302Dto) throws IOException;

	/**
     * <p>[概 要] Book情報を更新する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto対象
     */
	void updateBooks(B0302Dto b0302Dto);

	/**
     * <p>[概 要] Book情報を削除する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto対象
     */
	void deleteBooks(B0302Dto b0302Dto, String contentPath);

	/**
     * <p>[概 要] ファイルのアップロード</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param b0302Dto b0302Dto, String contentPath
     */
	String fileUploads(B0302Dto b0302Dto, String contentPath);
}
