package com.onlinestore.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequestDto {
	@NotBlank(message = "Name cannot be blank")
	private String name;
	@NotBlank(message = "Description cannot be blank")
	private String description;
	@Positive(message = "Price must be positive")
	@NotNull(message = "Price cannot be null")
	private BigDecimal price;
	@PositiveOrZero(message = "Stock must be positive")
	@NotNull(message = "Stock cannot be null")
	private Integer stock;
	
}
