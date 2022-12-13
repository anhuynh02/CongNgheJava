package tdtu.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	@Query("select category from Category category where category.id = ?1")
	Category findbById(int id);
}
