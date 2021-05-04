package fr.tao.productservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import fr.tao.productservice.entities.Product;
import fr.tao.productservice.repository.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
		
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		
		return args -> {
			productRepository.save(new Product(null, "Phone Samsung", 800, 7));
			productRepository.save(new Product(null, "Phone Huawei P40", 500, 24));
			productRepository.save(new Product(null, "TV Sony", 2600, 15));
			productRepository.save(new Product(null, "PC IBM", 4500, 10));
			productRepository.findAll().forEach(p -> {
				System.out.println(p.getDesignation());
			});
			
		};
	}

}
