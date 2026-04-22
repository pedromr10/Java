package com.pedro.librarySystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.librarySystem.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
