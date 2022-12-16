package tdtu.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tdtu.petshop.models.Bill;
import tdtu.petshop.models.User;
import tdtu.petshop.repositories.BillRepository;

@Service
@Transactional
public class BillService {
	
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private UserService userService;
	
	public Bill findById(int id) {
		return billRepository.findById(id);
	}
	public Bill loadBill(int id) {
		User user = userService.findById(id);
		Bill bill = billRepository.findByUserAndPurchased(user, false);
		if(bill == null) {
			bill = new Bill();
			bill.setUser(user);
			billRepository.save(bill);
		}
		return bill;
	}
	public void saveBill(Bill bill) {
		billRepository.save(bill);
	}
	public List<Bill> getStatistic() {
		return billRepository.getStatistic();
	}
}
