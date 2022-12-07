package tdtu.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tdtu.petshop.models.User;
import tdtu.petshop.services.RoleService;
import tdtu.petshop.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
	
	@GetMapping("/staff")
	public String getStaff(Model model) {
		List<User> staffs = userService.findAllByRole(roleService.findById(2));
		model.addAttribute("staffs", staffs);  
		return "staffManagement";
	}
	
}
