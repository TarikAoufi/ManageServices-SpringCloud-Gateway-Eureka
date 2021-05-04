package fr.tao.orderingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.tao.orderingservice.model.Customer;


@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
	
	@GetMapping(path = "/customers/{id}")
	public Customer getCustomerById(@PathVariable(name = "id") Long id);

}
