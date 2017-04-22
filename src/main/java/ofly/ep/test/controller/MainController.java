package ofly.ep.test.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("ofly/ep/main")
public class MainController{

	@RequestMapping("/goMain")
	public String go_main(Model m,String source) {
		m.addAttribute("source", source);
		return "application/Main";
	}
	
	@RequestMapping("/goBusiness")
	public String go_business(Model m,String type) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		return "application/Business";
	}
	
	@RequestMapping("/goProduct")
	public String go_product(Model m,String type) {
		// TODO Auto-generated method stub
		m.addAttribute("type", type);
		return "application/Product";
	}
	

}
