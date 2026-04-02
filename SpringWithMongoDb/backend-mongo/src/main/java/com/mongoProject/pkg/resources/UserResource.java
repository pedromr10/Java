package com.mongoProject.pkg.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mongoProject.pkg.domain.User;
import com.mongoProject.pkg.dto.UserDTO;
import com.mongoProject.pkg.services.UserService;

@RestController //resource ou controller - recebe requisicoes
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	//retorna todos os usuarios:
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).toList();
		return  ResponseEntity.ok().body(listDto);
	}
	
	//retorna o usuario desejado, pelo id:
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = userService.findById(id); 
		UserDTO userDto = new UserDTO(user);
		return ResponseEntity.ok().body(userDto);
	}
	
	//insere um usuario:
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO){
		User user = userService.fromDTO(userDTO); //transforma dto em user
		User savedUser = userService.insert(user); //insere o user
		UserDTO responseDtoUser = new UserDTO(savedUser); //cria um novo dto
	    URI uri = ServletUriComponentsBuilder
	            .fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(savedUser.getId())
	            .toUri(); //pega o path do usuario adicionado
		return ResponseEntity.created(uri).body(responseDtoUser);
	}
	
	//deleta um usuario:
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		userService.delete(id);
		return ResponseEntity.status(204).build();
		
		//obs: utiliza-se ".build()" quando nao quiser retornar um body
	}
	
	//atualiza um usuario:
	@PutMapping(value= "{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDto){
		User user = userService.fromDTO(userDto);
		user.setId(id);
		user = userService.update(user);
		return ResponseEntity.noContent().build();
	}
	
}
