/**
 *
 * @(#) ITestDao.java
 * @Package com.test.dao
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.test.dao;

import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(readOnly = true)
	String queryById(int id);
	@Transactional
	void insertByName(String name);
	@Transactional
	void deleteById(int id);
	@Transactional
	void deleteByName(String name);
	@Transactional
	void updateByVo(OFlyTestVo vo);
}
