/**
 *
 * @(#) INewsEditService.java
 * @Package ofly.ep.admin.api
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.api;


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
	
	Map<String, Object> save(NewsVo vo);

}
