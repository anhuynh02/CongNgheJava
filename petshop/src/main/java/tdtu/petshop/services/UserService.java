package tdtu.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tdtu.petshop.models.User;
import tdtu.petshop.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleService roleService;
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User findByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}
	
	public List<User> findAllByRole(int id) {
		return userRepository.findAllByRole(roleService.findById(id));
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}
		
}