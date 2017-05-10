package ofly.ep.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import ofly.ep.test.api.IEpSubDesService;
import ofly.ep.test.vo.EpSubDesVO;

@Controller
@RequestMapping("ofly/ep/main")
public class MainController {
	
	@Resource
	private IEpSubDesService epSubDesService;

	@RequestMapping("/goMain")
	public String go_main(Model m, String source) {
		m.addAttribute("source", source);
		return "application/Main";
	}

	@RequestMapping("/goBusiness")
	public String go_business(Model m, String type) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		return "application/Business";
	}

	@RequestMapping("/goBusinessMore")
	public String go_businessMore(Model m, String type, String page) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		if (type.equals("0")) {
			m.addAttribute("type_name", "废水处理");
		} else if (type.equals("1")) {
			m.addAttribute("type_name", "废气处理");
		} else if (type.equals("2")) {
			m.addAttribute("type_name", "水处理");
		} else if (type.equals("3")) {
			m.addAttribute("type_name", "一体化设备");
		} else if (type.equals("4")) {
			m.addAttribute("type_name", "技术改造");
		} else if (type.equals("5")) {
			m.addAttribute("type_name", "钢构工程");
		}
		if(page==null){
			m.addAttribute("page", 1);
		}else{
			m.addAttribute("page", page);
		}
		return "application/BusinessMore";
	}
	
	@RequestMapping("/goBusinessInfo")
	public String go_businessIfo(Model m, String type,int id) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		if (type.equals("0")) {
			m.addAttribute("type_name", "废水处理");
		} else if (type.equals("1")) {
			m.addAttribute("type_name", "废气处理");
		} else if (type.equals("2")) {
			m.addAttribute("type_name", "水处理");
		} else if (type.equals("3")) {
			m.addAttribute("type_name", "一体化设备");
		} else if (type.equals("4")) {
			m.addAttribute("type_name", "技术改造");
		} else if (type.equals("5")) {
			m.addAttribute("type_name", "钢构工程");
		}
		m.addAttribute("id", id);
		return "application/BusinessInfo";
	}

	@RequestMapping("/goProduct")
	public String go_product(Model m, String type) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		return "application/Product";
	}
	
	@RequestMapping("/goProductMore")
	public String go_productMore(Model m, String type, String page) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		if (type.equals("0")) {
			m.addAttribute("type_name", "沼气发电");
		} else if (type.equals("1")) {
			m.addAttribute("type_name", "环保设备");
		} else if (type.equals("2")) {
			m.addAttribute("type_name", "环保配件");
		} else if (type.equals("3")) {
			m.addAttribute("type_name", "化学试剂");
		}
		if(page==null){
			m.addAttribute("page", 1);
		}else{
			m.addAttribute("page", page);
		}
		return "application/ProductMore";
	}
	
	@RequestMapping("/goProductInfo")
	public String go_productIfo(Model m, String type,int id) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		if (type.equals("0")) {
			m.addAttribute("type_name", "沼气发电");
		} else if (type.equals("1")) {
			m.addAttribute("type_name", "环保设备");
		} else if (type.equals("2")) {
			m.addAttribute("type_name", "环保配件");
		} else if (type.equals("3")) {
			m.addAttribute("type_name", "化学试剂");
		}
		m.addAttribute("id", id);
		return "application/ProductInfo";
	}

	@RequestMapping("/goNewsMore")
	public String go_newsmore(Model m, String type, String page) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		if(page==null){
			m.addAttribute("page", 1);
		}else{
			m.addAttribute("page", page);
		}
		return "application/newsmore";
	}

	@RequestMapping("/goNewsInfo")
	public String go_newsinfo(Model m, int id, String type) {
		// TODO Auto-generated method stub
		m.addAttribute("id", id);
		m.addAttribute("type", type);
		return "application/newsinfo";
	}
	
	@RequestMapping("/queryListByType")
	@ResponseBody
	public  JSONObject queryListByType(int sort_code_id,String type) {
		Map<String, Object> params =new HashMap<>();
		params.put("type",type);
		params.put("sort_code_id",sort_code_id);
		JSONObject result = new JSONObject();
		List<EpSubDesVO> list = epSubDesService.queryListByType(params);
        result.put("rows", list);
        return result;
	}

}
