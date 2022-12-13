package tdtu.petshop.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Category;
import tdtu.petshop.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Product findById(int id);
	
	List<Product> findByCategory(Category category);
	
}
