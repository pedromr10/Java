package com.pedro.librarySystem.dtos;

import com.pedro.librarySystem.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	

public class UserResponseDTO {
	private Long id;
	private String fullName;
	private String email;
	private UserRole role;
}
