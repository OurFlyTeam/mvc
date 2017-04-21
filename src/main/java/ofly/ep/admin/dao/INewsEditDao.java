/**
 *
 * @(#) NewsEditDao.java
 * @Package ofly.ep.admin.dao
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import ofly.ep.admin.vo.NewsVo;

/**
 *  类描述：新闻维护Dao
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月21日 上午1:07:09   Logan   Created.
 *           
 */
public interface INewsEditDao {
	/**
	 * Introduction	：根据类型查询新闻List
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午11:09:46
	 * History		: 2017年4月21日 下午11:09:46   Logan   Created.
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
	 * Create Date	：2017年4月21日 下午11:39:48
	 * History		: 2017年4月21日 下午11:39:48   Logan   Created.
	 *
	 * @param type
	 * @return
	 *
	 */
	int queryListNumByType(Map<String, Object> params);
	
	/**
	 * Introduction	：保存
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午11:08:57
	 * History		: 2017年4月21日 下午11:08:57   Logan   Created.
	 *
	 * @param vo
	 * @return
	 *
	 */
	int save(NewsVo vo);

}
