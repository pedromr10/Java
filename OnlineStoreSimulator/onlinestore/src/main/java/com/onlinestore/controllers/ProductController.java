package com.onlinestore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//list all products:
	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> listAllProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.listAllProducts());
	}
	
}









