package tdtu.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Category findById(int id);
	
}