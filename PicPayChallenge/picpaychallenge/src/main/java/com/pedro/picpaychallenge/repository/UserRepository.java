package com.pedro.picpaychallenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.picpaychallenge.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByCpf(String cpf);
	Optional<User> findByEmail(String email);
}
