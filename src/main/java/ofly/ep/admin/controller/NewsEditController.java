/**
 *
 * @(#) NewsEditController.java
 * @Package ofly.ep.admin.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

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
	private static final String PATH_NEWS_INIT = "admin/news/news";
	
	@Autowired
	private INewsEditService newsEditService;
	
	
	/**
	 * Introduction	：初始化界面
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午10:23:29
	 * History		: 2017年4月21日 下午10:23:29   Logan   Created.
	 *
	 * @return
	 *
	 */
	@RequestMapping("/init")
	public String init() {
		return PATH_NEWS_INIT;
	}
	
	/**
	 * Introduction	：新增
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月22日 下午1:54:00
	 * History		: 2017年4月22日 下午1:54:00   Logan   Created.
	 *
	 * @return
	 *
	 */
	@RequestMapping("/add")
	public String add() {
		return PATH_NEWS_EDIT;
	}
	
	/**
	 * Introduction	：修改
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月22日 下午1:53:51
	 * History		: 2017年4月22日 下午1:53:51   Logan   Created.
	 *
	 * @param id
	 * @param m
	 * @return
	 *
	 */
	@RequestMapping("/edit")
	public String edit(Integer id, Model m) {
		m.addAttribute("id", id);
		return PATH_NEWS_EDIT;
	}
	/**
	 * Introduction	：根据主键查询新闻信息
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月22日 下午1:53:35
	 * History		: 2017年4月22日 下午1:53:35   Logan   Created.
	 *
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping("/queryNewsByBrimaryKey")
	@ResponseBody	
	public NewsVo queryNewsByBrimaryKey(Integer id) {
		NewsVo vo = newsEditService.queryNewsByPrimaryKey(id);
		return vo;
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
	/**
	 * Introduction	：删除
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月22日 下午1:53:27
	 * History		: 2017年4月22日 下午1:53:27   Logan   Created.
	 *
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(Integer id) {
		Map<String, Object> result = newsEditService.deleteByPrimaryKey(id);
		return result;
	} 
	
	/**
	 * Introduction	：根据类型查询List
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月22日 上午12:02:32
	 * History		: 2017年4月22日 上午12:02:32   Logan   Created.
	 *
	 * @param type
	 * @param rows
	 * @param page
	 * @return
	 *
	 */
	@RequestMapping("/queryListByType")
	@ResponseBody
	public JSONObject queryListByType(String type,Integer rows, Integer page) {
		Map<String, Object> params =new HashMap<>();
		params.put("type",type);
		params.put("rows", rows);
		params.put("offset", (page-1)*rows);
		JSONObject result = new JSONObject();
		List<NewsVo> list = newsEditService.queryListByType(params);
		int num = newsEditService.queryListNumByType(params);
		result.put("total", num);
        result.put("rows", list);
		return result;
	}

}
