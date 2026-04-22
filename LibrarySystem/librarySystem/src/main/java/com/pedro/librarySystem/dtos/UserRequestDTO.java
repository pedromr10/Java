package com.pedro.librarySystem.dtos;

import com.pedro.librarySystem.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRequestDTO {
	
	@NotBlank(message = "{NotBlank.user.fullName}")
	private String fullName;
	@NotBlank(message = "{NotBlank.user.email}")
	@Email(message = "{Email.user.email}")
	private String email;
	@NotNull(message = "{NotNull.user.role}")
	private UserRole role;
}
