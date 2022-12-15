package tdtu.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tdtu.petshop.models.Category;
import tdtu.petshop.models.Product;
import tdtu.petshop.repositories.CategoryRepository;
import tdtu.petshop.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryService categoryService;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public List<Product> findByCategory(int id) {
		return productRepository.findByCategory(categoryService.findById(id));
	}
	
	public Product findById(int id) {
		return productRepository.findById(id);
	}
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
	
	public List<Product> findAllByCategory(Category category){
		return productRepository.findByCategory(category);
	}
	
	public List<Product> findByNameContaining(String name){
		return productRepository.findByNameContaining(name);
	}

}
