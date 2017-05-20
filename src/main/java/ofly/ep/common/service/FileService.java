/**
 *
 * @(#) FileService.java
 * @Package ofly.ep.common.service
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ofly.ep.common.api.IFileService;
import ofly.ep.common.dao.IFileDao;
import ofly.ep.common.vo.FileVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年5月6日 下午1:29:48   Logan   Created.
 *           
 */
@Service
public class FileService implements IFileService {
	@Autowired
	private IFileDao dao;

	public boolean upload(FileVo vo) {
		int upload = dao.upload(vo);
		return upload==1?true:false;
	}
	public byte[] download(String id){
		Map<String, Object> map = dao.download(id);
		byte[] bytes = (byte[])map.get("file");
		return bytes;
	}
	public String upload(MultipartFile file)throws IOException {
		FileVo fileVo = new FileVo();
		String fileId = UUID.randomUUID().toString();
		fileVo.setFileId(fileId);
		fileVo.setFile(file.getBytes());
		fileVo.setFileName(file.getOriginalFilename());
		upload(fileVo);
		return fileId;
	}
	public boolean update(FileVo vo) {
		int i = dao.update(vo);
		return i==1?true:false;
	}
	@Override
	public boolean delete(String id) {
		int delete = dao.delete(id);
		return delete==1?true:false;
	}

}
