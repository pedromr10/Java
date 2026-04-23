package com.pedro.nubankchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.nubankchallenge.dtos.requests.ContactRequestDto;
import com.pedro.nubankchallenge.dtos.responses.ContactResponseDto;
import com.pedro.nubankchallenge.entities.Contact;
import com.pedro.nubankchallenge.mappers.ContactMapping;
import com.pedro.nubankchallenge.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepo;
	@Autowired
	private ContactMapping contactMapper;
	
	//cadastro de contato:
	public ContactResponseDto addContact(ContactRequestDto contactRequest) {
		Contact savedContact = contactRepo.save(contactMapper.toEntity(contactRequest));
		return contactMapper.toResponse(savedContact);
	}
	
	
	
}
