package br.com.desafio.senior.resources;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.senior.dtos.ItemOrderListDTO;
import br.com.desafio.senior.dtos.ItemOrderRequestDTO;
import br.com.desafio.senior.services.ItemOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Itens do Pedido")
@RestController
@RequestMapping("/item-order")
@AllArgsConstructor
public class ItemOrderResource {
	
	private ItemOrderService itemOrderService;
	
	@GetMapping
	private ResponseEntity<Page<ItemOrderListDTO>> pageable(Pageable pageable){
		return ResponseEntity.ok(itemOrderService.listPageable(pageable));
	}
	
	@GetMapping("/{uuId}")
	private ResponseEntity<ItemOrderListDTO> read(@PathVariable UUID uuId){
		return ResponseEntity.ok(new ItemOrderListDTO(itemOrderService.getOne(uuId)));
	}
	
	@PostMapping
	private ResponseEntity<ItemOrderListDTO> create(@Valid @RequestBody ItemOrderRequestDTO itemOrderRequestDTO, UriComponentsBuilder uriBuilder){		
		var createItemOrder = itemOrderService.create(itemOrderRequestDTO);		
		var uri = uriBuilder.path("/order/{id}").buildAndExpand(createItemOrder.id()).toUri();
		return ResponseEntity.created(uri).body(createItemOrder);
	}
	
	@PutMapping("/{uuId}")
	private ResponseEntity<ItemOrderListDTO> update(@PathVariable UUID uuId, @Valid @RequestBody ItemOrderRequestDTO itemOrderRequestDTO){
		return ResponseEntity.noContent().build();
	} 
	
	@DeleteMapping("/{uuId}")
	private ResponseEntity<?> delete(@PathVariable UUID uuId){
		return ResponseEntity.noContent().build();
	} 

}
