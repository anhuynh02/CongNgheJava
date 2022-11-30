package tdtu.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tdtu.petshop.models.User;

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
	
	@GetMapping("register")
	public String getRegister() {
		return "register";
	}
	
	@PostMapping("register")
	public String postRegister(@ModelAttribute("user") User user) {
		return "register";
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
