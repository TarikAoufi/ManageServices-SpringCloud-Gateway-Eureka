package fr.tao.orderingservice;

import java.util.Date;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import fr.tao.orderingservice.entities.Order;
import fr.tao.orderingservice.entities.OrderDetail;
import fr.tao.orderingservice.feign.CustomerRestClient;
import fr.tao.orderingservice.feign.ProductRestClient;
import fr.tao.orderingservice.model.Customer;
import fr.tao.orderingservice.model.Product;
import fr.tao.orderingservice.repository.OrderDetailRepository;
import fr.tao.orderingservice.repository.OrderRepository;

@SpringBootApplication
@EnableFeignClients
public class OrderingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderingServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(
			OrderRepository orderRepository,
			OrderDetailRepository orderDetailRepository,
			CustomerRestClient customerRestClient,
			ProductRestClient productRestClient
			) {
		
		return args -> {
			Customer customer = customerRestClient.getCustomerById(1L);
			Order order = orderRepository.save(new Order(null, new Date(), null, customer.getId(), null));
			PagedModel<Product> productPageModel = productRestClient.pageProducts();
			
			productPageModel.forEach(p -> {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setPrice(p.getPrice()); // On suppose que le prix est le même dans la commande
				orderDetail.setQuantity(1 + new Random().nextInt(100));
				orderDetail.setOrder(order);
				orderDetail.setProductID(p.getId());
				orderDetailRepository.save(orderDetail);
			});
			
		};
	}
	

}
