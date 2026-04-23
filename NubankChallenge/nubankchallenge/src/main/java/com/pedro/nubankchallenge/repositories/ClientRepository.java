package com.pedro.nubankchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.nubankchallenge.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
