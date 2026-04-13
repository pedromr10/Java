package com.pedro.eventHandler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.eventHandler.domain.Event;
import com.pedro.eventHandler.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;

	//get all events:
	@GetMapping
	public ResponseEntity<List<Event>> findAllEvents(){
		List<Event> allEventsList = eventService.findAllEvents();
		return ResponseEntity.ok(allEventsList);
	}
	
	//add event:
	@PostMapping
	public ResponseEntity<Event> addEvent(@RequestBody Event event){
		Event newEvent = new Event(null, event.getTitle(), event.getDescription(), event.getDate(), event.getType());
		
		eventService.addEvent(newEvent);
		return ResponseEntity.status(201).body(newEvent);
	}
}
