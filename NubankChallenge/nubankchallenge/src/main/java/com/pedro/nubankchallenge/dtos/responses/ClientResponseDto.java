package com.pedro.nubankchallenge.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClientResponseDto {
	private Long id;
	private String name;
	private Integer age;
	
	private List<ContactResponseDto> contacts = new ArrayList<>();
}
