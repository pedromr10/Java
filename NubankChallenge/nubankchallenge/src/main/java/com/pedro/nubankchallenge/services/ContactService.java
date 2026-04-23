package com.pedro.nubankchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.nubankchallenge.dtos.requests.ContactRequestDto;
import com.pedro.nubankchallenge.dtos.responses.ContactResponseDto;
import com.pedro.nubankchallenge.entities.Client;
import com.pedro.nubankchallenge.entities.Contact;
import com.pedro.nubankchallenge.mappers.ContactMapping;
import com.pedro.nubankchallenge.repositories.ClientRepository;
import com.pedro.nubankchallenge.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepo;
	@Autowired
	private ContactMapping contactMapper;
	@Autowired
	private ClientRepository clientRepo;
	
	//cadastro de contato:
	public ContactResponseDto addContact(ContactRequestDto contactRequest, Long id) {
		Client client = clientRepo.findById(id).orElseThrow(()-> new RuntimeException("Client not found"));
		Contact contact = contactMapper.toEntity(contactRequest);
		contact.setClient(client);
		client.getContacts().add(contact);
		Contact savedContact = contactRepo.save(contact);
		return contactMapper.toResponse(savedContact);
	}
	
	//listar todos os contatos de um cliente em especifico:
	public List<ContactResponseDto> listContacts(Long id){
		Client client = clientRepo.findById(id).orElseThrow(()-> new RuntimeException("Client not found"));
		return client.getContacts().stream().map(contactMapper::toResponse).toList();
	}
	
	
	
}
