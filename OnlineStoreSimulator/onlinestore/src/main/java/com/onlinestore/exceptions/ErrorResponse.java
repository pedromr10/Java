package com.onlinestore.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "Error response returned by the API")
public class ErrorResponse{
	@Schema(example = "2026-05-04T13:57:55")
	private LocalDateTime timestamp;
	@Schema(example = "404")
	private Integer status;
	@Schema(example = "[\"Product not found\"]")
	private List<String> messages;
	@Schema(example = "/products/1")
	private String path;
}
