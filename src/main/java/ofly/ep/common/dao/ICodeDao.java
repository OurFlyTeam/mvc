/**
 *
 * @(#) CodeDao.java
 * @Package ofly.ep.common.dao
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ofly.ep.common.vo.CodeVo;

/**
 *  类描述：标准代码Dao
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月20日 下午11:09:39   Logan   Created.
 *           
 */
public interface ICodeDao {
	
	/**
	 * Introduction	：根据标准代码分类查询标准代码列表
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月20日 下午11:18:53
	 * History		: 2017年4月20日 下午11:18:53   Logan   Created.
	 *
	 * @param sortCode
	 * @return
	 *
	 */
	List<CodeVo> queryCodeListBySortCode(@Param("sortCode")String sortCode);
	/**
	 * Introduction	：根据标准代码分类和值获取中文年Name
	 *
	 * Author		：Logan                
	 * Create Date	：2017年5月6日 上午10:50:03
	 * History		: 2017年5月6日 上午10:50:03   Logan   Created.
	 *
	 * @param sortCode
	 * @param value
	 * @return
	 *
	 */
	String queryCodeBySortCodeAndValue(@Param("sortCode")String sortCode, @Param("value")String value);
}
