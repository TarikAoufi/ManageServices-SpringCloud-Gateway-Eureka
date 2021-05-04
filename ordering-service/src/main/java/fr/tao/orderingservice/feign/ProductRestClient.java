package fr.tao.orderingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.tao.orderingservice.model.Product;


@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductRestClient {
	
	@GetMapping(path = "/products")
	PagedModel<Product> pageProducts();
	
	@GetMapping(path = "/products/{id}")
	public Product getProductById(@PathVariable Long id);

}
