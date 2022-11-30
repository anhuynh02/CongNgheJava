package tdtu.petshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tdtu.petshop.models.Role;
import tdtu.petshop.repositories.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role findById(int id) {
		return roleRepository.findById(id);
	}
		
}