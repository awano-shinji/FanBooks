package jp.co.sji.edu.fb.common.dao;

import org.springframework.stereotype.Repository;

import jp.co.sji.edu.fb.common.dto.FileInfo;

/**
 * <p>[概 要] FileInfoのDAOのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c).</p>
 * @author Edu.SJI
 */
@Repository ("fileInfoDao")
public class FileInfoDaoImpl extends BaseDao implements FileInfoDao  {

    /**
     * <p>[概 要] FileInfo情報を検索する。</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param FileInfo fileInfo情報
     * @return
     */
	public void insertFileInfo(FileInfo fileInfo) {
		insert("fileInfo.insertFileInfo", fileInfo);
	}

    /**
     * <p>[概 要] FileInfo情報を更新する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param FileInfo fileInfo
     * @return int 更新件数
     */
	public int updateFileInfo(FileInfo fileInfo) {
		return update("fileInfo.updateFileInfo", fileInfo);
	}

    /**
     * <p>[概 要] FileInfo情報を１件取得</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param String fileID
     * @return FileInfo 検索結果
     */
	public FileInfo selectFileByID(String fileID) {
		return (FileInfo)queryForObject("fileInfo.selectFileByID", fileID);
	}

    /**
     * <p>[概 要] FileInfo情報を削除する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param String fileID
     * @return
     */
	public int deleteFileInfo(String fileID) {
		return delete("fileInfo.deleteFileInfo", fileID);
	}

}

