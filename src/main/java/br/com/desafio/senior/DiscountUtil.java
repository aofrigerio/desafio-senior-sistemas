package br.com.desafio.senior;

import java.util.List;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.enuns.ProductTypeEnum;

public class DiscountUtil {
	
	public static Double simpleDiscount(Double discount, List<ItemOrderEntity> items) {
		Double totalServices = items.stream()
				.filter(predicate -> predicate.getProduct().getType().equals(ProductTypeEnum.SERVICE))
				.mapToDouble(map -> map.getQuantity() * map.getProduct().getPrice()).sum();

		Double totalProducts = items.stream()
				.filter(predicate -> predicate.getProduct().getType().equals(ProductTypeEnum.PRODUCT))
				.mapToDouble(map -> map.getQuantity() * map.getProduct().getPrice()).sum();
				

		totalProducts = totalServices + (totalProducts * (1 - (discount/100)));
		return totalProducts;
	}

}
