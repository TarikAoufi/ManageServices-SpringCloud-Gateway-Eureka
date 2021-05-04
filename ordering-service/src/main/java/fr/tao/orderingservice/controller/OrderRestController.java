package fr.tao.orderingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.tao.orderingservice.entities.Order;
import fr.tao.orderingservice.feign.CustomerRestClient;
import fr.tao.orderingservice.feign.ProductRestClient;
import fr.tao.orderingservice.model.Customer;
import fr.tao.orderingservice.model.Product;
import fr.tao.orderingservice.repository.OrderDetailRepository;
import fr.tao.orderingservice.repository.OrderRepository;
import lombok.Data;

@Data
@RestController
public class OrderRestController {
	
	private OrderRepository orderRepository;
	private OrderDetailRepository orderDetailRepository;
	private CustomerRestClient customerRestClient;
	private ProductRestClient productRestClient;
	
	// Injection des dépendances
	public OrderRestController(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository,
			CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
		this.orderRepository = orderRepository;
		this.orderDetailRepository = orderDetailRepository;
		this.customerRestClient = customerRestClient;
		this.productRestClient = productRestClient;
	}
	
	@GetMapping(path = "/fullOrder/{id}")
	public Order getOrder(@PathVariable(name = "id") Long id) {
		Order order = orderRepository.findById(id).get();
		Customer customer = customerRestClient.getCustomerById(order.getCustomerID());
		order.setCustomer(customer);
		order.getOrderDetails().forEach(od -> {
			Product product = productRestClient.getProductById(od.getProductID());
 		//	od.setProduct(product);
			od.setProdDesignation(product.getDesignation());
		});		
		return order;
	}
	

}
