package com.pedro.librarySystem.mapping;

import org.springframework.stereotype.Component;

import com.pedro.librarySystem.dtos.UserRequestDTO;
import com.pedro.librarySystem.dtos.UserResponseDTO;
import com.pedro.librarySystem.entities.User;

@Component
public class UserMapper {
	
	public User toEntity(UserRequestDTO userDto) {
		User user = new User();
		user.setFullName(userDto.getFullName());
		user.setEmail(userDto.getEmail());
		user.setRole(userDto.getRole());
		return user;
	}
	
	public UserResponseDTO toResponseDTO(User user) {
		UserResponseDTO userResponse = new UserResponseDTO();
		userResponse.setId(user.getId());
		userResponse.setFullName(user.getFullName());
		userResponse.setEmail(user.getEmail());
		userResponse.setRole(user.getRole());
		return userResponse;
	}
}
