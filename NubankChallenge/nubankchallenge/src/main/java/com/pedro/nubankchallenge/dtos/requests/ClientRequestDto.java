package com.pedro.nubankchallenge.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClientRequestDto {
	//tratar mensagens de erro ///**/*/*/*/*******
	@NotBlank
	private String name;
	@NotNull
	private Integer age;
}
