package com.pedro.nubankchallenge.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ContactRequestDto {
	@NotBlank //tratar mensagens de erro ///**/*/*/*/*******
	private String email;
	@NotBlank
	private String phoneNumber;
}
