package jp.co.sji.edu.fb.common.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jp.co.sji.edu.fb.common.constant.Constants;
import jp.co.sji.edu.fb.common.dao.FileInfoDao;
import jp.co.sji.edu.fb.common.dto.FileInfo;
import jp.co.sji.edu.fb.common.exception.BpException;
import jp.co.sji.edu.fb.common.util.MessageUtil;

/**
 * <p>[概 要] P0202のServiceのクラス。</p>
 * <p>[詳 細] </p>
 * <p>[備 考] </p>
 * <p>Copyright(c) .</p>
 * @author Edu.SJI Uyo.Tatsumi
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

	private byte[] buffer = new byte[1024];
	private int length;
	private InputStream inStream = null;
	private OutputStream outStream = null;
	private File outFile = null;

    /**
     * FileInfoDao
     */
    @Autowired(required = true)
    private FileInfoDao fileInfoDao;

    /**
     * 採番サービス
     */
    @Resource
    private SequenceService sequenceService;

    /**
     * <p>[概 要] ファイルをアップロードする</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param FileInfo file, String fileID
     * @return String fileID
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String uploadFile(MultipartFile mpFile, FileInfo fileInfo,
    		String contentPath) {

    	String fileID = null;

    	//FileIDがない場合、FileInfoの新規登録。
    	if(null == fileInfo.getFileID()){
    		//FileIDの発番
    		fileID = sequenceService.getSeqNo(Constants.SEQ_TYPE_FILE);
			//FileInfoのInsert
    		fileInfo.setFileID(fileID);
    		fileInfo.setFileName(generateFileName(fileID, mpFile.getOriginalFilename()));
    		fileInfo.setOrgFileName(mpFile.getOriginalFilename());
    		fileInfo.setFileSize(Long.toString(mpFile.getSize()));
    		fileInfoDao.insertFileInfo(fileInfo);

    	//FileIDがある場合、FileInfoの更新。
    	}else{
    		//元ファイルの削除
    		String fileName = getFileName(fileInfo.getFileID());
   			outFile = new File(contentPath + "\\" + Constants.IMG_CONTENTS_PATH + "\\"
   					+ fileName);
       		if(outFile.exists()){
       			outFile.delete();
       		}
    		//FileInfoのUpdate
    		fileInfo.setFileName(generateFileName(fileInfo.getFileID(), mpFile.getOriginalFilename()));
    		fileInfo.setOrgFileName(mpFile.getOriginalFilename());
    		fileInfo.setFileSize(Long.toString(mpFile.getSize()));
    		int upCnt = fileInfoDao.updateFileInfo(fileInfo);
    		if(upCnt==0){
    			//FileInfoが存在しない場合、Insertする。
    			fileID = sequenceService.getSeqNo(Constants.SEQ_TYPE_FILE);
    			fileInfo.setFileID(fileID);
    			fileInfo.setFileName(generateFileName(fileID, mpFile.getOriginalFilename()));
    			fileInfoDao.insertFileInfo(fileInfo);
    		}
    		fileID = fileInfo.getFileID();
    	}

    	//Fileの生成と書き込み
    	try{
    		inStream = mpFile.getInputStream();
    		outFile = new File(contentPath + "\\" + Constants.IMG_CONTENTS_PATH + "\\"
    							+ fileInfo.getFileName());
    		outStream = new FileOutputStream(outFile);
    		while ((length = inStream.read(buffer)) > 0){
				outStream.write(buffer, 0, length);
    	    }
			outStream.flush();
			inStream.close();
			outStream.close();

    	}catch(IOException e){
    		throw new BpException(MessageUtil.getMessage("E0006"));
    	}

		return fileID;
    }


	/**
     * <p>[概 要] ファイルを削除する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param String fileID
     * @return
     */
	public void deleteFile(String fileID, String contentPath) {

		//ファイル名を取得する
		FileInfo fileInfo = fileInfoDao.selectFileByID(fileID);
		//ファイル実体を削除する
		if(null != fileInfo){
			outFile = new File(contentPath + "\\" + Constants.IMG_CONTENTS_PATH + "\\"
					+ fileInfo.getFileName());
    		if(outFile.exists()){
    			outFile.delete();
    		}
		}
		//FileInfoを削除する
		fileInfoDao.deleteFileInfo(fileID);
	}

    /**
     * <p>[概 要] 実ファイル名を生成する</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param String fileID, String orgFileName
     * @return
     */
	private String generateFileName(String fileID, String orgFileName){

		Pattern p1 = Pattern.compile("^.*\\.([^.]+)$");
		Matcher m = p1.matcher(orgFileName);

		if (m.find()){
			  return fileID + "." + m.group(1);
		}else{
			throw new BpException(MessageUtil.getMessage("E0016"));
		}
	}

    /**
     * <p>[概 要] FileInfoにある実ファイル名を取得</p>
     * <p>[詳 細] </p>
     * <p>[備 考] </p>
     * @param String fileID, String orgFileName
     * @return
     */
    private String getFileName(String fileID) {

    	//ファイル名を取得する
		FileInfo fileInfo = fileInfoDao.selectFileByID(fileID);
    	if(null != fileInfo){
    		return fileInfo.getFileName();
    	}else{
    		return null;
    	}

    }

}
