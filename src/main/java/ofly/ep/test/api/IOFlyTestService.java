/**
 *
 * @(#) ITestService.java
 * @Package com.test.service.api
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.test.api;

import ofly.ep.test.vo.OFlyTestVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月4日 下午7:42:03   Logan   Created.
 *           
 */
public interface IOFlyTestService {
	OFlyTestVo findById(int id);
	boolean Insert(String name);
	boolean Delete(int id);
	boolean DeleteByName(String name);
}
