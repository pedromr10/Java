package com.pedro.nubankchallenge.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClientRequestDto {
	@NotBlank(message = "{NotBlank.client.name}")
	private String name;
	@NotNull(message = "{NotNull.client.age}")
	private Integer age;
}
