package tdtu.petshop.services;

import java.util.List;
import java.util.Optional;

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
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public Product findById(int id) {
		return productRepository.findById(id);
	}
	
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
	
	public List<Product> findAllByCategory(Category category){
		return productRepository.findAllByCategory(category);
	}
}
