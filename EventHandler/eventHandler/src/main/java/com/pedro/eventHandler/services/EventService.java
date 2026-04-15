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
	
	//get event by id:
	public Event findEventById(Long id) {
		Event event = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
		return event;
	}
	
	//get all events:
	public List<Event> findAllEvents(){
		return eventRepo.findAll();
	}
	
	//add event:
	public Event addEvent(Event newEvent) {
		return eventRepo.save(newEvent);
	}
	
	//remove event:
	public void removeEvent(Long id) {
		Event toDeleteEvent = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found. Cannot delete"));
		eventRepo.deleteById(toDeleteEvent.getId());
	}
	
	//update event:
	public Event updateEvent(Long id, Event updatedEvent) {
		Event event = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found. Cannot update"));
		event.setTitle(updatedEvent.getTitle());
		event.setDescription(updatedEvent.getDescription());
		event.setDate(updatedEvent.getDate());
		event.setType(updatedEvent.getType());
		
		eventRepo.save(event);
		return event;
	}
	
	
	
}




