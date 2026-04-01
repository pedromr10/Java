package com.mongoProject.pkg.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongoProject.pkg.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>>  findAll(){
		User alessandra = new User("1", "Alessandra Gerbelli", "a.gerbelli@gmail.com");
		User pedro = new User("1", "Pedro Munhoz", "pedro.munhoz@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(alessandra, pedro));
		return  ResponseEntity.ok().body(list);
	}
	
}
