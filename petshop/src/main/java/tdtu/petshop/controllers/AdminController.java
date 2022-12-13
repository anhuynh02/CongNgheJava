package tdtu.petshop.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tdtu.petshop.models.Product;
import tdtu.petshop.models.User;
import tdtu.petshop.services.CategoryService;
import tdtu.petshop.services.ProductService;
import tdtu.petshop.services.RoleService;
import tdtu.petshop.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("")
	public String getAdmin(Model model) {
    	List<User> staffs = userService.findAllByRole(roleService.findById(2));
    	List<Product> products = productService.findAll();
    	model.addAttribute("staffs", staffs);
    	model.addAttribute("products",products);
		return "admin";
	}
	
//	@GetMapping("/staff")
//	public String getStaff(Model model) {
//		List<User> staffs = userService.findAllByRole(roleService.findById(2));
//		model.addAttribute("staffs", staffs);  
//		return "staffManagement";
//	}
	
	@PostMapping("/staff/add")
	public String postAddStaff(@ModelAttribute("staff") User staff) {
		staff.setPassword(new BCryptPasswordEncoder().encode(staff.getPassword()));
		staff.setEnable(true);
		staff.setRole(roleService.findById(2));
		userService.saveUser(staff);
		return "redirect:/admin/";
	}
	
	@GetMapping(path = "/staff/edit/{username}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getStaffEdit(@PathVariable("username") String username) {
		return new ResponseEntity<User>(userService.findByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping("/staff/edit")
	public String postStaffEdit(@ModelAttribute("staff") User staff) {
		User temp = userService.findByUsername(staff.getUsername());
		temp.setPhone(staff.getPhone());
		temp.setName(staff.getName());
		userService.saveUser(temp);
		return "redirect:/admin";
	}
	
	@GetMapping("/staff/edit/password/{username}")
	public String getStaffEditPassword(Model model, @PathVariable("username") String username) {
		model.addAttribute("username", username);
		return "staffPasswordChange";
	}
	
	@PostMapping("/staff/edit/password")
	public String postStaffEditPassword(HttpServletRequest request) {
		User staff = userService.findByUsername(request.getParameter("username"));
		staff.setPassword(new BCryptPasswordEncoder().encode(request.getParameter("password")));
		userService.saveUser(staff);
		return "redirect:/admin";
	}
	
	@PostMapping("/staff/delete")
	public String postDeleteStaff(HttpServletRequest request) {
		userService.deleteUser(request.getParameter("username"));
		return "redirect:/admin";
	}
	
	@PostMapping("/product/add")
	public String postAddProduct(@ModelAttribute("product") Product product) {
		product.setCategory(categoryService.findById(2));
		product.setImage("./images/cat/meoxiem.jpg");
		productService.saveProduct(product);
		return "redirect:/admin";
	}
	
	@PostMapping("/product/edit")
	public String postProductEdit(@ModelAttribute("product") Product product) {
		Product temp = productService.findById(product.getId());
		temp.setName(product.getName());
		temp.setPrice(product.getPrice());
		temp.setDescription(product.getDescription());
		productService.saveProduct(temp);
		return "redirect:/admin";
	}
	
	@GetMapping(path = "/product/edit/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductEdit(@PathVariable("id") String id) {
		return new ResponseEntity<Product>(productService.findById(Integer.parseInt(id)), HttpStatus.OK);
	}
	
	@PostMapping("/product/delete")
	public String postDeleteProduct(HttpServletRequest request) {
		productService.deleteProduct(Integer.parseInt(request.getParameter("id")));
		return "redirect:/admin";
	}
}
