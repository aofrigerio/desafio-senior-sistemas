package br.com.desafio.senior.domain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.desafio.senior.domain.dtos.OrderRequestDTO;
import br.com.desafio.senior.domain.enuns.OrderStatusEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
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
@Table(schema = "sales", name = "orders")
public class OrderEntity extends DefaultEntityModel {

	@Column(name = "customer", length = 50)
	private String customer;

	@JsonIgnore
	@OneToMany(mappedBy="order", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<ItemOrderEntity> items;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 10, nullable = false)
	private OrderStatusEnum status;
	
	@Column(name = "off")
	private Double off;

	@Column(name = "total")
	private Double total;

	@PrePersist
	protected void onCreateOrder() {
		status = OrderStatusEnum.OPEN;
	}
	
	public OrderEntity(OrderRequestDTO orderRequestDTO) {
		this.setCustomer(orderRequestDTO.customer());
	}

}
