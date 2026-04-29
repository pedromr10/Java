package com.onlinestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.dtos.ProductResponseDto;
import com.onlinestore.entities.Product;
import com.onlinestore.mappers.ProductMapper;
import com.onlinestore.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductMapper mapper;
	
	//insert product:
	public ProductResponseDto createProduct(Product product) {
		Product newProduct = productRepo.save(product);
		return mapper.toResponse(newProduct);
	}
	
	//list all products:
	public List<ProductResponseDto> listAllProducts(){
		return productRepo.findAll().stream().map(mapper::toResponse).toList();
	}
	
	
	
	
	
}











