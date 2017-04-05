/**
 *
 * @(#) TestController.java
 * @Package com.test.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerator;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.test.bo.TestBo;
import com.test.service.impl.TestService;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月4日 下午6:50:58   Logan   Created.
 *           
 */
@Controller
@RequestMapping("/test")
public class TestController {
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	private TestService testService;
	
	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}


	@RequestMapping("/init")
	public String init(String id,HttpServletRequest request, HttpServletResponse response) {
		String test = testService.test();
		logger.error(id);
		logger.debug(test);
		return "test";  
	}
	@RequestMapping("/json")
	public @ResponseBody TestBo json() {
		TestBo bo = new TestBo();
		bo.setName("Logan");
		bo.setValue("1");
		return bo;
	}

}
