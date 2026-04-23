package com.pedro.nubankchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.nubankchallenge.dtos.requests.ClientRequestDto;
import com.pedro.nubankchallenge.dtos.responses.ClientResponseDto;
import com.pedro.nubankchallenge.entities.Client;
import com.pedro.nubankchallenge.mappers.ClientMapping;
import com.pedro.nubankchallenge.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private ClientMapping clientMapper;
	
	//cadastro de cliente:
	public ClientResponseDto addClient(ClientRequestDto clientRequest) {
		Client savedClient = clientRepo.save(clientMapper.toEntity(clientRequest));
		return clientMapper.toResponse(savedClient);
	}
	
	//listar todos os clientes (com seus contatos):
	public List<ClientResponseDto> listAll(){
		return clientRepo.findAll().stream().map(clientMapper::toResponse).toList();
	}
}
