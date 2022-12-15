package tdtu.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Bill;
import tdtu.petshop.models.BillDetail;
import tdtu.petshop.models.Product;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer>{
	
	BillDetail findById(int id);
	List<BillDetail> findAllByBill(Bill bill);
	BillDetail findByProductAndBill(Product product, Bill bill);
}