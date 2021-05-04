package fr.tao.orderingservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.tao.orderingservice.entities.OrderDetail;

@RepositoryRestResource
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	public Collection<OrderDetail> findByOrderId(Long id);

}
