package jp.co.sji.edu.fb.common.dao;

import jp.co.sji.edu.fb.common.dto.FileInfo;


/**
 * <p>[概 要] FileInfoのDAOのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI
 */
public interface FileInfoDao {

    /**
     * <p>[概 要] FileInfo情報を登録する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param FileInfo fileInfo情報
     * @return
     */
    void insertFileInfo(FileInfo fileInfo);

    /**
     * <p>[概 要] FileInfo情報を更新する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param FileInfo fileInfo
     * @return int 更新件数
     */
    int updateFileInfo(FileInfo fileInfo);

    /**
     * <p>[概 要] FileInfo情報を１件取得</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param String fileID
     * @return FileInfo 検索結果
     */
    FileInfo selectFileByID(String fileID);

    /**
     * <p>[概 要] FileInfo情報を削除する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param String fileID
     * @return
     */
    int deleteFileInfo(String fileID);
    
}

