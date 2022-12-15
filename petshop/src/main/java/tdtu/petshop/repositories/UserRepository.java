package tdtu.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Role;
import tdtu.petshop.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findById(int id);
	
	User findByUsername(String username); 
	
	User findByPhone(String phone);

	List<User> findAllByRole(Role role);
	
}