package com.pedro.eventHandler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.eventHandler.domain.Event;
import com.pedro.eventHandler.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepo;
	
	//get all events:
	public List<Event> findAllEvents(){
		return eventRepo.findAll();
	}
	
	//add event:
	public Event addEvent(Event newEvent) {
		return eventRepo.save(newEvent);
	}
	
}
