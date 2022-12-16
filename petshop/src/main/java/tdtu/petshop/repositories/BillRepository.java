package tdtu.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Bill;
import tdtu.petshop.models.User;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	
	Bill findById(int id);
	
	Bill findByUserAndPurchased(User user,Boolean purchased);
	
	@Query(value = "SELECT b.id, b.purchased, SUM(b.total) AS total, b.user_id, MONTH(b.date) AS date FROM Bill b WHERE YEAR(b.date) = YEAR(CURDATE()) AND purchased = 1 GROUP BY MONTH(b.date)", nativeQuery = true)
	List<Bill> getStatistic();
}