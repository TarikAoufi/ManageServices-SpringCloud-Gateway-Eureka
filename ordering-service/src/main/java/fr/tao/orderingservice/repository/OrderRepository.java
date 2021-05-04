package fr.tao.orderingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.tao.orderingservice.entities.Order;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long>{

}
