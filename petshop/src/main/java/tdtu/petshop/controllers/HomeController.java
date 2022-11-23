package tdtu.petshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Homepage";
	}
	
	@GetMapping("/user")
	public String user() {
		return "User Page";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Admin Page";
	}
	
}
