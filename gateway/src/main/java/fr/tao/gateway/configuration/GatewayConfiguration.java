package fr.tao.gateway.configuration;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
	/*	
	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {	
		/* // config. statique :  quand l'url est fixe qui ne change pas
		return builder.routes()
				.route("r1", r -> r.path("/customers/**").uri("http://localhost:8081/"))
				.route("r2", r -> r.path("/products/**").uri("http://localhost:8082/"))
				.build();
		*/
		
		/* // config. statique : quand on connait seulement le nom du service
		return builder.routes()  // lb : load balancer
				.route("r1", r -> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
				.route("r2", r -> r.path("/products/**").uri("lb://PRODUCT-SERVICE"))
				.build();
	
	}
	*/
	
	/**
	 * Configuration dynamique : Quand on ne connait pas les microservices.
	 * 
	 * Le routage se fait via le nom du microservice contenu dans l'URL
	 * de la requête, et qui se trouve dans l'annuaire.
	 * 
	 */
	@Bean
	DiscoveryClientRouteDefinitionLocator discoveryRoutes(ReactiveDiscoveryClient rdc,
	        DiscoveryLocatorProperties dlp) {
	    return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}

}
