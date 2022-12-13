package tdtu.petshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tdtu.petshop.models.Category;
import tdtu.petshop.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category findById(int id) {
		return categoryRepository.findById(id);
	}
	
	
}
