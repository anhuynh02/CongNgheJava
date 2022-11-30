package tdtu.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Homepage";
	}
	
	@GetMapping("/customer")
	@ResponseBody
	public String customer() {
		return "Customer Page";
	}
	
	@GetMapping("/staff")
	@ResponseBody
	public String staff() {
		return "Staff Page";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin Page";
	}
	
}
