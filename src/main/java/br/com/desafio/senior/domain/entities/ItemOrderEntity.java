package br.com.desafio.senior.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(schema = "sales", name = "product")
public class ItemOrderEntity extends DefaultEntityModel {
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private OrderEntity order;
	
	@ManyToOne
	@JoinColumn(name = "procut_id", nullable = false)
	private ProductEntity product;
	
	@Column(name= "quantity")
	private int quantity;

}
