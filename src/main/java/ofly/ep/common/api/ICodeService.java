/**
 *
 * @(#) ICodeService.java
 * @Package ofly.ep.common.api
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.api;

import java.util.List;

import ofly.ep.common.vo.CodeVo;

/**
 *  类描述：标准代码Api
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月20日 下午11:20:37   Logan   Created.
 *           
 */
public interface ICodeService {
	/**
	 * Introduction	：根据分类查询标准代码List
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月20日 下午11:20:56
	 * History		: 2017年4月20日 下午11:20:56   Logan   Created.
	 *
	 * @param sortCode
	 * @return
	 *
	 */
	List<CodeVo> queryCodeListBySortCode(String sortCode);
	/**
	 * Introduction	：根据分类+值查询名称
	 *
	 * Author		：Logan                
	 * Create Date	：2017年5月6日 上午10:51:26
	 * History		: 2017年5月6日 上午10:51:26   Logan   Created.
	 *
	 * @param sortCode
	 * @param value
	 * @return
	 *
	 */
	String queryCodeBySortCodeAndValue(String sortCode, String value);
}
