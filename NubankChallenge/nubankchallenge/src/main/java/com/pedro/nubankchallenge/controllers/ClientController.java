package com.pedro.nubankchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.nubankchallenge.dtos.requests.ClientRequestDto;
import com.pedro.nubankchallenge.dtos.responses.ClientResponseDto;
import com.pedro.nubankchallenge.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	//cadastro de cliente:
	@PostMapping
	public ResponseEntity<ClientResponseDto> addClient(@RequestBody @Valid ClientRequestDto clientRequest){
		ClientResponseDto clientResponse = clientService.addClient(clientRequest);
		return ResponseEntity.status(201).body(clientResponse);
	}
	
	//listar todos os clientes (com seus contatos):
	@GetMapping
	public ResponseEntity<List<ClientResponseDto>> listAll(){
		return ResponseEntity.status(200).body(clientService.listAll());
	}
	
}
