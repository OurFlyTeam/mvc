package ofly.ep.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ofly/ep/main")
public class MainController {
	
	@RequestMapping("/goMain")
	public String test(Model m) {
		return "application/Main";
	}
	

}
