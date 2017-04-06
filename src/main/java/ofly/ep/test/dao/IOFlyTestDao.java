/**
 *
 * @(#) ITestDao.java
 * @Package com.test.dao
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.test.dao;

import ofly.ep.test.vo.OFlyTestVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月5日 下午1:42:07   Logan   Created.
 *           
 */
public interface IOFlyTestDao{
	String queryById(int id);
	void insertByName(String name);
	void deleteById(int id);
	void deleteByName(String name);
	void updateByVo(OFlyTestVo vo);
}
