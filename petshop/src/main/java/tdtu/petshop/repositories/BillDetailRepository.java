package tdtu.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Bill;
import tdtu.petshop.models.BillDetail;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer>{
	
	BillDetail findById(int id);
	List<BillDetail> findAllByBill(Bill bill);
}