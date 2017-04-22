package ofly.ep.test.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("ofly/ep/main")
public class MainController{

	@RequestMapping("/goMain")
	public String go_main(Model m) {
		return "application/Main";
	}
	
	@RequestMapping("/goBusiness")
	public String go_business(Model m) {
		// TODO Auto-generated method stub
		return "application/Business";
	}
	
	@RequestMapping("/goProduct")
	public String go_product(Model m) {
		// TODO Auto-generated method stub
		return "application/Product";
	}
	

}
