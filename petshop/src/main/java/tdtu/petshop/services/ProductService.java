package tdtu.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tdtu.petshop.models.Product;
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
	
	public List<Product> findByNameContaining(String name){
		return productRepository.findByNameContaining(name);
	}
	
	public String addProduct(Product product, String kind) {
		if(kind.equals("1")) {
			product.setCategory(categoryService.findById(1));
		}else if(kind.equals("2")) {
			product.setCategory(categoryService.findById(2));
		}else if(kind.equals("3")) {
			product.setCategory(categoryService.findById(3));
		}else if(kind.equals("4")) {
			product.setCategory(categoryService.findById(4));
		}
		if(product.getPrice() < 0) {
			return "Thêm thất bại!!! Giá cả không thể để số âm";
		}
		product.setImage("./images/product/" + product.getImage());
		productRepository.save(product);
		return null;
	}
	
	public String editProduct(Product product, String kind) {
		Product temp = productRepository.findById(product.getId());
		if(kind.equals("1")) {
			temp.setCategory(categoryService.findById(1));
		}else if(kind.equals("2")) {
			temp.setCategory(categoryService.findById(2));
		}else if(kind.equals("3")) {
			temp.setCategory(categoryService.findById(3));
		}else if(kind.equals("4")) {
			temp.setCategory(categoryService.findById(4));
		}
		if(product.getPrice() < 0) {
			return "Sửa thất bại!!! Giá cả không thể âm";
		}
		temp.setDescription(product.getDescription());
		temp.setImage("./images/product/" + product.getImage());
		temp.setName(product.getName());
		temp.setPrice(product.getPrice());
		productRepository.save(temp);
		return null;
	}
}
