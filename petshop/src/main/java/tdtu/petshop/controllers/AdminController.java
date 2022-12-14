package tdtu.petshop.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tdtu.petshop.models.Product;
import tdtu.petshop.models.User;
import tdtu.petshop.services.CategoryService;
import tdtu.petshop.services.ProductService;
import tdtu.petshop.services.RoleService;
import tdtu.petshop.services.UserDetailsImpl;
import tdtu.petshop.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("")
	public String getAdmin(Model model) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	List<User> staffs = userService.findAllByRole(2);
    	List<Product> products = productService.findAll();
    	model.addAttribute("user", (UserDetailsImpl) principal);
    	model.addAttribute("staffs", staffs);
    	model.addAttribute("products", products);
		return "admin";
	}
	
	@PostMapping("/staff/add")
	public String postAddStaff(RedirectAttributes redirectAttributes, @ModelAttribute("staff") User staff, HttpServletRequest request) {
		String error = userService.registerUser(staff, request.getParameter("confirmPassword"));
		if (error != null) {
			redirectAttributes.addFlashAttribute("error", error);
			redirectAttributes.addFlashAttribute("staff", staff);
		} else {
			redirectAttributes.addFlashAttribute("success", "Thêm nhân viên.");
		}
		return "redirect:/admin/";
	}
	
	@GetMapping(path = "/staff/edit/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getStaffEdit(@PathVariable("id") int id) {
		return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/staff/edit")
	public String postStaffEdit(RedirectAttributes redirectAttributes, @ModelAttribute("staff") User staff) {
		String error = userService.changeUserInfo(staff);
		if (error != null) {
			redirectAttributes.addFlashAttribute("error", error);
		} else {
			redirectAttributes.addFlashAttribute("success", "Sửa thông tin nhân viên.");
		}
		return "redirect:/admin";
	}
	
//	@GetMapping("/staff/edit/password/{id}")
//	public String getStaffEditPassword(Model model, @PathVariable("id") int id) {
//		model.addAttribute("id", id);
//		return "staffPasswordChange";
//	}
	
	@PostMapping("/staff/edit/password")
	public String postStaffEditPassword(HttpServletRequest request) {
		User staff = userService.findById(Integer.parseInt(request.getParameter("id")));
		staff.setPassword(new BCryptPasswordEncoder().encode(request.getParameter("password")));
		userService.saveUser(staff);
		return "redirect:/admin";
	}
	
	@PostMapping("/staff/delete")
	public String postDeleteStaff(HttpServletRequest request) {
		userService.deleteById(Integer.parseInt(request.getParameter("id")));
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
	public ResponseEntity<Product> getProductEdit(@PathVariable("id") int id) {
		return new ResponseEntity<Product>(productService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/product/delete")
	public String postDeleteProduct(HttpServletRequest request) {
		productService.deleteProduct(Integer.parseInt(request.getParameter("id")));
		return "redirect:/admin";
	}
}
