package tdtu.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.petshop.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
