package com.pedro.nubankchallenge.mappers;

import org.springframework.stereotype.Component;

import com.pedro.nubankchallenge.dtos.requests.ClientRequestDto;
import com.pedro.nubankchallenge.dtos.responses.ClientResponseDto;
import com.pedro.nubankchallenge.entities.Client;

@Component
public class ClientMapping {
	
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
		return clientResponse;
	}
}
