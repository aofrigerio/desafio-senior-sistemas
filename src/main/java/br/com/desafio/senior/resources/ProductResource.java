package br.com.desafio.senior.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.senior.dtos.ProductDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductResource {
	
	
	@GetMapping
	private ResponseEntity<Page<?>> pageable(Pageable pageable){
		return ResponseEntity.noContent().build();
	}

	
	@GetMapping("/{uuId}")
	private ResponseEntity<?> read(){
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	private ResponseEntity<Void> create(@Valid @RequestBody ProductDTO productDTO){
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	private ResponseEntity<?> update(){
		return ResponseEntity.noContent().build();
	} 
	
	@DeleteMapping
	private ResponseEntity<?> delete(){
		return ResponseEntity.noContent().build();
	} 

}
