package tdtu.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tdtu.petshop.models.User;
import tdtu.petshop.services.UserService;
import tdtu.petshop.services.RoleService;

@Controller
public class HomeController {
	
	@Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
	
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
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setEnable(true);
		user.setRole(roleService.findById(3));
		userService.addUser(user);
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
