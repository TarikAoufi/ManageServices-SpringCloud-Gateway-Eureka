package fr.tao.orderingservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.tao.orderingservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class OrderDetail {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double price;
	private int quantity;
	@ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Order order;
	private Long productID;
	@Transient @JsonIgnore
	private Product product;
	@Transient
	private String prodDesignation;

}
