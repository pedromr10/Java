package com.onlinestore.dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Schema(description = "Data required to create or update a product")
public class ProductRequestDto {
	@NotBlank(message = "Name cannot be blank")
	@Schema(description = "Product name", example = "Gaming Mouse")
	private String name;
	@NotBlank(message = "Description cannot be blank")
	@Schema(description = "Product description", example = "RGB wireless mouse")
	private String description;
	@Positive(message = "Price must be positive")
	@NotNull(message = "Price cannot be null")
	@Schema(description = "Product price", example = "199.90")
	private BigDecimal price;
	@PositiveOrZero(message = "Stock must be positive")
	@NotNull(message = "Stock cannot be null")
	@Schema(description = "Available stock quantity", example = "10")
	private Integer stock;
	
}
