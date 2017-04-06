/**
 *
 * @(#) OFlyTestController.java
 * @Package ofly.ep.test.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.test.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ofly.ep.test.api.IOFlyTestService;
import ofly.ep.test.vo.OFlyTestVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月5日 下午9:42:47   Logan   Created.
 *           
 */
@Controller
@RequestMapping("ofly/test")
public class OFlyTestController {
	
    static Logger logger = Logger.getLogger(OFlyTestController.class.getName());
    
	@Autowired
	@Qualifier("testService")  
	IOFlyTestService TestService;
	
	@RequestMapping("/init")
	@ResponseBody
	public OFlyTestVo init(Model m) {
		OFlyTestVo vo = TestService.findById(1);
		return vo;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public void addShop(Model m) {
		try{
			TestService.Insert("nihao3");
			TestService.Insert("nihao21111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
			TestService.Insert("nihao4");
		}catch(Exception e){
			 e.printStackTrace();
			 logger.error("addShop 出错");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteShop(Model m) {
		TestService.DeleteByName("nihao2");
		TestService.DeleteByName("nihao3");
	}
}
