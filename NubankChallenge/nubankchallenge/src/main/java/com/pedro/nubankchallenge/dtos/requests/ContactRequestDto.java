package com.pedro.nubankchallenge.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ContactRequestDto {
	@NotBlank(message = "{NotBlank.contact.email}")
	private String email;
	@NotBlank(message = "{NotBlank.contact.phoneNumber}")
	private String phoneNumber;
}
