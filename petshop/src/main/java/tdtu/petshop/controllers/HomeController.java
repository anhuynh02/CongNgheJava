package tdtu.petshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "this is Home Page";
	}
	
	@GetMapping("/user")
	public String user() {
		return "this is User Page";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "this is Admin Page";
	}
}
