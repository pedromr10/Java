package com.mongoProject.pkg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongoProject.pkg.domain.User;
import com.mongoProject.pkg.dto.UserDTO;
import com.mongoProject.pkg.repository.UserRepository;
import com.mongoProject.pkg.services.exception.ObjectNotFoundException;

@Service //logica de negocio
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	//retorna todos os usuarios:
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	//retorna o usuario desejado, pelo id:
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado."));
	
	}
	
	//insere um usuario:
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	//deleta um usuario:
	public void delete(String id) {
		findById(id); //precaucao caso o usuario nao exista
		userRepository.deleteById(id);
	}
	
	//atualiza um usuario:
	public User update(User user) {
		User newUser = userRepository.findById(user.getId()).orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado."));
		updateData(newUser, user);
		return userRepository.save(newUser);
	}
	
	//transforma userDto para user
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	//atualiza as informacoes do usuario
	public void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}
	
}
