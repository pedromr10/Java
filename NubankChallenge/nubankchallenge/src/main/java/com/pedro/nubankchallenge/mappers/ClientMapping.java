package com.pedro.nubankchallenge.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pedro.nubankchallenge.dtos.requests.ClientRequestDto;
import com.pedro.nubankchallenge.dtos.responses.ClientResponseDto;
import com.pedro.nubankchallenge.entities.Client;

@Component
public class ClientMapping {
	
	@Autowired
	private ContactMapping contactcMapper;
	
	public Client toEntity(ClientRequestDto clientRequest) {
		Client client = new Client();
		client.setName(clientRequest.getName());
		client.setAge(clientRequest.getAge());
		return client;
	}
	
	public ClientResponseDto toResponse(Client client) {
		ClientResponseDto clientResponse = new ClientResponseDto();
		clientResponse.setId(client.getId());
		clientResponse.setName(client.getName());
		clientResponse.setAge(client.getAge());
		clientResponse.setContacts(client.getContacts().stream().map(contactcMapper::toResponse).toList());
		return clientResponse;
	}
}
