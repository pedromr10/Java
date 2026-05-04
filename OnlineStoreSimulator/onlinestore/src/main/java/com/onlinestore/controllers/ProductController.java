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
import com.onlinestore.exceptions.ErrorResponse;
import com.onlinestore.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//insert product:
	@Operation(summary = "Create a new product", description = "Creates a new product in the catalog based on the provided data and returns the created product with its generated ID.")
	@PostMapping
	public ResponseEntity<ProductResponseDto> createProduct(@RequestBody @Valid ProductRequestDto request){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(request));
	}
	
	//insert list of products:
	@Operation(summary = "Create multiple products", description = "Creates multiple products in a single request, useful for bulk operations such as initial data setup or testing.")
	@PostMapping("/batch")
	public ResponseEntity<List<ProductResponseDto>> createProductBatch(@RequestBody @Valid List<ProductRequestDto> requestList){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProductBatch(requestList));
	}

	
	//list all products:
	@Operation(summary = "Retrieve all products", description = "Returns a list of all products available in the catalog.")
	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> listAllProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.listAllProducts());
	}
	
	//search product by id:
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Product found", content = @Content(schema = @Schema(implementation = ProductResponseDto.class))),
		    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
		    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
		})
	@Operation(summary = "Get product by ID", description = "Retrieves a specific product using its unique identifier and returns 404 if the product is not found.")
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDto> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
	}
	
	//update product:
	@Operation(summary = "Update an existing product", description = "Updates the details of an existing product identified by its ID and returns the updated product data.")
	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequestDto request){
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, request));
	}
	
	//delete product:
	@Operation(summary = "Delete a product", description = "Removes a product from the catalog using its ID and returns no content if the deletion is successful.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}









