package com.onlinestore.mappers;

import org.springframework.stereotype.Component;

import com.onlinestore.dtos.ProductRequestDto;
import com.onlinestore.dtos.ProductResponseDto;
import com.onlinestore.entities.Product;

@Component
public class ProductMapper {
	
	//request to entity:
	public Product toEntity(ProductRequestDto request) {
		Product product = new Product();
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
		product.setStock(request.getStock());
		
		return product;
	}
	
	//entity to response:
	public ProductResponseDto toResponse(Product product) {
		ProductResponseDto response = new ProductResponseDto();
		response.setId(product.getId());
		response.setName(product.getName());
		response.setDescription(product.getDescription());
		response.setPrice(product.getPrice());
		response.setStock(product.getStock());
		
		return response;
	}
	

}
