package com.pedro.nubankchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.nubankchallenge.dtos.requests.ContactRequestDto;
import com.pedro.nubankchallenge.dtos.responses.ContactResponseDto;
import com.pedro.nubankchallenge.services.ContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	//cadastro de contato:
	@PostMapping("/{clientId}")
	public ResponseEntity<ContactResponseDto> addContact(@RequestBody @Valid ContactRequestDto contactRequest, @PathVariable Long clientId){
		ContactResponseDto contactResponse = contactService.addContact(contactRequest, clientId); 
		return ResponseEntity.status(201).body(contactResponse);
	}
	
	//listar todos os contatos de um cliente em especifico:
	@GetMapping("/{clientId}")
	public ResponseEntity<List<ContactResponseDto>> listContacts(@PathVariable Long clientId){
		return ResponseEntity.status(200).body(contactService.listContacts(clientId));
	}
}







