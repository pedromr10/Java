package com.pedro.librarySystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.librarySystem.dtos.UserRequestDTO;
import com.pedro.librarySystem.dtos.UserResponseDTO;
import com.pedro.librarySystem.entities.User;
import com.pedro.librarySystem.mapping.UserMapper;
import com.pedro.librarySystem.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserMapper userMapper;
	
	//add user:
	public UserResponseDTO create(UserRequestDTO userRequest) {
		//email validation
		if (userRepo.existsByEmail(userRequest.getEmail())) {
		    throw new RuntimeException("Email already in use");
		}
		User user = userMapper.toEntity(userRequest);
		User savedUser = userRepo.save(user);
		return userMapper.toResponseDTO(savedUser);
	}
	
	//find all users:
	public List<UserResponseDTO> findAll(){
		return userRepo.findAll().stream().map(userMapper::toResponseDTO).toList();
	}
	
	//find user by id:
	public UserResponseDTO findById(Long id) {
		User user = userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
		return userMapper.toResponseDTO(user);
	}
	
	//delete user:
	public void delete(Long id) {
		User user = userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
		userRepo.delete(user);
	}
}
