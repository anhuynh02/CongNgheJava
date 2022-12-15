package tdtu.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tdtu.petshop.models.Bill;
import tdtu.petshop.models.BillDetail;
import tdtu.petshop.models.User;
import tdtu.petshop.repositories.BillDetailRepository;
import tdtu.petshop.repositories.BillRepository;
@Service
@Transactional
public class BillDetailService {
	@Autowired
	private BillDetailRepository billDetailRepository;
	@Autowired BillService billService;
	public BillDetail findById(int id) {
		return billDetailRepository.findById(id);
	}
	public List<BillDetail> findAllByBill(Bill bill) {
		return billDetailRepository.findAllByBill(bill);
	}
	public void deleteBillDetail(int id) {
		billDetailRepository.deleteById(id);
	}
}
