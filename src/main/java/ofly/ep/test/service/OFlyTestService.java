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

import ofly.ep.test.api.IOFlyTestService;
import ofly.ep.test.dao.IOFlyTestDao;
import ofly.ep.test.vo.OFlyTestVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月4日 下午7:42:48   Logan   Created.
 *           
 */
@Service("testService")
public class OFlyTestService implements IOFlyTestService {

	@Resource
	IOFlyTestDao dao;
	
	@Override
	public OFlyTestVo test() {
		String nameById = dao.qryNameById("N");
		OFlyTestVo vo = new OFlyTestVo();
		vo.setName(nameById);
		return vo;
	}

}
