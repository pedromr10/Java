package com.onlinestore.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponseDto {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer stock;
}
