package br.com.desafio.senior.domain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.desafio.senior.dtos.OrderRequestDTO;
import br.com.desafio.senior.enuns.OrderStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
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
@Table(schema = "sales", name = "order")
public class OrderEntity extends DefaultEntityModel {

	@Column(name = "customer", length = 50)
	private String customer;

//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY)
//	private List<ItemOrderEntity> items;

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
