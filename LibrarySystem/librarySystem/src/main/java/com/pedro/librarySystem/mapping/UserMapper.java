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
		UserResponseDTO userDto = new UserResponseDTO();
		userDto.setId(user.getId());
		userDto.setFullName(user.getFullName());
		userDto.setEmail(user.getEmail());
		userDto.setRole(user.getRole());
		return userDto;
	}
}
