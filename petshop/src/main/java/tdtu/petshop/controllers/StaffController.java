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
	
    @PostMapping("/product/add")
	public String postAddProduct(RedirectAttributes redirectAttributes, @ModelAttribute("product") Product product, HttpServletRequest request) {
		String add = productService.addProduct(product, request.getParameter("kind"));
		String screenP = "display: none;";
		String screenN = "display: none;";
		if (add == null) {
			screenP = "display: block;";
			redirectAttributes.addFlashAttribute("product_screen", screenP);
			redirectAttributes.addFlashAttribute("staff_screen", screenN);
			redirectAttributes.addFlashAttribute("proSuccess", "Th??m s???n ph???m th??nh c??ng");
		}else {
			screenP = "display: block;";
			redirectAttributes.addFlashAttribute("proError", add);
			redirectAttributes.addFlashAttribute("staff_screen", screenN);
			redirectAttributes.addFlashAttribute("product_screen", screenP);
		}
		return "redirect:/staff";
	}
	
	@PostMapping("/product/edit")
	public String postProductEdit(RedirectAttributes redirectAttributes, @ModelAttribute("product") Product product, HttpServletRequest request) {
		String edit = productService.editProduct(product, request.getParameter("kind"));
		String screenP = "display: none;";
		String screenN = "display: none;";
		if(edit == null) {
			screenP = "display: block;";
			redirectAttributes.addFlashAttribute("product_screen", screenP);
			redirectAttributes.addFlashAttribute("staff_screen", screenN);
			redirectAttributes.addFlashAttribute("proSuccess", "Ch???nh s???a s???n ph???m th??nh c??ng");
		}else {
			screenP = "display: block;";
			redirectAttributes.addFlashAttribute("product_screen", screenP);
			redirectAttributes.addFlashAttribute("staff_screen", screenN);
			redirectAttributes.addFlashAttribute("proError", edit);
		}
		return "redirect:/staff";
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
		redirectAttributes.addFlashAttribute("proSuccess", "Xo??a s???n ph???m tha??nh c??ng.");
		return "redirect:/staff";
	}
}