/**
 *
 * @(#) CodeService.java
 * @Package ofly.ep.common.service
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ofly.ep.common.api.ICodeService;
import ofly.ep.common.dao.ICodeDao;
import ofly.ep.common.vo.CodeVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月20日 下午11:21:42   Logan   Created.
 *           
 */
@Service("codeService")
public class CodeService implements ICodeService {

	
	@Autowired
	ICodeDao dao;
	/**
	 * Introduction	：根据分类查询标准代码List
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月20日 下午11:22:01
	 * History		: 2017年4月20日 下午11:22:01   Logan   Created.
	 *
	 * @param sortCode
	 * @return
	 *
	 */
	@Override
	public List<CodeVo> queryCodeListBySortCode(String sortCode) {
		List<CodeVo> list = dao.queryCodeListBySortCode(sortCode);
		return list;
	}

}
