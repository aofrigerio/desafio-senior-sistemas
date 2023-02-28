package br.com.desafio.senior.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.desafio.senior.enuns.ProductTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class ProductEntity extends DefaultEntityModel {
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name= "type", length = 10)
	private ProductTypeEnum type;
	
	@Column(name= "type", length = 10)
	private Double price;

}
