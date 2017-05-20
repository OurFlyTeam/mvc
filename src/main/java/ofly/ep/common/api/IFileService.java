/**
 *
 * @(#) IFileService.java
 * @Package ofly.ep.common.api
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.api;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ofly.ep.common.vo.FileVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年5月6日 下午1:28:34   Logan   Created.
 *           
 */
@Service
public interface IFileService {
	
	boolean upload(FileVo vo);
	byte[] download(String id);
	String upload(MultipartFile file)throws IOException;
	boolean update(FileVo vo);
	boolean delete(String id);
}
