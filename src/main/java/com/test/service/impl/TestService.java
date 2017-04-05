/**
 *
 * @(#) TestService.java
 * @Package com.test.service.impl
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package com.test.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ITestDao;
import com.test.service.api.ITestService;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月4日 下午7:42:48   Logan   Created.
 *           
 */
@Service("/testService")
public class TestService implements ITestService {

	@Resource
	ITestDao dao;
	
	@Override
	public String test() {
		String nameById = dao.qryNameById("N");
		return "success";
	}

}
