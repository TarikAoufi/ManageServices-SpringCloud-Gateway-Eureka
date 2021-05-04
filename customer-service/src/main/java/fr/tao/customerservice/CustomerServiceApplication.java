package fr.tao.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import fr.tao.customerservice.entities.Customer;
import fr.tao.customerservice.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
		
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		
		return args -> {
			customerRepository.save(new Customer(null, "Ali", "Ali@gmail.com"));
			customerRepository.save(new Customer(null, "Amine", "amine@gmail.com"));
			customerRepository.save(new Customer(null, "Yasmin", "yasmine@gmail.com"));
			customerRepository.save(new Customer(null, "Fred", "fred@gmail.com"));
			customerRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});
		};
		
	}

}
