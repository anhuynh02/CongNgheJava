package tdtu.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Category;
import tdtu.petshop.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select product from Product product")
	List<Product> findAll();
	
	Product findById(int id);
	
	List<Product> findAllByCategory(Category category);
	
}
