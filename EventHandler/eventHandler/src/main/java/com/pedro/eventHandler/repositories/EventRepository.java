package com.pedro.eventHandler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.eventHandler.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
	
}
