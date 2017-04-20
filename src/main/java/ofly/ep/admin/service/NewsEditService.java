/**
 *
 * @(#) NewsEditService.java
 * @Package ofly.ep.admin.service
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ofly.ep.admin.api.INewsEditService;
import ofly.ep.admin.dao.INewsEditDao;
import ofly.ep.admin.vo.NewsVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月21日 上午1:05:38   Logan   Created.
 *           
 */
@Service("newsEditService")
public class NewsEditService implements INewsEditService {
	
	@Autowired
	private INewsEditDao dao;
	public Map<String, Object> save(NewsVo vo){
		Map<String, Object> result = new HashMap<String,Object>();
		int i = dao.save(vo);
		if(i==1) {
			result.put("code", 1);
			result.put("msg", "保存成功");
		} else {
			result.put("code", 0);
			result.put("msg", "保存失败");
		}
		return result;
	}

}
