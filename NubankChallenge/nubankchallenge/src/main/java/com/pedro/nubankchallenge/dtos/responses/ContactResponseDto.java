package com.pedro.nubankchallenge.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ContactResponseDto {
	private Long id;
	private String email;
	private String phoneNumber;
}
