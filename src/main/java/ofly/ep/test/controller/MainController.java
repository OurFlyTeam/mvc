package ofly.ep.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ofly/ep/main")
public class MainController {

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
	public String go_businessMore(Model m, String type) {
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
		return "application/BusinessMore";
	}

	@RequestMapping("/goProduct")
	public String go_product(Model m, String type) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		return "application/Product";
	}

	@RequestMapping("/goNewsMore")
	public String go_newsmore(Model m, String type, String page) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		m.addAttribute("page", page);
		return "application/newsmore";
	}

	@RequestMapping("/goNewsInfo")
	public String go_newsinfo(Model m, int id, String type) {
		// TODO Auto-generated method stub
		m.addAttribute("id", id);
		m.addAttribute("type", type);
		return "application/newsinfo";
	}

}
