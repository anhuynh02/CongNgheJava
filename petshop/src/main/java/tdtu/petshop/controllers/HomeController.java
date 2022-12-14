package tdtu.petshop.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tdtu.petshop.models.Bill;
import tdtu.petshop.models.BillDetail;
import tdtu.petshop.models.Product;
import tdtu.petshop.models.User;
import tdtu.petshop.services.UserService;
import tdtu.petshop.services.UserDetailsImpl;
import tdtu.petshop.services.BillDetailService;
import tdtu.petshop.services.BillService;
import tdtu.petshop.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BillService billService;
    @Autowired
    private BillDetailService billDetailService;
	
	@GetMapping("")
	public String getHome(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetailsImpl) {
			model.addAttribute("user", (UserDetailsImpl) principal);
			UserDetailsImpl udI = (UserDetailsImpl)principal;
			Bill currentBill = billService.loadBill(udI.getId());
			List<BillDetail> billDetails = billDetailService.findAllByBill(currentBill);
			model.addAttribute("count", billDetails.size());
		}
		else
			model.addAttribute("user", null);
		List<Product> cats = productService.findByCategory(1);
		List<Product> dogs = productService.findByCategory(2);
		List<Product> foods = productService.findByCategory(3);
		List<Product> toys = productService.findByCategory(4);
		
		model.addAttribute("cats",cats);
		model.addAttribute("dogs",dogs);
		model.addAttribute("foods",foods);
		model.addAttribute("toys",toys);
		
		return "Homepage";
	}
	
	@GetMapping("cart")
	public String getCart(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", (UserDetailsImpl) principal);
			UserDetailsImpl udI = (UserDetailsImpl)principal;
			Bill currentBill = billService.loadBill(udI.getId());
			List<BillDetail> billDetails = billDetailService.findAllByBill(currentBill);
			model.addAttribute("billDetails", billDetails);
			model.addAttribute("count", billDetails.size());
		return "cart";
	}
	
	@PostMapping("addcart")
	public String postAddCart(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", (UserDetailsImpl) principal);
			//l???y th??ng tin user ??ang trong session
			UserDetailsImpl udI = (UserDetailsImpl)principal;
			//L???y bill c???a user hi???n t???i
			Bill currentBill = billService.loadBill(udI.getId());
			//L???y product b???ng id ??c g???i th??ng qua request
			Product product = productService.findById(Integer.parseInt(request.getParameter("id")));
			//L???y th??ng tin c???a bill detail c???a user
			BillDetail billDetail = billDetailService.findByProductAndBill(product,currentBill);
			//N???u trong gi??? h??ng c?? s???n ph???m c???p nh???t l???i s??? l?????ng
			if(billDetail != null) {
				billDetail.setQuantity(billDetail.getQuantity()+1);
				billDetailService.saveBillDetail(billDetail);
			}else {
				//Ng?????c l???i th??m sp v??o gi??? h??ng
				billDetailService.addBillDetail(product, currentBill);
			}
			redirectAttributes.addFlashAttribute("success", "Th??m v??o gi??? h??ng th??nh c??ng");
			//cong gia vao bill 
			currentBill.setTotal(currentBill.getTotal()+product.getPrice());
			billService.saveBill(currentBill);
			
		return "redirect:/";
	}
	@PostMapping("/cart/delete")
	public String postDeleteCart(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		billDetailService.deleteBillDetail(Integer.parseInt(request.getParameter("id")));
		redirectAttributes.addFlashAttribute("success", "X??a s???n ph???m th??nh c??ng");
		return "redirect:/cart";
	}
	
	@PostMapping("/cart/update")
	public String postUpdateCart(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if(request.getParameter("billDetailId") != "" && request.getParameter("quantityItem")!= "") {
			BillDetail billDetail = billDetailService.findById(Integer.parseInt(request.getParameter("billDetailId")));
			billDetail.setQuantity(Integer.parseInt(request.getParameter("quantityItem")));
			billDetailService.saveBillDetail(billDetail);
			redirectAttributes.addFlashAttribute("success", "C???p nh???t gi??? h??ng th??nh c??ng");
		}
		return "redirect:/cart";
	}
	
	@PostMapping("/cart/purchase")
	public String postPurchaseCart(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Bill bill = billService.findById(Integer.parseInt(request.getParameter("billId")));
		bill.setPurchased(true);
		bill.setTotal(Integer.parseInt(request.getParameter("billTotal")));
		billService.saveBill(bill);
		redirectAttributes.addFlashAttribute("success", "Thanh to??n th??nh c??ng");
		return "redirect:/cart";
	}
	
	@GetMapping("login")
	public String getLogin() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetailsImpl)
			return "redirect:/";
		return "login";
	}
	
	@GetMapping("register")
	public String getRegister(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetailsImpl)
			return "redirect:/";
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("register")
	public String postRegister(Model model, @ModelAttribute("user") User user, HttpServletRequest request) {
		String error = userService.registerUser(user, request.getParameter("confirmPassword"), 3);
		if (error != null) {
			model.addAttribute("error", error);
			model.addAttribute("user", user);
			return "register";
		}
		return "login";
	}
	
	@PostMapping("search")
	public String search(Model model, @ModelAttribute("name") String name) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetailsImpl) {
			model.addAttribute("user", (UserDetailsImpl) principal);
			UserDetailsImpl udI = (UserDetailsImpl)principal;
			Bill currentBill = billService.loadBill(udI.getId());
			List<BillDetail> billDetails = billDetailService.findAllByBill(currentBill);
			model.addAttribute("count", billDetails.size());
		}
		else
			model.addAttribute("user", null);
		List<Product> list = null;
		int length = 0;
		if(StringUtils.hasText(name)) {
			list = productService.findByNameContaining(name);
			length = list.size();
		}
		model.addAttribute("products",list);
		model.addAttribute("length",length);
		return "search";
	}
	
	@GetMapping("search")
	public String search() {
		return "redirect:/";
	}
	
	@GetMapping("/accessDenied")
	public String getAccessDenied() {
		return "accessDenied";
	}
	
	@GetMapping("info/{id}")
	public String getInfo(Model model, @PathVariable int id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetailsImpl) {
			model.addAttribute("user", (UserDetailsImpl) principal);
			UserDetailsImpl udI = (UserDetailsImpl)principal;
			Bill currentBill = billService.loadBill(udI.getId());
			List<BillDetail> billDetails = billDetailService.findAllByBill(currentBill);
			model.addAttribute("count", billDetails.size());
		}
		else
			model.addAttribute("user", null);
		Product product = productService.findById(id);
		model.addAttribute("product",product);
		
		return "info";
	}
}
