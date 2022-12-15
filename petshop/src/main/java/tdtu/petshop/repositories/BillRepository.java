package tdtu.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Bill;
import tdtu.petshop.models.User;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	
	Bill findById(int id);
	
	Bill findByUserAndPurchased(User user,Boolean purchased);
}