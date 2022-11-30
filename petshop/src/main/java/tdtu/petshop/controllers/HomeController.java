package tdtu.petshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Homepage";
	}
	
	@GetMapping("/customer")
	public String customer() {
		return "Customer Page";
	}
	
	@GetMapping("/staff")
	public String staff() {
		return "Staff Page";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Admin Page";
	}
	
}
