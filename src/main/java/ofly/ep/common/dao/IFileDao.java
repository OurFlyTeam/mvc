/**
 *
 * @(#) CodeDao.java
 * @Package ofly.ep.common.dao
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import ofly.ep.common.vo.FileVo;

/**
 *  类描述：标准代码Dao
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月20日 下午11:09:39   Logan   Created.
 *           
 */
public interface IFileDao {
	
	/**
	 * Introduction	：上传文件
	 *
	 * Author		：Logan                
	 * Create Date	：2017年5月6日 下午1:33:46
	 * History		: 2017年5月6日 下午1:33:46   Logan   Created.
	 *
	 * @param vo
	 * @return
	 *
	 */
	int upload(FileVo vo);
	Map<String, Object> download(@Param("fileId")String id);
	int update(FileVo vo);
	int delete(@Param("fileId")String fileId);
}
