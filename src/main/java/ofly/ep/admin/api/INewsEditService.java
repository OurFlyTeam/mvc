/**
 *
 * @(#) INewsEditService.java
 * @Package ofly.ep.admin.api
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.api;


import java.util.List;
import java.util.Map;

import ofly.ep.admin.vo.NewsVo;

/**
 *  类描述：新闻维护API
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月21日 上午1:05:13   Logan   Created.
 *           
 */
public interface INewsEditService {
	
	/**
	 * Introduction	：根据类型查询新闻List
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午11:10:39
	 * History		: 2017年4月21日 下午11:10:39   Logan   Created.
	 *
	 * @param type
	 * @return
	 *
	 */
	List<NewsVo> queryListByType(Map<String, Object> params);
	/**
	 * Introduction	：根据类型查询新闻List数量
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午11:43:07
	 * History		: 2017年4月21日 下午11:43:07   Logan   Created.
	 *
	 * @param params
	 * @return
	 *
	 */
	int queryListNumByType(Map<String, Object> params);
	
	/**
	 * Introduction	：保存
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午11:10:41
	 * History		: 2017年4月21日 下午11:10:41   Logan   Created.
	 *
	 * @param vo
	 * @return
	 *
	 */
	Map<String, Object> save(NewsVo vo);

}
