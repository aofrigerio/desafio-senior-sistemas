package br.com.desafio.senior.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.senior.dtos.DiscountDTO;
import br.com.desafio.senior.services.impl.DiscountOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Desconto de Pedido")
@RestController
@RequestMapping("/order/{uuId}/discount")
@AllArgsConstructor
public class DiscountOrderResource {
	
	private final DiscountOrderService discountOrderService;
	
	@PostMapping
	private ResponseEntity<Void> discount(@RequestBody DiscountDTO discount) {
		discountOrderService.discountOrder(discount);
		return ResponseEntity.noContent().build();
	}
}
