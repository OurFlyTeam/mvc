/**
 *
 * @(#) OFlyTestController.java
 * @Package ofly.ep.test.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ofly.ep.test.aop.SystemLog;
import ofly.ep.test.api.IOFlyTestService;
import ofly.ep.test.vo.OFlyTestVo;

/**
 * 类描述：
 * 
 * @author: Logan
 *
 *          History: 2017年4月5日 下午9:42:47 Logan Created.
 * 
 */
@Controller
@RequestMapping("ofly/test")
public class OFlyTestController {

	@Resource(name="testService")
	IOFlyTestService TestService;

	@RequestMapping("/find")
	@ResponseBody
	public OFlyTestVo init(Model m) {
		OFlyTestVo vo = TestService.findById(1);
		return vo;
	}

	@RequestMapping("/add")
	@ResponseBody
	@SystemLog(methods = "用户管理",module = "用户登陆")
	public void addShop(Model m) throws Exception {
		TestService.Insert("3bear");
	}

	@RequestMapping("/delete")
	@ResponseBody
	public void deleteShop(Model m) {
		TestService.DeleteByName("3bear");
	}
}
