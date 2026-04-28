package com.onlinestore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.entities.Product;
import com.onlinestore.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//insert product:
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product){
		return ResponseEntity.status(201).body(productService.createProduct(product));
	}
	
	//list all products:
	@GetMapping
	public ResponseEntity<List<Product>> listAllProducts(){
		return ResponseEntity.status(200).body(productService.listAllProducts());
	}
	
}









