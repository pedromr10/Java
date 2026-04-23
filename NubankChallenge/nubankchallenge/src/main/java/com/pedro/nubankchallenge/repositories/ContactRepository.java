package com.pedro.nubankchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.nubankchallenge.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
