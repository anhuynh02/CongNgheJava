package tdtu.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("")
	public String getHome() {
		return "Homepage";
	}
	
	@GetMapping("login")
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("customer")
	@ResponseBody
	public String getCustomer() {
		return "Customer Page";
	}
	
	@GetMapping("staff")
	@ResponseBody
	public String getStaff() {
		return "Staff Page";
	}
	
	@GetMapping("admin")
	@ResponseBody
	public String getAdmin() {
		return "Admin Page";
	}
	
}
