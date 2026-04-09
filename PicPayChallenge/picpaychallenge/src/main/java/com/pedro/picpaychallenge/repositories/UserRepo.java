package com.pedro.picpaychallenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.picpaychallenge.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	public Optional<User> findByEmail(String email);
	public Optional<User> findByCpf(String cpf);
}
