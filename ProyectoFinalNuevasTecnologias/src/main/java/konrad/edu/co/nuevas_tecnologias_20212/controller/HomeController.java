package konrad.edu.co.nuevas_tecnologias_20212.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping({"/index","/home","/"})
	public String index() {
		return "home";
	}
	
}
