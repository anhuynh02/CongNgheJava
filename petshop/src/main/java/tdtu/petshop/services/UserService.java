package tdtu.petshop.services;

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
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User findByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
		
}
