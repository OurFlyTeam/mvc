/**
 *
 * @(#) OFlyTestController.java
 * @Package ofly.ep.test.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ofly.ep.test.api.IOFlyTestService;
import ofly.ep.test.service.OFlyTestService;
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
	@Autowired
	IOFlyTestService TestService;
	
	@RequestMapping("/init")
	@ResponseBody
	public OFlyTestVo init(Model m) {
		OFlyTestVo vo = TestService.test();
		return vo;
	}
}
