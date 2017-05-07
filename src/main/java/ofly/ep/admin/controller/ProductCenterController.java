/**
 *
 * @(#) BusinessAreaController.java
 * @Package ofly.ep.admin.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import ofly.ep.admin.api.IProductCenterService;
import ofly.ep.admin.vo.BusinessAreaVo;
import ofly.ep.common.api.ICodeService;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年5月6日 上午8:41:59   Logan   Created.
 *           
 */
@Controller
@RequestMapping("/productCenter")
public class ProductCenterController {
	
	private static final String PATH_BUSINESS_AREA_INIT = "admin/product/product";
	private static final String PATH_BUSINESS_AREA_EDIT = "admin/product/productEdit";
	@Autowired
	private IProductCenterService productCenterService;
	@Autowired
	private ICodeService codeService;
	
	@RequestMapping("/init")
	public String init() {
		return PATH_BUSINESS_AREA_INIT;
	}
	@RequestMapping("/add") 
	public String add(Model m,
					  String type){
		String typeName = codeService.queryCodeBySortCodeAndValue("productCenterType", type);
		m.addAttribute("type", type);
		m.addAttribute("typeName", typeName);
		return PATH_BUSINESS_AREA_EDIT;
	}
	
	@RequestMapping("/edit")
	public String edit(Model m,
					   int id, String type) {
		String typeName = codeService.queryCodeBySortCodeAndValue("productCenterType", type);
		m.addAttribute("type", type);
		m.addAttribute("typeName", typeName);
		m.addAttribute("id", id);
		return PATH_BUSINESS_AREA_EDIT;
	}
	@RequestMapping("/queryByPrimarkKey")
	@ResponseBody
	public BusinessAreaVo queryByPrimarkKey(int id) {
		BusinessAreaVo vo = productCenterService.queryByPrimarkKey(id);
		return vo;
	}
	@RequestMapping("/save") 
	@ResponseBody
	public Map<String, Object> save(BusinessAreaVo vo) throws IOException {
		Map<String, Object> result = productCenterService.save(vo);
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(int id) {
		Map<String, Object> result = productCenterService.delete(id);
		return result;
	}
	@RequestMapping("/queryListByType")
	@ResponseBody
	public JSONObject queryListByType(String type,Integer rows, Integer page) {
		Map<String, Object> params =new HashMap<>();
		params.put("type",type);
		params.put("rows", rows);
		params.put("offset", (page-1)*rows);
		JSONObject result = new JSONObject();
		List<BusinessAreaVo> list = productCenterService.queryListByType(params);
		int num = productCenterService.queryListNumByType(params);
		result.put("total", num);
        result.put("rows", list);
        return result;
	}
}
