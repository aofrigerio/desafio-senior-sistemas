package br.com.desafio.senior.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.desafio.senior.dtos.ProductListDTO;
import br.com.desafio.senior.dtos.ProductRequestDTO;
import br.com.desafio.senior.enuns.ProductTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
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
public class ProductEntity extends DefaultEntityModel {
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "type", length = 10, nullable = false)
	private ProductTypeEnum type;
	
	@Min(value = 0)
	@Column(name= "price")
	private Double price;
	
	public ProductEntity(ProductRequestDTO productRequestDTO) {
		this.name = productRequestDTO.name();
		this.price = productRequestDTO.price();
		this.type = productRequestDTO.type();
	}
	
	public ProductEntity(ProductListDTO productListRequestDTO) {
		this.setId(productListRequestDTO.id());
		this.name = productListRequestDTO.name();
		this.price = productListRequestDTO.price();
		this.type = productListRequestDTO.type();
	}

}
