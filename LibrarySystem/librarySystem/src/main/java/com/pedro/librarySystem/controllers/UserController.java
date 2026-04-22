package com.pedro.librarySystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.librarySystem.dtos.UserRequestDTO;
import com.pedro.librarySystem.dtos.UserResponseDTO;
import com.pedro.librarySystem.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//add user:
	@PostMapping
	public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO userRequest){
		return ResponseEntity.status(201).body(userService.create(userRequest));
	}
	
	//find all users:
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> findAll(){
		return ResponseEntity.status(200).body(userService.findAll());
	}
	
	//find user by id:
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
		return ResponseEntity.status(200).body(userService.findById(id));
	}
	
	//delete user:
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.status(204).build();
	}
}







