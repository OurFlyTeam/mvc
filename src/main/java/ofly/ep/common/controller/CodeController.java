/**
 *
 * @(#) CodeController.java
 * @Package ofly.ep.common.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ofly.ep.common.api.ICodeService;
import ofly.ep.common.vo.CodeVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月20日 下午11:02:22   Logan   Created.
 *           
 */
@Controller
@RequestMapping("/code")
public class CodeController {
	
	@Autowired
	private ICodeService codeService;
	
	/**
	 * Introduction	：根据分类编码查询标准代码List
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月20日 下午11:25:39
	 * History		: 2017年4月20日 下午11:25:39   Logan   Created.
	 *
	 * @param sortCode
	 * @return
	 *
	 */
	@RequestMapping("/getCodeListBySortCode")
	@ResponseBody
	public List<CodeVo> getCodeListBySortCode(String sortCode) {
		List<CodeVo> list = codeService.queryCodeListBySortCode(sortCode);
		return list;
		
	}
	
}
