package tdtu.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	
	public String registerCustomer(User user, String confirmPassword) {
		if (!user.getPhone().matches("\\d{10}")) {
			return "Số điện thoại không hợp lệ";
		}
		if (userRepository.findByPhone(user.getPhone()) != null) {
			return "Số điện thoại đã được sử dụng";
		}
		if (userRepository.findByUsername(user.getUsername()) != null) {
			return "Tên người dùng đã được sử dụng";
		}
		if (!user.getPassword().equals(confirmPassword)) {
			return "Mật khẩu nhập không khớp";
		}
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setEnable(true);
		user.setRole(roleService.findById(3));
		userRepository.save(user);
		return null;
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}
		
}