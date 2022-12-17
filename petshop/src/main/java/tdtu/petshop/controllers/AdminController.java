package tdtu.petshop.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tdtu.petshop.models.Bill;
import tdtu.petshop.models.Product;
import tdtu.petshop.models.User;
import tdtu.petshop.services.BillService;
import tdtu.petshop.services.ProductService;
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
    private BillService billService;
    
    @GetMapping("")
	public String getAdmin(Model model) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	List<User> staffs = userService.findAllByRole(2);
    	List<Product> products = productService.findAll();
    	List<Bill> statistics = billService.getStatistic();
    	model.addAttribute("user", (UserDetailsImpl) principal);
    	model.addAttribute("staffs", staffs);
    	model.addAttribute("products", products);
    	model.addAttribute("statistics", statistics);
    	if (!model.containsAttribute("staff")) {
            model.addAttribute("staff", new User());
        }
		return "admin";
	}
	
	@PostMapping("/staff/add")
	public String postAddStaff(RedirectAttributes redirectAttributes, @ModelAttribute("staff") User staff, HttpServletRequest request) {
		String error = userService.registerUser(staff, request.getParameter("confirmPassword"), 2);
		if (error != null) {
			redirectAttributes.addFlashAttribute("error", error);
			redirectAttributes.addFlashAttribute("staff", staff);
		} else {
			redirectAttributes.addFlashAttribute("success", "Thêm nhân viên.");
		}
		return "redirect:/admin";
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
	
	@GetMapping("/staff/edit/password/{id}")
	public String getStaffEditPassword(RedirectAttributes redirectAttributes, Model model, @PathVariable("id") int id) {
		User user = userService.findById(id);
		if (user.getRole().getId() != 2) {
			redirectAttributes.addFlashAttribute("error", "Đối tượng không hợp lệ");
			return "redirect:/admin";
		}
		model.addAttribute("user", user);
		return "changePassword";
	}
	
	@PostMapping("/staff/edit/password")
	public String postStaffEditPassword(RedirectAttributes redirectAttributes, @ModelAttribute("user") User staff, HttpServletRequest request) {
		String error = userService.changeUserPassword(staff, request.getParameter("confirmPassword"));
		if (error == null) {
			redirectAttributes.addFlashAttribute("error", error);
			return "redirect:/admin/staff/edit/password/" + staff.getId();
		}
		redirectAttributes.addFlashAttribute("success", "Đổi mật khẩu nhân viên.");
		return "redirect:/admin";
	}
	
	@PostMapping("/staff/delete")
	public String postDeleteStaff(HttpServletRequest request) {
		userService.deleteById(Integer.parseInt(request.getParameter("id")));
		return "redirect:/admin";
	}
	
	@PostMapping("/product/add")
	public String postAddProduct(RedirectAttributes redirectAttributes, @ModelAttribute("product") Product product, HttpServletRequest request) {
		String add = productService.addProduct(product, request.getParameter("kind"));
		String screenP = "display: none;";
		String screenN = "display: none;";
		if (add == null) {
			screenP = "display: block;";
			redirectAttributes.addFlashAttribute("product_screen", screenP);
			redirectAttributes.addFlashAttribute("staff_screen", screenN);
			redirectAttributes.addFlashAttribute("prosuccess", "Thêm sản phẩm thành công");
		}else {
			redirectAttributes.addFlashAttribute("Error", "Không thêm được");
		}
		return "redirect:/admin";
	}
	
	@PostMapping("/product/edit")
	public String postProductEdit(RedirectAttributes redirectAttributes, @ModelAttribute("product") Product product, HttpServletRequest request) {
		String edit = productService.editProduct(product, request.getParameter("kind"));
		String screenP = "display: none;";
		String screenN = "display: none;";
		if(edit == null)
			screenP = "display: block;";
			redirectAttributes.addFlashAttribute("product_screen", screenP);
			redirectAttributes.addFlashAttribute("staff_screen", screenN);
			redirectAttributes.addFlashAttribute("prosuccess", "Chỉnh sửa sản phẩm thành công");
		return "redirect:/admin";
	}
	
	@GetMapping(path = "/product/edit/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductEdit(@PathVariable("id") int id) {
		return new ResponseEntity<Product>(productService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/product/delete")
	public String postDeleteProduct(RedirectAttributes redirectAttributes, HttpServletRequest request) {
		String screenP = "display: block;";
		String screenN = "display: none;";
		redirectAttributes.addFlashAttribute("product_screen", screenP);
		redirectAttributes.addFlashAttribute("staff_screen", screenN);
		productService.deleteProduct(Integer.parseInt(request.getParameter("id")));
		redirectAttributes.addFlashAttribute("prosuccess", "Xóa sản phẩm thành công.");
		return "redirect:/admin";
	}
}
