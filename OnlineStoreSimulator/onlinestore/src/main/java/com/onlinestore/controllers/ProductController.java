package com.onlinestore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.dtos.ProductRequestDto;
import com.onlinestore.dtos.ProductResponseDto;
import com.onlinestore.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//insert product:
	@PostMapping
	public ResponseEntity<ProductResponseDto> createProduct(@RequestBody @Valid ProductRequestDto request){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(request));
	}
	
	//insert list of products:
	@PostMapping("/batch")
	public ResponseEntity<List<ProductResponseDto>> createProductBatch(@RequestBody @Valid List<ProductRequestDto> requestList){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProductBatch(requestList));
	}

	
	//list all products:
	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> listAllProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.listAllProducts());
	}
	
	//search product by id:
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDto> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
	}
	
	//update product:
	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequestDto request){
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, request));
	}
	
	//delete product:
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}









