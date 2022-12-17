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
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BillService billService;
	
    @GetMapping("")
	public String getStaff(Model model) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	List<Product> products = productService.findAll();
    	List<Bill> statistics = billService.getStatistic();
    	model.addAttribute("user", (UserDetailsImpl) principal);
    	model.addAttribute("products", products);
    	model.addAttribute("statistics", statistics);
		return "staff";
	}
	
	@GetMapping("/product")
	public String getProduct() {
		return "productManagement";
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