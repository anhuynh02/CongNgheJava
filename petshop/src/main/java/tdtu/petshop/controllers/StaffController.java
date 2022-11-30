package tdtu.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@GetMapping("/product")
	public String getProduct() {
		return "productManagement";
	}
	
}