/**
 *
 * @(#) NewsEditDao.java
 * @Package ofly.ep.admin.dao
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.dao;

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
	
	int save(NewsVo vo);

}
