/**
 *
 * @(#) FileVo.java
 * @Package ofly.ep.common.vo
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.vo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年5月6日 下午1:25:31   Logan   Created.
 *           
 */
public class FileVo {
	private String fileId;
	private String fileName;
	private byte[] file;
	private String uploadTime;
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	
}
