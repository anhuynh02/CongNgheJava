package tdtu.petshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import tdtu.petshop.repositories.UserRepository;

@SpringBootApplication
@ComponentScan({"tdtu.petshop.models"})
@EnableJpaRepositories("tdtu.petshop.repositories")
public class PetshopApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PetshopApplication.class, args);
	}

}
