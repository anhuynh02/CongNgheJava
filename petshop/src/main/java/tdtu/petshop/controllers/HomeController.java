package tdtu.petshop.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tdtu.petshop.models.User;
import tdtu.petshop.services.UserService;
import tdtu.petshop.services.UserDetailsImpl;
import tdtu.petshop.services.RoleService;

@Controller
public class HomeController {
	
	@Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
	
	@GetMapping("")
	public String getHome(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetailsImpl) {
			model.addAttribute("user", (UserDetailsImpl) principal);
		}
		else
			model.addAttribute("user", null);
		return "Homepage";
	}
	
	@GetMapping("login")
	public String getLogin() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetailsImpl)
			return "redirect:/";
		return "login";
	}
	
	@PostMapping("register")
	public String postRegister(@ModelAttribute("user") User user, HttpServletRequest request) {
		if (request.getParameter("confirmPassword") == user.getPassword()) {
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			user.setEnable(true);
			user.setRole(roleService.findById(3));
			userService.saveUser(user);
			return "login";
		} else {
			return "login";
		}
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
