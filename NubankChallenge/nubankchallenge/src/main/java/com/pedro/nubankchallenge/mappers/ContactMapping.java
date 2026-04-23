package com.pedro.nubankchallenge.mappers;

import org.springframework.stereotype.Component;

import com.pedro.nubankchallenge.dtos.requests.ContactRequestDto;
import com.pedro.nubankchallenge.dtos.responses.ContactResponseDto;
import com.pedro.nubankchallenge.entities.Contact;

@Component
public class ContactMapping {
	
	public Contact toEntity(ContactRequestDto contactRequest) {
		Contact contact = new Contact();
		contact.setEmail(contactRequest.getEmail());
		contact.setPhoneNumber(contactRequest.getPhoneNumber());
		return contact;
	}
	
	public ContactResponseDto toResponse(Contact contact) {
		ContactResponseDto contactResponse = new ContactResponseDto();
		contactResponse.setId(contact.getId());
		contactResponse.setEmail(contact.getEmail());
		contactResponse.setPhoneNumber(contact.getPhoneNumber());
		return contactResponse;
	}
}
