/**
 *
 * @(#) TestService.java
 * @Package com.test.service.impl
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ofly.ep.test.aop.SystemLog;
import ofly.ep.test.api.IOFlyTestService;
import ofly.ep.test.dao.IOFlyTestDao;
import ofly.ep.test.vo.OFlyTestVo;

/**
 * 类描述：
 * 
 * @author: Logan
 *
 *          History: 2017年4月4日 下午7:42:48 Logan Created.
 * 
 */
@Service("testService")
public class OFlyTestService implements IOFlyTestService {
	@Resource
	IOFlyTestDao dao;

	@Override
	@Transactional
	@SystemLog(methods = "用户管理",module = "用户查询")
	public OFlyTestVo findById(int id) {
		String nameById = dao.queryById(id);
		OFlyTestVo vo = new OFlyTestVo();
		vo.setName(nameById);
		return vo;
	}

	@Override
	@Transactional
	@SystemLog(methods = "用户管理",module = "用户新建")
	public boolean Insert(String name) {
		// TODO Auto-generated method stub
		dao.insertByName(name);
		int i = 1 / 0;
		return true;
	}

	@Override
	@Transactional
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		return true;
	}

	@Override
	@Transactional
	public boolean DeleteByName(String name) {
		// TODO Auto-generated method stub
		dao.deleteByName(name);
		return false;
	}

}
