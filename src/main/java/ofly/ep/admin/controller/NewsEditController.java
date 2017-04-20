/**
 *
 * @(#) NewsEditController.java
 * @Package ofly.ep.admin.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import ofly.ep.admin.api.INewsEditService;
import ofly.ep.admin.vo.NewsVo;

/**
 *  类描述：后台新闻维护
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月20日 下午9:37:53   Logan   Created.
 *           
 */
@Controller
@RequestMapping("/newsEdit")
public class NewsEditController {
	
	// 新闻维护初始页面
	private static final String PATH_NEWS_EDIT = "admin/news/newsEdit";
	
	@Autowired
	private INewsEditService newsEditService;
	
	@RequestMapping("/init")
	public String init() {
		return PATH_NEWS_EDIT;
	}
	
	/**
	 * Introduction	：保存
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 上午1:21:59
	 * History		: 2017年4月21日 上午1:21:59   Logan   Created.
	 *
	 * @param vo
	 * @return
	 *
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(NewsVo vo) {
		Map<String, Object> result = newsEditService.save(vo);
		return result;
	}

}
