package jp.co.sji.edu.fb.common.service;

import org.springframework.web.multipart.MultipartFile;

import jp.co.sji.edu.fb.common.dto.FileInfo;


/**
 * <p>[概 要] File処理Serviceのインタフェース。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI. Uyo.Tatsumi
 */
public interface FileService {

    /**
     * <p>[概 要] ファイルをアップロードする</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param FileInfo file, String fileID, String contentPath
     * @return String fileID
     */
    String uploadFile(MultipartFile mpFile, FileInfo fileInfo, String contentPath);

    /**
     * <p>[概 要] ファイルを削除する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param String fileID
     * @return 
     */
    void deleteFile(String fileID, String contentPath);
    
}
