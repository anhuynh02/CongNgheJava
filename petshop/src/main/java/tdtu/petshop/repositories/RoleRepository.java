package tdtu.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findById(int id);
	
}