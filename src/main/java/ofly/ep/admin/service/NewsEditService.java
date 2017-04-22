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
import java.util.List;
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
		int i;
		if(vo.getId()==0) {
			i = dao.save(vo);
		} else {
			i= dao.updateByPrimaryKey(vo);
		}
		if(i==1) {
			result.put("code", 1);
			result.put("msg", "保存成功");
		} else {
			result.put("code", 0);
			result.put("msg", "保存失败");
		}
		return result;
	}
	/**
	 * Introduction	：根据类型查询新闻List
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午11:11:44
	 * History		: 2017年4月21日 下午11:11:44   Logan   Created.
	 *
	 * @param type
	 * @return
	 *
	 */
	@Override
	public List<NewsVo> queryListByType(Map<String, Object> params) {
		List<NewsVo> list = dao.queryListByType(params);
		return list;
	}
	/**
	 * Introduction	：根据类型查询新闻List数量
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午11:43:55
	 * History		: 2017年4月21日 下午11:43:55   Logan   Created.
	 *
	 * @param params
	 * @return
	 *
	 */
	@Override
	public int queryListNumByType(Map<String, Object> params) {
		int num = dao.queryListNumByType(params);
		return num;
	}
	/**
	 * Introduction	：查询新闻信息（根据主键）
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月22日 上午9:59:22
	 * History		: 2017年4月22日 上午9:59:22   Logan   Created.
	 *
	 * @param id
	 * @return
	 *
	 */
	public NewsVo queryNewsByPrimaryKey(Integer id) {
		NewsVo vo = dao.queryNewsByPrimaryKey(id);
		return vo;
	}
	
	/**
	 * Introduction	：删除（根据主键）
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月22日 下午1:47:53
	 * History		: 2017年4月22日 下午1:47:53   Logan   Created.
	 *
	 * @param id
	 * @return
	 *
	 */
	public Map<String, Object> deleteByPrimaryKey(Integer id) {
		Map<String, Object> result = new HashMap<>();
		int i = dao.deleteByPrimaryKey(id);
		if(i==0) {
			result.put("code", "0");
			result.put("msg", "删除失败");
		} else{
			result.put("code", "1");
			result.put("msg", "删除成功");
		}
		return result;
	}

}
